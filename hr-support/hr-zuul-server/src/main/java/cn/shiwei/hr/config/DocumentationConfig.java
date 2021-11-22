package cn.shiwei.hr.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
       List resources = new ArrayList<>();
       // TODO 添加不同微服的swagger 用于聚合
        // location 只修改 /**/**/v2/api-docs (/前缀/服务别名/固定)
       resources.add(swaggerResource("系统管理中心", "/hr/system/v2/api-docs", "2.0"));
        resources.add(swaggerResource("认证管理中心", "/hr/auth/v2/api-docs", "2.0"));
       return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
