package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.User;

@Repository
public class UserRepository {

    @Autowired
    RedisTemplate redisTemplate;

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable((User) redisTemplate.opsForValue().get(username));
    }

    public void save(User user) {
        redisTemplate.opsForValue().set(user.getUsername(), user);
    }

}
