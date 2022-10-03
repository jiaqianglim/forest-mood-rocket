package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Note;

@Repository
public interface INoteRepository extends CrudRepository<Note, String> {

    public <S extends Note> S save(S entity);
    public Optional<Note> findById(String id);
    
}
