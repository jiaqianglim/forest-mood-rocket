package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;

import com.redis.om.spring.repository.RedisDocumentRepository;

import cafefashionsociety.structureliteraturemeadow.model.User;

public interface IUserRepository extends RedisDocumentRepository<User, String> {

    User findByUsername(String username);
}
