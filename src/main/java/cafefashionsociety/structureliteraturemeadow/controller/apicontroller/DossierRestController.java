package cafefashionsociety.structureliteraturemeadow.controller.apicontroller;

import org.springframework.web.bind.annotation.RestController;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.service.DossierService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api/d")
public class DossierRestController {
    @Autowired
    DossierService dossierService;
    @Autowired
    NoteService noteService;

    @GetMapping(path = "/{dossierId}", produces = "application/json")
    public ResponseEntity<String> getDossier(@PathVariable(name = "dossierId") String dossierId) {
        Dossier dossier = dossierService.findById(dossierId);
        List<Note> notes = (List<Note>) noteService.findAllById(dossier.getNoteIds());
        JsonObjectBuilder response = Json.createObjectBuilder().add("dossierName", dossier.getName());
        JsonArrayBuilder notesArray = Json.createArrayBuilder();
        for (Note note : notes) {
            JsonObjectBuilder noteJson = Json.createObjectBuilder()
                    .add("incidentDate", note.getIncidentDate())
                    .add("title", note.getTitle()).add("what", note.getWhat()).add("soWhat", note.getSoWhat())
                    .add("tags", note.getTags());
            notesArray.add(noteJson);
        }
        response.add("notes", notesArray);
        JsonObject resp = response.build();
        return ResponseEntity.ok(resp.toString());
    }
}
