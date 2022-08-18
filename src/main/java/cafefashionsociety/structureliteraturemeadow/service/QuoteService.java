package cafefashionsociety.structureliteraturemeadow.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Service
@Profile("dev")
public class QuoteService implements IQuoteService {

    public Quote getRandomQuote() {

        Quote quote = new Quote();
        Quote backupQuote = new Quote("God is dead and we killed him", "Nietzche");
        // TODO
        return (quote.getQuotetext() != null) ? quote : backupQuote;

    }

    public Quote getQuoteById(String Id) {
        Quote quote = new Quote();
        // TODO
        return quote;
    }
}
