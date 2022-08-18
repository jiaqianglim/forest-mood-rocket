package cafefashionsociety.structureliteraturemeadow.development;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.service.IQuoteService;

@Service
@Profile("dev")
public class QuoteServiceDev implements IQuoteService{

    @Override
    public Quote getRandomQuote() {
        Quote quote = new Quote("God is dead and we killed him", "Nietzche");
        return quote;
    }

}
