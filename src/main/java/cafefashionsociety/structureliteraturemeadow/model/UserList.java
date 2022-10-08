package cafefashionsociety.structureliteraturemeadow.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class UserList implements Serializable {
    @Id
    String id;
    List<String> profileIds;
    List<String> noteIds;
    List<String> dossierIds;

    public UserList() {
    }

    public UserList(String id) {
        this.id = id;
        this.profileIds = new LinkedList<>();
        this.noteIds = new LinkedList<>();
        this.dossierIds = new LinkedList<>();
    }

    public UserList(String id, List<String> profileIds, List<String> noteIds, List<String> dossierIds) {
        this.id = id;
        this.profileIds = profileIds;
        this.noteIds = noteIds;
        this.dossierIds = dossierIds;
    }

    public UserList createUserList(String username) {
        return new UserList("l" + username);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getProfileIds() {
        return profileIds;
    }

    public void setProfileIds(List<String> profileIds) {
        this.profileIds = profileIds;
    }

    public List<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(List<String> noteIds) {
        this.noteIds = noteIds;
    }

    public List<String> getDossierIds() {
        return dossierIds;
    }

    public void setDossierIds(List<String> dossierIds) {
        this.dossierIds = dossierIds;
    }

}
