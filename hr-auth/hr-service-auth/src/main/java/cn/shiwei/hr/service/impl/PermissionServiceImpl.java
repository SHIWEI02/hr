package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.Permission;
import cn.shiwei.hr.mapper.PermissionMapper;
import cn.shiwei.hr.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-22
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
