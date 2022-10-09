package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.repository.QuoteRespository;

@Service
public class QuoteService {
    @Autowired
    QuoteRespository quoteRespository;

    public Quote getQuoteById(String id) {
        try {
            Optional<Quote> opt = quoteRespository.findById("q" + id);
            if (opt.isPresent()) {
                return new Quote("q1",
                        "Learn to enjoy every minute of your life. Be happy now. Don\'t wait for something outside of yourself to make you happy in the future.",
                        "Earl Nightingal");
            } else {
                return opt.get();
            }

        } catch (Exception e) {
            return new Quote("q1",
                    "People will forget what you said, people will forget what you did, but people will never forget how you made them feel.",
                    "Maya Angelou");
        }
    }

    public Quote getRandomQuote() {
        Random r = new Random();
        try {
            Optional<Quote> opt = quoteRespository.findById("q" + String.valueOf(r.nextInt(50)));
            if (!opt.isPresent()) {
                return new Quote("q1",
                        "Learn to enjoy every minute of your life. Be happy now. Don\'t wait for something outside of yourself to make you happy in the future.",
                        "Earl Nightingal");
            } else {
                return opt.get();
            }

        } catch (Exception e) {
            return new Quote("q1",
                    "Quote Error",
                    "Placeholder");
        }
    }

    public void saveAll(LinkedList<Quote> quotes) {
        quoteRespository.saveAll(quotes);
    }

}
