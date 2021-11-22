package cn.shiwei.hr.fegin.auth;

import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.dto.LoginMealDto;
import cn.shiwei.hr.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginFeginClientFallBackFactory implements FallbackFactory<LoginFeginClient> {
    @Override
    public LoginFeginClient create(Throwable throwable) {
        return new LoginFeginClient() {
            @Override
            public AjaxResult save(Login login) {
                // 打印日志
                log.error("远程调用认证中心, 保存login发生异常:{}", throwable);
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("远程调用认证中心, 保存login发生异常");
            }

            @Override
            public AjaxResult saveLoginAndMeal(LoginMealDto loginMealDto) {
                // 打印日志
                log.error("远程调用认证中心, 保存login发生异常:{}", throwable);
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("远程调用认证中心, 保存login发生异常");
            }
        };
    }
}
