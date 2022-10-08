package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.UserList;

@Repository
public class UserListRepository {

    @Autowired
    RedisTemplate redisTemplate;

    public void save(UserList userlists) {
        redisTemplate.opsForValue().set(userlists.getId(), userlists);

    }

    public Optional<UserList> findById(String id) {
        return Optional.ofNullable((UserList) redisTemplate.opsForValue().get(id));
    }
}
