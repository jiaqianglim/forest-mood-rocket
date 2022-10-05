package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Note;

@Repository
public class NoteRepository {

    @Autowired
    RedisTemplate redisTemplate;

    public void save(Note note) {
        redisTemplate.opsForValue().set(note.getId(), note);
    }

    public Optional<Note> findById(String id) {
        return Optional.ofNullable((Note) redisTemplate.opsForValue().get(id));
    }

    public LinkedList<Note> findAllById(List<String> ids) {
        LinkedList<Note> notes = (LinkedList<Note>) redisTemplate.opsForValue().multiGet(ids);
        return notes;
    }

}
