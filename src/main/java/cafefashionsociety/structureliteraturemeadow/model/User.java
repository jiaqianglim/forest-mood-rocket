package cafefashionsociety.structureliteraturemeadow.model;

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

@RedisHash
public class User implements UserDetails {

    @Id
    private final String id;
    @Indexed
    private final String username;
    private final String password;
    private final String fullname;
    private final String userEmail;

    private List<String> profileIds;
    private List<String> reportIds;

    // Constructor for RegistrationForm
    public User(String username, String password, String fullname, String userEmail) {
        this.id = "u" + UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.profileIds = new LinkedList<String>();
        this.reportIds = new LinkedList<String>();
        reportIds.add("r00000000-00000000-00000000-00000000");
    }

    // Constructor for Repository Object
    public User(String id, String username, String password, String fullname, String userEmail,
            List<String> profileIds, List<String> reportIds) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.profileIds = profileIds;
        this.reportIds = reportIds;
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

    public List<String> getprofileIds() {
        return profileIds;
    }

    public void setprofileIds(List<String> profileIds) {
        this.profileIds = profileIds;
    }

    public List<String> getreportIds() {
        return reportIds;
    }

    public void setreportIds(List<String> reportIds) {
        this.reportIds = reportIds;
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
