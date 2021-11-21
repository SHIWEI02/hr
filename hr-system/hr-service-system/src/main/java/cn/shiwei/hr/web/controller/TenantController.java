package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.ITenantService;
import cn.shiwei.hr.domain.Tenant;
import cn.shiwei.hr.query.TenantQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    public ITenantService tenantService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Tenant tenant){
        if(tenant.getId()!=null){
            tenantService.updateById(tenant);
        }else{
            tenantService.insert(tenant);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        tenantService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(tenantService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(tenantService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody TenantQuery query){
        Page<Tenant> page = new Page<Tenant>(query.getPage(),query.getRows());
        page = tenantService.selectPage(page);
        PageList pageList = new PageList<Tenant>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
