package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.repository.NoteRepository;

@Service
public class NoteService {

    public Logger logger = LoggerFactory.getLogger(NoteService.class);

    @Autowired
    NoteRepository noteRepository;

    public Note findById(String id) {
        Optional<Note> opt = noteRepository.findById(id);
        return opt.get();
    }

    public List<Note> findAllById(List<String> ids) {
        List<Note> notes = noteRepository.findAllById(ids);
        return notes;
    }

    public void save(Note note) {
        noteRepository.save(note);
        Note savedNote = noteRepository.findById(note.getId()).get();
        logger.info("Note "+savedNote.getTitle() +" saved");
    }

}
