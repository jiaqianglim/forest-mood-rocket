package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.repository.QuoteRespoitory;

public class QuoteService {
    @Autowired
    QuoteRespoitory quoteRespoitory;
    
    public Quote getQuoteById(String id){
        return quoteRespoitory.getQuoteById(id);
    }

    public Quote getRandomQuote(){
        Random r = new Random();
        return quoteRespoitory.getQuoteById("q"+String.valueOf(r.nextInt(50)));
    }

    public void save(Quote quote){
        quoteRespoitory.save(quote);
    }

    public void saveListOfQuotes(List<Quote> quotes){
        for(int i=0; i < quotes.size(); i++){
            try{
                quoteRespoitory.save(quotes.get(i));
            }catch(Exception e){
                continue;
            }
        }
    }
}
