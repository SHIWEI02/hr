package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.constant.BaseConstants;
import cn.shiwei.hr.domain.Employee;
import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.domain.Meal;
import cn.shiwei.hr.domain.Tenant;
import cn.shiwei.hr.dto.LoginMealDto;
import cn.shiwei.hr.dto.TenantRegisterDto;
import cn.shiwei.hr.fegin.auth.LoginFeginClient;
import cn.shiwei.hr.mapper.TenantMapper;
import cn.shiwei.hr.service.IEmployeeService;
import cn.shiwei.hr.service.ITenantService;
import cn.shiwei.hr.util.AjaxResult;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

    @Autowired
    private LoginFeginClient loginFeginClient;

    @Autowired
    private IEmployeeService employeeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void entering(TenantRegisterDto registerDto) {
        /*
         * 校验参数: 判断参数非空, 判断两次密码, 判断手机号, 商铺名称, 商铺执照, username是否被注册
         * 保存login表(其他表有它外键)
         * 保存机构套餐关系
         * 保存管理员emp账号
         * 保存机构
         */
        Login login = registerDto.getLogin();
        Employee employee = registerDto.getEmployee();
        Tenant tenant = registerDto.getTenant();
        Long mealId = registerDto.getMealId();

        // 非空校验
        if(
                StringUtils.isEmpty(login.getUsername()) ||
                        StringUtils.isEmpty(login.getPassword()) ||
                        StringUtils.isEmpty(employee.getRealName()) ||
                        StringUtils.isEmpty(employee.getRealName()) ||
                        StringUtils.isEmpty(employee.getTel()) ||
                        StringUtils.isEmpty(employee.getEmail()) ||
                        StringUtils.isEmpty(tenant.getCompanyName()) ||
                        StringUtils.isEmpty(tenant.getCompanyNum()) ||
                        StringUtils.isEmpty(tenant.getAddress()) ||
                        StringUtils.isEmpty(tenant.getLogo()) ||
                        tenant.getTenantTypeId() == null ||
                        mealId == null
                ){
            throw new RuntimeException("参数不能为空");
        }

        // TODO 判断手机号, 商铺名称, 商铺执照, username是否被注册

        // 保存login信息, 远程调用openfegin
        login.setType(BaseConstants.Login.TYPE_ACCOUNT_BACKSTAGE); // 设置为后台账号
        AjaxResult ajaxResult = loginFeginClient.saveLoginAndMeal(new LoginMealDto(login, mealId));
        if (!ajaxResult.isSuccess() || ajaxResult.getResultObj() == null) { // 如果为操作成功(没降级)
            throw new RuntimeException("保存用户登录信息失败");
        }
        // 获取loginid
        Long LoginId = Long.valueOf(ajaxResult.getResultObj().toString());

        employee.setLoginId(LoginId);
        employee.setState(BaseConstants.Employee.STATUS_NORMAL);
        employee.setType(BaseConstants.Employee.TYPE_TENANT_ADMIN);
        employeeService.insert(employee);

        // 保存机构
        tenant.setRegisterTime(new Date());
        tenant.setAdminId(employee.getId());
        tenant.setState(BaseConstants.Tenant.STATUS_CHECK);

        baseMapper.insert(tenant);
        employee.setTenantId(tenant.getId());
        employeeService.updateById(employee);
    }
}
