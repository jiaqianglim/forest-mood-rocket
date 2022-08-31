package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public void save(User user) {
        iUserRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User> opt = iUserRepository.findByUsername(username);
        return opt.get();
    }

    public User addNewUserPersonalProfileToUser(String profileId, User user) {
        Map<String, String> profileIdsAndName = user.getProfileIdsAndName();
        profileIdsAndName.put(profileId, "Your personal account");
        user.setProfileIdsAndName(profileIdsAndName);
        return user;
    }
}
