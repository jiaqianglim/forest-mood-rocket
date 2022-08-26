package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Profile;

@Repository
public interface IProfileRepository extends CrudRepository<Profile, String> {
    
}
