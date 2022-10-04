package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;
import java.util.List;

public class Dossier {
    String id;
    List<String> noteIds;

    public Dossier(String id) {
        id = "d" + id;
        noteIds = new LinkedList<>();
    }

    public Dossier(String id, List<String> noteIds) {
        this.id = id;
        this.noteIds = noteIds;
    }

    public String getId() {
        return id;
    }

    public List<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(List<String> noteIds) {
        this.noteIds = noteIds;
    }

}
