package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.ILoginLogService;
import cn.shiwei.hr.domain.LoginLog;
import cn.shiwei.hr.query.LoginLogQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loginLog")
public class LoginLogController {
    @Autowired
    public ILoginLogService loginLogService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody LoginLog loginLog){
        if(loginLog.getId()!=null){
            loginLogService.updateById(loginLog);
        }else{
            loginLogService.insert(loginLog);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        loginLogService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(loginLogService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(loginLogService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody LoginLogQuery query){
        Page<LoginLog> page = new Page<LoginLog>(query.getPage(),query.getRows());
        page = loginLogService.selectPage(page);
        PageList pageList = new PageList<LoginLog>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
