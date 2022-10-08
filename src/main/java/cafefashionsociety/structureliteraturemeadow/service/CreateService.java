package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.User;

@Service
public class CreateService {

    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;
    @Autowired
    NoteService noteService;
    @Autowired
    DossierService dossierService;

    public Logger logger = LoggerFactory.getLogger(CreateService.class);

    public void addAndSave(Note note, Profile profile, User user) {
        noteService.save(note);
        Profile updatedProfile = addNoteToProfile(note, profile);
        User updatedUser = addNoteToUser(note, user);
        addAndSave(updatedProfile, updatedUser);
    }

    public void addAndSave(Profile profile, User user) {
        profileService.save(profile);
        User updatedUser = addProfileToUser(profile, user);
        userService.save(updatedUser);
    }

    public void addAndSave(Dossier dossier, User user){
        dossierService.save(dossier);
        User updatedUser = addDossierToUser(dossier, user);
        userService.save(updatedUser);
    }

    private User addProfileToUser(Profile profile, User user) {
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

    private Profile addNoteToProfile(Note note, Profile profile) {
        String noteId = note.getId();
        LinkedList<String> createdNotes = (LinkedList<String>) profile.getNoteIds();
        createdNotes.addFirst(noteId);
        profile.setNoteIds(createdNotes);
        return profile;
    }

    private User addDossierToUser(Dossier dossier, User user){
        String dossierId = dossier.getId();
        LinkedList<String> createdDossiers = user.getDossierIds();
        createdDossiers.addFirst(dossierId);
        user.setDossierIds(createdDossiers);
        return user;
    }
}
