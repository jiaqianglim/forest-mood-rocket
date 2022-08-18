package cafefashionsociety.structureliteraturemeadow.development;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cafefashionsociety.structureliteraturemeadow.repository.IRedisRepo;

@Component
@Profile("dev")
public class RedisRepoDev implements IRedisRepo {

}
