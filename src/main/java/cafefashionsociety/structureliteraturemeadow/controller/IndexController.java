package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;

import org.springframework.web.bind.annotation.GetMapping;

@Layout
@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String indexPage() {
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