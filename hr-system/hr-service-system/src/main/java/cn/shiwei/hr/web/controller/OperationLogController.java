package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.IOperationLogService;
import cn.shiwei.hr.domain.OperationLog;
import cn.shiwei.hr.query.OperationLogQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    @Autowired
    public IOperationLogService operationLogService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody OperationLog operationLog){
        if(operationLog.getId()!=null){
            operationLogService.updateById(operationLog);
        }else{
            operationLogService.insert(operationLog);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        operationLogService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(operationLogService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(operationLogService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody OperationLogQuery query){
        Page<OperationLog> page = new Page<OperationLog>(query.getPage(),query.getRows());
        page = operationLogService.selectPage(page);
        PageList pageList = new PageList<OperationLog>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
