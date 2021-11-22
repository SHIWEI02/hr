package cn.shiwei.hr.service;

import cn.shiwei.hr.domain.Tenant;
import cn.shiwei.hr.dto.TenantRegisterDto;
import cn.shiwei.hr.util.AjaxResult;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
public interface ITenantService extends IService<Tenant> {

    void entering(TenantRegisterDto registerDto);
}
