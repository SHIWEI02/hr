package cn.shiwei.hr.service;

import cn.shiwei.hr.domain.Login;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 登录表 服务类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
public interface ILoginService extends IService<Login> {

    Long saveLoginAndMeal(Login login, Long mealId);
}
