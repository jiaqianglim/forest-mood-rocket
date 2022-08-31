package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RedisHash
public class User implements UserDetails {

    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    private String fullname;
    private String userEmail;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Map<String, String> profileIdsAndName;
    private Map<String, String> reportIdsAndTitle;

    public User() {
    }

    // Constructor for RegistrationForm
    public User(String username, String password, String fullname, String userEmail) {
        this.id = "u" + UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.profileIdsAndName = new HashMap<String, String>();
        this.reportIdsAndTitle = new HashMap<String, String>();
        reportIdsAndTitle.put("r00000000-00000000-00000000-00000000", "My first sample report");
    }

    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Map<String, String> getProfileIdsAndName() {
        return profileIdsAndName;
    }

    public void setProfileIdsAndName(Map<String, String> profileIdsAndName) {
        this.profileIdsAndName = profileIdsAndName;
    }

    public Map<String, String> getReportIdsAndTitle() {
        return reportIdsAndTitle;
    }

    public void setReportIdsAndTitle(Map<String, String> reportIdsAndTitle) {
        this.reportIdsAndTitle = reportIdsAndTitle;
    }

}
