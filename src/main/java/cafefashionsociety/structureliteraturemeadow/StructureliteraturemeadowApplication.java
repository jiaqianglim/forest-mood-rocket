package cafefashionsociety.structureliteraturemeadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@ComponentScan(basePackages = "cafefashionsociety.HTTPRequesttoExternalRESTfulAPI")
public class StructureliteraturemeadowApplication {

	public static void main(String[] args) {
		SpringApplication.run(StructureliteraturemeadowApplication.class, args);
	}

}
