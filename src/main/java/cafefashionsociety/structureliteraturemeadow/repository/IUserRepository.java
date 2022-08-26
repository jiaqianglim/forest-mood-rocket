package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {
    public User findByUsername(String username);
}
