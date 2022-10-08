package cafefashionsociety.structureliteraturemeadow.model;

import java.io.Serializable;
import java.util.LinkedList;

import org.springframework.data.annotation.Id;

public class Dossier implements Serializable{
    @Id
    String id;
    String name;
    LinkedList<String> noteIds;

    public Dossier(String id, String name, LinkedList<String> noteIds) {
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

    public LinkedList<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(LinkedList<String> noteIds) {
        this.noteIds = noteIds;
    }

}
