package cafefashionsociety.structureliteraturemeadow.apicontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/p", produces = "application/json")
public class profileController {

    @GetMapping(path = "{profileid}")
    public ResponseEntity<String> getProfile(@PathVariable String profileid, @RequestParam String apikey) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());

        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @PostMapping(value = "/addprofiles", consumes = "application/json")
    public ResponseEntity<String> postProfiles(@RequestBody String payload) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());

        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

}
