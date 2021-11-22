package cn.shiwei.hr.mapper;

import cn.shiwei.hr.domain.Meal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 * 套餐表 Mapper 接口
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
public interface MealMapper extends BaseMapper<Meal> {

    void saveRelationWithLogin(@Param("mealId") Long mealId, @Param("loginId") Long loginId, @Param("expireTime") Date expireTime, @Param("state") int state);
}
