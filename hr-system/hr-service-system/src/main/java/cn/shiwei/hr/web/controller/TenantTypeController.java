package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.ITenantTypeService;
import cn.shiwei.hr.domain.TenantType;
import cn.shiwei.hr.query.TenantTypeQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenantType")
public class TenantTypeController {
    @Autowired
    public ITenantTypeService tenantTypeService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody TenantType tenantType){
        if(tenantType.getId()!=null){
            tenantTypeService.updateById(tenantType);
        }else{
            tenantTypeService.insert(tenantType);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        tenantTypeService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(tenantTypeService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(tenantTypeService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody TenantTypeQuery query){
        Page<TenantType> page = new Page<TenantType>(query.getPage(),query.getRows());
        page = tenantTypeService.selectPage(page);
        PageList pageList = new PageList<TenantType>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
