package cn.shiwei.hr.service;

import cn.shiwei.hr.domain.Meal;
import cn.shiwei.hr.util.AjaxResult;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 套餐表 服务类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
public interface IMealService extends IService<Meal> {

    void saveRelationWithLogin(Long loginId, Long mealId);
}
