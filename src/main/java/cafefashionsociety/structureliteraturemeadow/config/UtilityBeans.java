package cafefashionsociety.structureliteraturemeadow.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilityBeans {
    public Logger logger = LoggerFactory.getLogger(UtilityBeans.class);

    public String createUUIDString() {
        String uuid = UUID.randomUUID().toString();
        logger.info("New uuid: " + uuid);
        return uuid;
    }

}
