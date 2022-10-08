package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.LinkedList;
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

    public Optional<Dossier> findDossierById(String id) {
        Optional<Dossier> dossier = Optional.ofNullable((Dossier) redisTemplate.opsForValue().get(id));
        return dossier;
    }

    public LinkedList<Dossier> findAllByIds(List<String> ids){
        LinkedList<Dossier> dossiers = (LinkedList<Dossier>)redisTemplate.opsForValue().multiGet(ids);
        return dossiers;
    }

    public void addNoteId(String dossierId, String noteid) {
        redisTemplate.opsForList().leftPush(dossierId, noteid);
    }

    public void save(Dossier dossier) {
        redisTemplate.opsForValue().set(dossier.getId(), dossier);
    }
}
