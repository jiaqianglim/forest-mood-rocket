package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Organisation {

    @Id
    private String id;
    private String displayName;
    private String orgEmail;
    private String orgName;
    private String pictureURL;
    private Map<String, String> userProfiles;
    private Map<String, String> adminProfiles;

    public Organisation() {
    }

    public Organisation(String id, String displayName, String orgEmail, String orgName,
            String pictureURL) {
        this.id = "o" + id;
        this.displayName = displayName;
        this.orgEmail = orgEmail;
        this.orgName = orgName;
        this.pictureURL = pictureURL;
        this.userProfiles = new LinkedHashMap<>();
        this.adminProfiles = new LinkedHashMap<>();
    }

    public Organisation(String id, String displayName, String orgEmail, String orgName,
            String pictureURL, Map<String, String> userProfiles, Map<String, String> adminProfiles) {
        this.id = id;
        this.displayName = displayName;
        this.orgEmail = orgEmail;
        this.orgName = orgName;
        this.pictureURL = pictureURL;
        this.userProfiles = userProfiles;
        this.adminProfiles = adminProfiles;
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

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Map<String, String> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Map<String, String> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public Map<String, String> getAdminProfiles() {
        return adminProfiles;
    }

    public void setAdminProfiles(Map<String, String> adminProfiles) {
        this.adminProfiles = adminProfiles;
    }

}
