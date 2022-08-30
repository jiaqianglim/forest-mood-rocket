package cafefashionsociety.structureliteraturemeadow.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/api/o", produces = "application/json")
public class OrganisationRestController {

    @GetMapping(path = "/{org}/getallprofiles")
    public ResponseEntity<String> getAllProfiles(@PathVariable(name = "org") String org, @RequestParam String apikey) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());

        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @GetMapping(path = "/{org}/getalladmins")
    public ResponseEntity<String> getAllAdmins(@PathVariable(name = "org") String org, @RequestParam String apikey) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());
        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @GetMapping(path = "/{org}/getallflaggedreports")
    public ResponseEntity<String> getAllFlaggedReports(@PathVariable(name = "org") String org,
            @RequestParam(name = "apikey", required = true) String apikey) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());
        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @GetMapping(path = "/{org}/getflaggedreport")
    public ResponseEntity<String> getFlaggedReports(@PathVariable(name = "org") String org,
            @RequestParam(name = "reportid", required = true) String reportid,
            @RequestParam(name = "apikey", required = true) String apikey) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());
        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @PostMapping(consumes = "application/json")
    @RequestMapping("/{org}/addprofiles")
    public ResponseEntity<String> addProfiles(@RequestBody String payload) {
        try {
            // TODO: process POST request
            String resp = "";
            return ResponseEntity.ok(resp.toString());
        } catch (Exception e) {
            JsonObject body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @PostMapping(consumes = "application/json")
    @RequestMapping("/{org}/disconnectprofiles")
    public ResponseEntity<String> disconnectProfiles(@RequestBody String payload) {
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
