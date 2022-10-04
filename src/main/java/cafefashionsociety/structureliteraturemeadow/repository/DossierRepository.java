package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Repository
public class DossierRepository {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public List<String> getDossierListById(String id) {
        List<String> dossier = (List<String>) redisTemplate.opsForValue().get(id);
        return dossier;
    }

    public void addNoteId(String dossierId, String noteid) {
        redisTemplate.opsForList().leftPush(dossierId, noteid);
    }

    public void save(Dossier dossier) {
        redisTemplate.opsForValue().set(dossier.getId(), dossier.getNoteIds());
    }
}
