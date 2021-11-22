package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.constant.BaseConstants;
import cn.shiwei.hr.domain.Meal;
import cn.shiwei.hr.mapper.MealMapper;
import cn.shiwei.hr.service.IMealService;
import cn.shiwei.hr.util.AjaxResult;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 套餐表 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {

    @Autowired
    private MealMapper mealMapper;

    @Override
    public void saveRelationWithLogin(Long loginId, Long mealId) {
        Date expireTime = DateUtils.addDays(new Date(), 7);
        mealMapper.saveRelationWithLogin(
                mealId,
                loginId,
                expireTime,
                BaseConstants.Meal.STATUS_UNPAID
        );
    }
}
