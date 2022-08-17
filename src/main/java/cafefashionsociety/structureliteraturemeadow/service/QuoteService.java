package cafefashionsociety.structureliteraturemeadow.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.serviceutilities.IGet1MQuote;

@Service
public class QuoteService {
    
    private IGet1MQuote get1mQuote;

    public String[] returnquote(){
        
        return get1mQuote.getquote();

    }
}
