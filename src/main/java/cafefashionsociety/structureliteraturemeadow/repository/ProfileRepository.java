package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Profile;

@Repository
public class ProfileRepository {

    @Autowired
    RedisTemplate redisTemplate;

    public void save(Profile profile) {
        redisTemplate.opsForValue().set(profile.getId(), profile);
    }

    public Optional<Profile> findById(String id) {
        return Optional.of((Profile) redisTemplate.opsForValue().get(id));
    }

    public List<Profile> findAllById(List<String> ids) {
        return (List<Profile>) redisTemplate.opsForValue().multiGet(ids);
    }
}
