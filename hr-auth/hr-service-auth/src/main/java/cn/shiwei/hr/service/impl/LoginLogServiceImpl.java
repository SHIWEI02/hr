package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.LoginLog;
import cn.shiwei.hr.mapper.LoginLogMapper;
import cn.shiwei.hr.service.ILoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
