package cafefashionsociety.structureliteraturemeadow.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/api/o", produces = "application/json")
public class organisationController {

    @GetMapping(path = "/{org}/getallprofiles")
    public ResponseEntity<String> getAllProfiles(@PathVariable(name="org") String org, @RequestParam String apikey) {
        try{
            //TODO: process POST request
        String resp = "";
        return ResponseEntity.ok(resp.toString());
        
    }catch(Exception e){
        JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build(); 
        return ResponseEntity.internalServerError().body(body.toString());
    }
    }

    @GetMapping(path = "/{org}/getalladmins")
    public ResponseEntity<String> getAllAdmins(@PathVariable(name="org") String org, @RequestParam String apikey) {
        try{
            //TODO: process POST request
        String resp = "";
        return ResponseEntity.ok(resp.toString());
        
    }catch(Exception e){
        JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build(); 
        return ResponseEntity.internalServerError().body(body.toString());
    }
    }

}
