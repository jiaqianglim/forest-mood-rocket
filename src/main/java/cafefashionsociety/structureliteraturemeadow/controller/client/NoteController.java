package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.NoteForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/n")
public class NoteController {

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    CreateService createService;

    @GetMapping("/all")
    public String allNotesPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        LinkedList<Note> allNotes = (LinkedList<Note>) noteService.findAllById(user.getNoteIds());
        model.addAttribute("allNotes", allNotes);
        model.addAttribute("user", user);
        model.addAttribute("title", "View all notes");
        return "client/allnotes";
    }

    @GetMapping(path = "/f")
    public String noteByProfilePage(@RequestParam String p, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile profileRequested = profileService.findById(p);
        LinkedList<Note> allNotes = (LinkedList<Note>) noteService.findAllById(profileRequested.getNoteIds());
        model.addAttribute("allNotes", allNotes);
        model.addAttribute("user", user);
        model.addAttribute("title", "View profile notes");
        return "client/allnotes";
    }

    @GetMapping(path = "/{pathid}")
    public String noteInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Note note = noteService.findById(pathid);
        if (note == null)
            return "error/resourceerror";
        if (!user.getProfileIds().contains(note.getId())) {
            return "error/permissionerror";
        }
        model.addAttribute("user", user);
        model.addAttribute("note", note);
        model.addAttribute("title", note.getTitle());
        return "client/note";
    }

    @GetMapping("/new")
    public String createNotePage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        NoteForm noteForm = new NoteForm();
        model.addAttribute("user", user);
        model.addAttribute("noteForm", noteForm);
        model.addAttribute("title", "Create a new note");
        return "client/createnote";
    }

    @GetMapping("/clean")
    public String createCleanNotePage(Model model, Authentication authentication, @RequestParam String pathid) {
        User user = userService.findByUsername(authentication.getName());
        NoteForm noteForm = new NoteForm();
        Note note = noteService.findById(pathid);
        model.addAttribute("oldNote", note);
        model.addAttribute("user", user);
        model.addAttribute("noteForm", noteForm);
        model.addAttribute("title", "Create a new note");
        return "client/createnote";
    }

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewNote(@ModelAttribute NoteForm noteForm, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Note newNote = noteForm.toNote();
        Profile profile = profileService.findById(newNote.getProfileId());
        createService.addAndSave(newNote, profile, user);
        model.addAttribute("user", user);
        model.addAttribute("title", "All notes");
        return "client/allnotes";
    }
}
