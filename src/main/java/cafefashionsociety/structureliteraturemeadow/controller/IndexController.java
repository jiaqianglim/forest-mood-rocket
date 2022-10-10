package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;

import org.springframework.web.bind.annotation.GetMapping;

@Layout
@Controller
public class IndexController {
    
    @Autowired
    QuoteService quoteService;

    @GetMapping(path = "/")
    public String indexPage(Model model) {
        model.addAttribute("title", "Track.Record");
        return "index";
    }

    @GetMapping(path = "/docs")
    public String docPage() {
        return "main/docs";
    }

    @GetMapping(path = "/about")
    public String aboutPage(Model model) {
        Quote quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        return "main/about";
    }

}
