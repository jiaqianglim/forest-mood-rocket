package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.UserList;

@Service
public class CreateService {

    @Autowired
    UserListService userListService;
    @Autowired
    ProfileService profileService;
    @Autowired
    NoteService noteService;
    @Autowired
    DossierService dossierService;

    public Logger logger = LoggerFactory.getLogger(CreateService.class);

    public void addAndSave(Note note, Profile profile, UserList userList) {
        noteService.save(note);
        Profile updatedProfile = addNoteToProfile(note, profile);
        UserList updatedUserList = addNoteToUserList(note, userList);
        addAndSave(updatedProfile, updatedUserList);
    }

    public void addAndSave(Profile profile, UserList userList) {
        profileService.save(profile);
        UserList updatedUserList = addProfileToUserList(profile, userList);
        userListService.save(updatedUserList);
    }

    public void addAndSave(Dossier dossier, UserList userList) {
        dossierService.save(dossier);
        UserList updatedUserList = addDossierToUserList(dossier, userList);
        userListService.save(updatedUserList);
    }

    private UserList addProfileToUserList(Profile profile, UserList userList) {
        List<String> profileIds = userList.getProfileIds();
        String newProfileId = profile.getId();
        if (!profileIds.contains(newProfileId))
            profileIds.add(0, newProfileId);
        userList.setProfileIds(profileIds);
        return userList;
    }

    private UserList addNoteToUserList(Note note, UserList userList) {
        List<String> noteIds = userList.getNoteIds();
        String newNoteId = note.getId();
        if (!noteIds.contains(newNoteId))
            noteIds.add(0, newNoteId);
        userList.setNoteIds(noteIds);
        return userList;
    }

    private Profile addNoteToProfile(Note note, Profile profile) {
        List<String> createdNotes = (List<String>) profile.getNoteIds();
        String noteId = note.getId();
        if (!createdNotes.contains(note.getId()))
            createdNotes.add(0, noteId);
        profile.setNoteIds(createdNotes);
        return profile;
    }

    private UserList addDossierToUserList(Dossier dossier, UserList userList) {
        List<String> createdDossiers = userList.getDossierIds();
        String dossierId = dossier.getId();
        if (!createdDossiers.contains(dossier.getId()))
            createdDossiers.add(0, dossierId);
        userList.setDossierIds(createdDossiers);
        return userList;
    }
}
