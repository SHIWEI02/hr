package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.OperationLog;
import cn.shiwei.hr.mapper.OperationLogMapper;
import cn.shiwei.hr.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}
