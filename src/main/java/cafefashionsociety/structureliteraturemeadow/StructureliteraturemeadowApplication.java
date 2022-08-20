package cafefashionsociety.structureliteraturemeadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableRedisDocumentRepositories(basePackages = "cafefashionsociety.structureliteraturemeadow.*")
public class StructureliteraturemeadowApplication {

	public static void main(String[] args) {
		SpringApplication.run(StructureliteraturemeadowApplication.class, args);
	}

}
