package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Repository
public class DossierRepository {

    public Logger logger = LoggerFactory.getLogger(DossierRepository.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public Optional<Dossier> findById(String id) {
        Optional<Dossier> dossier = Optional.ofNullable((Dossier) redisTemplate.opsForValue().get(id));
        return dossier;
    }

    public List<Dossier> findAllByIds(List<String> ids) {
        logger.info("getting dossiers");
        List<Dossier> dossiers = (List<Dossier>) redisTemplate.opsForValue().multiGet(ids);
        logger.info("successful getting dossiers");
        return dossiers;
    }

    public void save(Dossier dossier) {
        redisTemplate.opsForValue().set(dossier.getId(), dossier);
    }
}
