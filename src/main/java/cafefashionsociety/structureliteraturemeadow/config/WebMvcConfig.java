package cafefashionsociety.structureliteraturemeadow.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }
}
