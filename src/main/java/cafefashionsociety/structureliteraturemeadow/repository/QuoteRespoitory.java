package cafefashionsociety.structureliteraturemeadow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Repository
public class QuoteRespoitory {

    @Autowired
    private RedisTemplate<String, Quote> redisTemplate;

    public Quote getQuoteById(String id) {
        return (Quote) redisTemplate.opsForValue().get(id);
    }

    public Quote save(Quote quote) {
        redisTemplate.opsForValue().set(quote.getQuoteid(), quote);
        return (Quote) redisTemplate.opsForValue().get(quote.getQuoteid());
    }

}
