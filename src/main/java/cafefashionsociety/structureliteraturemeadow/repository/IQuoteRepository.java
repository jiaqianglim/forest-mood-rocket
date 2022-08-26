package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Repository
public interface IQuoteRepository extends CrudRepository<Quote, String> {

}
