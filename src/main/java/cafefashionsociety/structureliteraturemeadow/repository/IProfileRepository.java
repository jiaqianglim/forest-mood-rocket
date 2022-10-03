package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Profile;

@Repository
public interface IProfileRepository extends CrudRepository<Profile, String> {
    public <S extends Profile> S save(S entity);
    public Optional<Profile> findById(String id);
    public Iterable<Profile> findAllById(Iterable<String> ids);
}
