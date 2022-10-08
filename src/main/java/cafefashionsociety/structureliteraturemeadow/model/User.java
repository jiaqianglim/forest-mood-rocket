package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

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
    private String firstName;
    private String lastName;
    private String userEmail;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private LinkedList<String> profileIds;
    private LinkedList<String> noteIds;
    private LinkedList<String> dossierIds;

    public User() {
    }

    // New User
    public User(String id, String username, String password, String firstName, String lastName, String userEmail) {
        this.id = "u" + id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.profileIds = new LinkedList<String>();
        this.noteIds = new LinkedList<String>();
        this.dossierIds = new LinkedList<>();
    }

    public User(String id, String username, String password, String firstName, String lastName, String userEmail,
            Collection<? extends GrantedAuthority> authorities, boolean isAccountNonExpired,
            boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled,
            LinkedList<String> profileIds, LinkedList<String> noteIds, LinkedList<String> dossierIds) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.profileIds = profileIds;
        this.noteIds = noteIds;
        this.dossierIds = dossierIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public LinkedList<String> getProfileIds() {
        return profileIds;
    }

    public void setProfileIds(LinkedList<String> profileIds) {
        this.profileIds = profileIds;
    }

    public LinkedList<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(LinkedList<String> noteIds) {
        this.noteIds = noteIds;
    }

    public LinkedList<String> getDossierIds() {
        return dossierIds;
    }

    public void setDossierIds(LinkedList<String> dossierIds) {
        this.dossierIds = dossierIds;
    }

    

}
