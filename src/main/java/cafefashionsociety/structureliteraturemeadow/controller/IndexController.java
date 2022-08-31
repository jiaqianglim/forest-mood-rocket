package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import cafefashionsociety.structureliteraturemeadow.config.Layout;

import org.springframework.web.bind.annotation.GetMapping;

@Layout
@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String indexPage(Model model) {
        model.addAttribute("title", "Track.Record");
        return "index";
    }

    @GetMapping(path = "/about")
    public String aboutPage() {
        return "main/about";
    }

    @GetMapping(path = "/docs")
    public String docsPage() {
        return "main/docs";
    }

    @GetMapping(path = "/design")
    public String designPage() {
        return "main/design";
    }

}