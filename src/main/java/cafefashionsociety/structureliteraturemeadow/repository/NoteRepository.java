package cafefashionsociety.structureliteraturemeadow.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cafefashionsociety.structureliteraturemeadow.model.Note;

@Repository
public class NoteRepository {

    public Logger logger = LoggerFactory.getLogger(NoteRepository.class);

    @Autowired
    RedisTemplate redisTemplate;

    public void save(Note note) {
        redisTemplate.opsForValue().set(note.getId(), note);
    }

    public Optional<Note> findById(String id) {
        return Optional.ofNullable((Note) redisTemplate.opsForValue().get(id));
    }

    public List<Note> findAllById(List<String> ids) {
        List<Note> notes = redisTemplate.opsForValue().multiGet(ids);
        return notes;
    }

}
