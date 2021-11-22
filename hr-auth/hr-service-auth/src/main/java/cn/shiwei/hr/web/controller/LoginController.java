package cn.shiwei.hr.web.controller;

import cn.shiwei.hr.dto.LoginMealDto;
import cn.shiwei.hr.service.ILoginService;
import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.query.LoginQuery;
import cn.shiwei.hr.util.AjaxResult;
import cn.shiwei.hr.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    public ILoginService loginService;

    /**
    * 保存和修改
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Login login){
        if(login.getId()!=null){
            loginService.updateById(login);
        }else{
            loginService.insert(login);
        }
        return AjaxResult.me();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        loginService.deleteById(id);
        return AjaxResult.me();
    }

   /**
   * 根据ID获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult get(@PathVariable("id")Long id){
        return AjaxResult.me().setResultObj(loginService.selectById(id));
    }


    /**
    * 获取所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public AjaxResult list(){
        return AjaxResult.me().setResultObj(loginService.selectList(null));
    }

    /**
    * 分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public AjaxResult json(@RequestBody LoginQuery query){
        Page<Login> page = new Page<Login>(query.getPage(),query.getRows());
        page = loginService.selectPage(page);
        PageList pageList = new PageList<Login>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }

    /**
     * 用于机构注册时, 保存login和套餐
     * @return
     */
    @RequestMapping(value="/entering",method= RequestMethod.POST)
    AjaxResult saveLoginAndMeal(@RequestBody LoginMealDto loginMealDto){
        Login login = loginMealDto.getLogin();
        Long mealId = loginMealDto.getMealId();
        Long loginResult = loginService.saveLoginAndMeal(login, mealId);
        return AjaxResult.me().setSuccess(true).setResultObj(loginResult);
    }
}
