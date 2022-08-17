package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping
public class IndexController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(path = "/about")
    public String aboutPage() {
        return "about";
    }

}
