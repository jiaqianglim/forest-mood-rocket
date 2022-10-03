package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.repository.INoteRepository;

@Service
public class NoteService {

    @Autowired
    INoteRepository noteRepository;

    public Note findById(String id) {
        Optional<Note> opt = noteRepository.findById(id);
        return opt.get();
    }

    public Iterable<Note> findAllById(List<String> ids) {
        Iterable<Note> notes = noteRepository.findAllById(ids);
        return notes;
    }

    public void save(Note note) {
        noteRepository.save(note);
    }

}
