package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;

@Layout
@Controller
public class LoginController {

    @Autowired
    QuoteService quoteService;

    @GetMapping(path = "/login")
    public String loginGet(Model model) {
        Quote quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        model.addAttribute("title", "Login");
        return "login";
    }

}
