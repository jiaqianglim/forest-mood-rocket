package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.repository.QuoteRespoitory;

@Service
public class QuoteService {
    @Autowired
    QuoteRespoitory quoteRespoitory;

    public Quote getQuoteById(String id) {
        Optional opt = quoteRespoitory.findById(id);
        if (!opt.isEmpty()) {
            return (Quote) opt.get();
        } else {
            return new Quote("q1",
                    "Learn to enjoy every minute of your life. Be happy now. Don\'t wait for something outside of yourself to make you happy in the future.",
                    "Earl Nightingal");
        }
    }

    public Quote getRandomQuote() {
        Random r = new Random();
        Optional opt = quoteRespoitory.findById("q" + String.valueOf(r.nextInt(50)));
        if (!opt.isEmpty()) {
            return (Quote) opt.get();
        } else {
            return new Quote("q1",
                    "Learn to enjoy every minute of your life. Be happy now. Don\'t wait for something outside of yourself to make you happy in the future.",
                    "Earl Nightingal");
        }
    }

    public void saveAll(LinkedList<Quote> quotes) {
        quoteRespoitory.saveAll(quotes);
    }

}
