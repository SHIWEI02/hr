package cn.shiwei.hr.constant;

// 注意引用类型不能在内部类中静态声明
public class BaseConstants {

    public class Login {
        /**
         * 0是后台，1是前台
         */
        public static final int TYPE_ACCOUNT_BACKSTAGE = 0;
        public static final int TYPE_ACCOUNT_FRONTDESK = 1;
    }

    public class Meal {
        /**
         * 状态,是否过期 0 未支付，1已经购买，2过期
         */
        public static final int STATUS_UNPAID = 0;
        public static final int STATUS_PURCHASED = 1;
        public static final int STATUS_EXPIRED = 2;
    }

    public class Employee {
        /**
         * 状态：0正常，1锁定，2注销
         */
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_LOCKED = 1;
        public static final int STATUS_LOGOUT = 2;

        /**
         * 员工类型 ， 1平台普通员工 ，2平台客服人员，3平台管理员，4机构员工，5,机构管理员或其他
         */
        public static final int TYPE_PLATFORM_EMPLOYEE = 1;
        public static final int TYPE_PLATFORM_CUSTOMERSERVICE = 2;
        public static final int TYPE_PLATFORM_ADMIN = 3;
        public static final int TYPE_TENANT_ADMIN = 4;
        public static final int TYPE_TENANT_EMPLOYEE = 5;
    }

    public class Tenant {
        /**
         * 0待审核，1 审核通过 ， 2审核失败
         */
        public static final int STATUS_CHECK = 0;
        public static final int STATUS_APPROVED = 1;
        public static final int STATUS_REVIEWFAILED = 2;
    }







}
