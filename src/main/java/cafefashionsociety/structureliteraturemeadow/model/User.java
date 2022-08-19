package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String username;
    private String displayname;
    private String id;

    List<Profile> profiles = new LinkedList<>();
    List<Report> reports = new LinkedList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    
}
