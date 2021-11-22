package cn.shiwei.hr.dto;

import cn.shiwei.hr.domain.Employee;
import cn.shiwei.hr.domain.Login;
import cn.shiwei.hr.domain.Tenant;
import lombok.Data;

@Data
public class TenantRegisterDto {

    /**
     * 管理员(员工)账号
     */
    private Employee employee;
    /**
     * 机构
     */
    private Tenant tenant;
    /**
     * 登录
     */
    private Login login;

    /**
     * 套餐id
     */
    private Long mealId;
}
