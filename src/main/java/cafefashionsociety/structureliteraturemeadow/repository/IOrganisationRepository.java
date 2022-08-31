package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Organisation;

@Repository
public interface IOrganisationRepository extends CrudRepository<Organisation, String> {
    public <S extends Organisation> S save(S entity);
}
