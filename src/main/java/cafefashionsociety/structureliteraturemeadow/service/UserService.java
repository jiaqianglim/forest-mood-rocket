package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Service
public class UserService {

    public Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    IUserRepository iUserRepository;

    public User findById(String id) {
        Optional<User> opt = iUserRepository.findById(id);
        return opt.get();
    }

    public User findByUsername(String username) {
        Optional<User> opt = iUserRepository.findByUsername(username);
        return opt.get();
    }

    public void save(User user) {
        iUserRepository.save(user);
        logger.info("User " + user.getUsername() + " saved");
    }


}
