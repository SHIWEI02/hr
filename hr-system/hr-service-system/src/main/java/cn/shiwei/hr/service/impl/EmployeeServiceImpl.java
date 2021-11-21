package cn.shiwei.hr.service.impl;

import cn.shiwei.hr.domain.Employee;
import cn.shiwei.hr.mapper.EmployeeMapper;
import cn.shiwei.hr.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1363732197@qq.com
 * @since 2021-11-21
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
