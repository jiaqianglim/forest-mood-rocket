package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Report;

@Repository
public interface IReportRepository extends CrudRepository<Report, String> {

    public <S extends Report> S save(S entity);
    public Optional<Report> findById(String id);
    
}
