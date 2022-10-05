package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Repository
public interface IQuoteRespoitory extends CrudRepository<Quote, String> {

    public <S extends Quote> Iterable<S> saveAll(Iterable<S> entities);
    @Cacheable
    public Optional<Quote> findById(String id);

}
