package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.util.List;

import org.springframework.stereotype.Component;

import cafefashionsociety.structureliteraturemeadow.model.Note;

@Component
public class DossierCreationDTO {
    String name;
    List<Note> dossier;

    public DossierCreationDTO() {
    }

    public DossierCreationDTO(String Name, List<Note> dossier) {
        this.name = name;
        this.dossier = dossier;
    }

    public void addNote(Note note) {
        this.dossier.add(note);
    }
    
    public List<Note> getDossier() {
        return dossier;
    }

    public void setDossier(List<Note> dossier) {
        this.dossier = dossier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
