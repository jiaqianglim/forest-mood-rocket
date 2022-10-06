package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Repository
public class DossierRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    public Optional<Dossier> getDossierById(String id) {
        Optional<Dossier> dossier = Optional.ofNullable((Dossier) redisTemplate.opsForValue().get(id));
        return dossier;
    }

    public void addNoteId(String dossierId, String noteid) {
        redisTemplate.opsForList().leftPush(dossierId, noteid);
    }

    public Dossier save(Dossier dossier) {
        redisTemplate.opsForValue().set(dossier.getId(), dossier.getNoteIds());
        Dossier savedDossier = (Dossier) redisTemplate.opsForValue().get(dossier.getId());
        return savedDossier;
    }
}
