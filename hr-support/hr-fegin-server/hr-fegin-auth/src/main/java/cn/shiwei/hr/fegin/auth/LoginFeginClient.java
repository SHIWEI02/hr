package cn.shiwei.hr.fegin.auth;

import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.dto.LoginMealDto;
import cn.shiwei.hr.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "AUTH-SERVICE-SERVER", fallbackFactory = LoginFeginClientFallBackFactory.class )
@RequestMapping("/login")
public interface LoginFeginClient {

    @RequestMapping(value="/save",method= RequestMethod.POST)
    AjaxResult save(@RequestBody Login login);

    @RequestMapping(value="/entering",method= RequestMethod.POST)
    AjaxResult saveLoginAndMeal(@RequestBody LoginMealDto loginMealDto);
}
