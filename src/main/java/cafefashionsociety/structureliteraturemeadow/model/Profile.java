package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Profile {

    @Id
    private String id;
    private String displayName;
    private String organisationName;
    private String organisationRole;
    private String profileDescription;
    private LinkedList<String> noteIds;

    public Profile() {
    }

    // Add Profile
    public Profile(String id, String displayName, String organisationName,
            String organisationRole, String profileDescription) {
        this.id = "p" + id;
        this.displayName = displayName;
        this.organisationName = organisationName;
        this.organisationRole = organisationRole;
        this.profileDescription = profileDescription;
        this.noteIds = new LinkedList<>();
    }

    // Full
    public Profile(String id, String displayName, String organisationName,
            String organisationRole, String profileDescription, LinkedList<String> noteIds) {
        this.id = id;
        this.displayName = displayName;
        this.organisationName = organisationName;
        this.organisationRole = organisationRole;
        this.profileDescription = profileDescription;
        this.noteIds = noteIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationRole() {
        return organisationRole;
    }

    public void setOrganisationRole(String organisationRole) {
        this.organisationRole = organisationRole;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public LinkedList<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(LinkedList<String> noteIds) {
        this.noteIds = noteIds;
    }


}
