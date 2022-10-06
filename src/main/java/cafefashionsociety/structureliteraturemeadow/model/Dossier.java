package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;
import java.util.List;

public class Dossier {
    String id;
    String name;
    List<String> noteIds;

    public Dossier(String id) {
        id = "d" + id;
        noteIds = new LinkedList<>();
    }

    public Dossier(String id, String name, List<String> noteIds) {
        this.id = id;
        this.name = name;
        this.noteIds = noteIds;
    }

    public String getId() {
        return id;
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
