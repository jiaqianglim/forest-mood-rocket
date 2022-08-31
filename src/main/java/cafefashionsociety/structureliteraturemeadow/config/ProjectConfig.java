package cafefashionsociety.structureliteraturemeadow.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;

@Configuration
public class ProjectConfig {

    @Bean
    public String createUUIDString() {
        return UUID.randomUUID().toString();
    }


}
