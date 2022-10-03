package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.repository.IProfileRepository;

@Service
public class ProfileService {

    @Autowired
    IProfileRepository iProfileRepository;

    public Profile findById(String id) {
        Optional<Profile> opt = iProfileRepository.findById(id);
        return opt.get();
    }

    public void save(Profile profile) {
        iProfileRepository.save(profile);
    }

    public Profile addNoteToProfile(Note note, Profile profile) {
        String noteId = note.getId();
        LinkedList<String> createdNotes = profile.getCreatedNotes();
        createdNotes.addFirst(noteId);
        profile.setCreatedNotes(createdNotes);
        return profile;
    }

}
