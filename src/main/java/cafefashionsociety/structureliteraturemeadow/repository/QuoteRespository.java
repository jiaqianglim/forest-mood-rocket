package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Repository
public class QuoteRespository {

    @Autowired
    RedisTemplate redisTemplate;

    public void saveAll(List<Quote> quotes) {
        for (Quote quote : quotes) {
            redisTemplate.opsForValue().set(quote.getQuoteid(), quote);
        }
    }

    public Optional<Quote> findById(String id) {
        return Optional.of((Quote) redisTemplate.opsForValue().get(id));
    }

}
