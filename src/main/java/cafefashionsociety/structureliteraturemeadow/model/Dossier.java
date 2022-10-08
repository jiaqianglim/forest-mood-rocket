package cafefashionsociety.structureliteraturemeadow.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Dossier implements Serializable {
    @Id
    String id;
    String name;
    List<String> noteIds;

    public Dossier(String id, String name) {
        this.id = id;
        this.name = name;
        this.noteIds = new LinkedList<>();
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
