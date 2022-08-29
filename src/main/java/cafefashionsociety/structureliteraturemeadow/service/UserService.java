package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public void save(User user) {
        iUserRepository.save(user);
    }

    public User findByUsername(String username){
        Optional<User> opt = iUserRepository.findByUsername(username);
        return opt.get();
    }
}
