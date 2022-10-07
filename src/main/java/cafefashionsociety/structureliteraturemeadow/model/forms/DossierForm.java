package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DossierForm {
    String name;
    List<String> noteIds;

    public DossierForm() {
    }

    public DossierForm(String name, List<String> noteIds) {
        this.name = name;
        this.noteIds = noteIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(List<String> noteIds) {
        this.noteIds = noteIds;
    }

}
