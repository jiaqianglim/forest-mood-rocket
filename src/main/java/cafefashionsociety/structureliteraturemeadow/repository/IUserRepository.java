package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {

    public Optional<User> findById(String id);

    public Optional<User> findByUsername(String username);

    public <S extends User> S save(S entity);

}
