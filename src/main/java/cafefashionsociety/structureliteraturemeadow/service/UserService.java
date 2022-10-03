package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Deque;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Service
public class UserService {

    public Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    IUserRepository iUserRepository;

    public User addNewUserPersonalProfileToUser(String profileId, User user) {
        Deque<String> profileIds = user.getProfileIds();
        profileIds.addFirst(profileId);
        user.setProfileIds(profileIds);
        return user;
    }

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

    public User addReportToProfileToUser(Report report, Profile profile, User user) {
        user = addProfileToUser(profile, user);
        user = addReportToUser(report, user);
        return user;
    }

    public User addProfileToUser(Profile profile, User user) {
        Deque<String> profileIds = user.getProfileIds();
        String newProfileId = profile.getId();
        profileIds.addFirst(newProfileId);
        user.setProfileIds(profileIds);
        return user;
    }

    private User addReportToUser(Report report, User user) {
        Deque<String> reportIds = user.getReportIds();
        String newReportId = report.getId();
        reportIds.addFirst(newReportId);
        user.setReportIds(reportIds);
        return user;
    }
}
