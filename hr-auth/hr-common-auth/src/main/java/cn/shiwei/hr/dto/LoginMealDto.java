package cn.shiwei.hr.dto;

import cn.shiwei.hr.domain.Login;
import lombok.Data;

@Data
public class LoginMealDto {
    private Login login;
    private Long mealId;

    public LoginMealDto(Login login, Long mealId) {
        this.login = login;
        this.mealId = mealId;
    }
    public LoginMealDto(){}

}
