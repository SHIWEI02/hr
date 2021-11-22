package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.mapper.LoginMapper;
import cn.shiwei.hr.service.ILoginService;
import cn.shiwei.hr.service.IMealService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录表 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

    @Autowired
    private IMealService mealService;

    @Override
    public Long saveLoginAndMeal(Login login, Long mealId) {
        // 初始化login
        login.setEnabled(true);
        login.setAccountNonExpired(true);
        login.setAccountNonLocked(true);
        login.setCredentialsNonExpired(true);
        // TODO 密码加密

        // 保存login
        baseMapper.insert(login);

        // 保存套餐
        Long loginId = login.getId();
        mealService.saveRelationWithLogin(loginId, mealId);
        return loginId;
    }
}
