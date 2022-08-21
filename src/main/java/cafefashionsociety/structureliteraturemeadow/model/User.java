package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.redis.om.spring.annotations.Indexed;

public class User implements UserDetails {

    @Id
    @Indexed
    private final String id;
    private final String username;
    private final String password;
    private final String fullname;
    private final String userEmail;

    List<Profile> profiles = new LinkedList<>();
    List<Report> reports = new LinkedList<>();

    public User(String username, String password, String fullname, String userEmail) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
    }

    public User(String id, String username, String password, String fullname, String userEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
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

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
