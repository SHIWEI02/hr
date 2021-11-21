package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.service.IConfigService;
import cn.shiwei.hr.domain.Config;
import cn.shiwei.hr.query.ConfigQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    public IConfigService configService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Config config){
        if(config.getId()!=null){
            configService.updateById(config);
        }else{
            configService.insert(config);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        configService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(configService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(configService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody ConfigQuery query){
        Page<Config> page = new Page<Config>(query.getPage(),query.getRows());
        page = configService.selectPage(page);
        PageList pageList = new PageList<Config>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
