package cafefashionsociety.structureliteraturemeadow.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@RedisHash
public class User implements UserDetails {

    IUserRepository iUserRepository;

    @Id
    private final String id;
    @Indexed
    private final String username;
    private final String password;
    private final String fullname;
    private final String userEmail;

    private List<Profile> profiles;
    private List<String> profileNames;
    private List<Report> reports;
    private List<String> reportsNames;

    // Constructor for registration
    public User(String username, String password, String fullname, String userEmail) {
        this.id = "u" + UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.profiles = new LinkedList<Profile>();
        this.reports = new LinkedList<Report>();

        Profile newProfile = new Profile(this.username, this.id);
        profiles.add(newProfile);
        reports.add(new Report(this.id, newProfile.getId(), LocalDate.now(), "My first sample report",
                "I created a new sample report!", "I made my first step in learning!", "Excited"));
    }

    public User(String id, String username, String password, String fullname, String userEmail,
            List<Profile> profiles, List<Report> reports) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.profiles = profiles;
        this.reports = reports;
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

    public List<String> getProfileNames() {
        return profileNames;
    }

    public void setProfileNames(List<String> profileNames) {
        this.profileNames = profileNames;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<String> getReportsNames() {
        return reportsNames;
    }

    public void setReportsNames(List<String> reportsNames) {
        this.reportsNames = reportsNames;
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
