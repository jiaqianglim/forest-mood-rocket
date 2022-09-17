package cafefashionsociety.structureliteraturemeadow.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilityBeans {

    @Bean
    public String createUUIDString() {
        return UUID.randomUUID().toString();
    }


}
