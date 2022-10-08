package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.UserRepository;

@Service
public class UserService {

    public Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username) {
        Optional<User> opt = userRepository.findByUsername(username);
        return opt.get();
    }

    public void save(User user) {
        userRepository.save(user);
        User savedUser = userRepository.findByUsername(user.getUsername()).get();
        logger.info("User " + savedUser.getUsername() + " saved");
    }

}
