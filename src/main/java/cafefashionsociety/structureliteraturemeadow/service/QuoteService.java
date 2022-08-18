package cafefashionsociety.structureliteraturemeadow.service;

import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Quote;

@Service
public class QuoteService implements IQuoteService{

    public Quote getquote(){

        Quote quote = new Quote();
        Quote backupQuote = new Quote("God is dead and we killed him", "Nietzche");
        // TODO
        return (quote.getQuotetext() != null) ? quote : backupQuote;

    }
}
