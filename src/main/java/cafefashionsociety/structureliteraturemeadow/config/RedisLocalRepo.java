package cafefashionsociety.structureliteraturemeadow.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class RedisLocalRepo implements IRedisRepo {

}
