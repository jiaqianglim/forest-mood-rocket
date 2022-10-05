package cafefashionsociety.structureliteraturemeadow.apicontroller;

import org.springframework.web.bind.annotation.RestController;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.service.DossierService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class DossierRestController {
    @Autowired
    DossierService dossierService;
    @Autowired
    NoteService noteService;

    @GetMapping(path = "/{dossierid}")
    public ResponseEntity<String> getDossier(@PathVariable(name = "dossierId") String dossierId) {
        Dossier dossier = dossierService.getDossierById(dossierId);
        LinkedList<Note> notes = (LinkedList<Note>) noteService.findAllById(dossier.getNoteIds());
        JsonArrayBuilder response = Json.createArrayBuilder();
        for (Note note : notes) {
            JsonObjectBuilder noteJson = Json.createObjectBuilder()
                    .add("incidentDate", note.getincidentDate().toString())
                    .add("title", note.getTitle()).add("what", note.getWhat()).add("soWhat", note.getSoWhat());
            response.add(noteJson);

        }
        JsonArray resp = response.build();
        return ResponseEntity.ok(resp.toString());
    }
}
