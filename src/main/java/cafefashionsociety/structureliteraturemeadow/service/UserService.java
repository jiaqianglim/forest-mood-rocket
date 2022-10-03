package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Service
public class UserService {

    public Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    IUserRepository iUserRepository;

    public User addNewUserPersonalProfileToUser(String profileId, User user) {
        LinkedList<String> profileIds = user.getProfileIds();
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

    public User addNoteToProfileToUser(Note note, Profile profile, User user) {
        user = addProfileToUser(profile, user);
        user = addNoteToUser(note, user);
        return user;
    }

    public User addProfileToUser(Profile profile, User user) {
        LinkedList<String> profileIds = user.getProfileIds();
        String newProfileId = profile.getId();
        profileIds.addFirst(newProfileId);
        user.setProfileIds(profileIds);
        return user;
    }

    private User addNoteToUser(Note note, User user) {
        LinkedList<String> noteIds = user.getNoteIds();
        String newNoteId = note.getId();
        noteIds.addFirst(newNoteId);
        user.setNoteIds(noteIds);
        return user;
    }
}
