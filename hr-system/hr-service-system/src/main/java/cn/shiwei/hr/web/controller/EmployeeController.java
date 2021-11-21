package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.IEmployeeService;
import cn.shiwei.hr.domain.Employee;
import cn.shiwei.hr.query.EmployeeQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public IEmployeeService employeeService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Employee employee){
        if(employee.getId()!=null){
            employeeService.updateById(employee);
        }else{
            employeeService.insert(employee);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(employeeService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(employeeService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody EmployeeQuery query){
        Page<Employee> page = new Page<Employee>(query.getPage(),query.getRows());
        page = employeeService.selectPage(page);
        PageList pageList = new PageList<Employee>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
