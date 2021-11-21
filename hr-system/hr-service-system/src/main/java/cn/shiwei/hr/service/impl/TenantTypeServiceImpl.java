package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.TenantType;
import cn.shiwei.hr.mapper.TenantTypeMapper;
import cn.shiwei.hr.service.ITenantTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户(机构)类型表 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
