package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.Config;
import cn.shiwei.hr.mapper.ConfigMapper;
import cn.shiwei.hr.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
