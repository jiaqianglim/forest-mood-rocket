package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.model.forms.DossierForm;
import cafefashionsociety.structureliteraturemeadow.model.forms.NoteForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.UserListService;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/n")
public class NoteController {

    Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    UserListService userListService;

    @Autowired
    CreateService createService;

    @GetMapping("/all") // Done
    public String allNotesPage(Model model, Authentication authentication) {
        logger.info(authentication.getName());
        User user = userService.findByUsername(authentication.getName());
        logger.info(user.getUsername());
        UserList userList = userListService.findById("l" + user.getUsername());
        logger.info(userList.getId());
        List<Note> notes = noteService.findAllById(userList.getNoteIds());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "View all notes");
        return "client/notesall";
    }

    @GetMapping(path = "/f")
    public String noteByProfilePage(@RequestParam String p, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile profile = profileService.findById(p);
        logger.info(profile.getDisplayName());
        List<Note> notes = noteService.findAllById(profile.getNoteIds());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "View profile notes");
        return "client/notesall";
    }

    @GetMapping(path = "/{pathid}")
    public String noteInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        Note note = noteService.findById(pathid);
        if (note == null)
            return "error/resourceerror";
        model.addAttribute("user", user);
        model.addAttribute("note", note);
        model.addAttribute("title", note.getTitle());
        return "client/note";
    }

    @GetMapping("/new") // Done
    public String createNotePage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        List<Profile> profiles = profileService.findAllById(userList.getProfileIds());
        NoteForm noteForm = new NoteForm();
        model.addAttribute("user", user);
        model.addAttribute("profiles", profiles);
        model.addAttribute("noteForm", noteForm);
        model.addAttribute("title", "Create a new note");
        return "client/notecreate";
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
        return "client/notecreate";
    }

    // Done
    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewNote(@ModelAttribute NoteForm noteForm, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        Note newNote = noteForm.toNote();
        logger.info(newNote.getTitle());
        Profile profile = profileService.findById(newNote.getProfileId());
        logger.info(profile.getDisplayName());
        createService.addAndSave(newNote, profile, userList);
        List<Note> notes = (List<Note>) noteService.findAllById(userList.getNoteIds());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "All notes");
        return "client/notesall";
    }
}
