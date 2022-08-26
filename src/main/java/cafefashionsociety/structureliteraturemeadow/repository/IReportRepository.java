package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Report;

@Repository
public interface IReportRepository extends CrudRepository<Report, String> {
    
}
