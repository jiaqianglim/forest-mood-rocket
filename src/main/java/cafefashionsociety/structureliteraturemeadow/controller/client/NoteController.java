package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.NoteForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/r")
public class NoteController {

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String allNotesPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", "View all notes");
        return "allnotes";
    }

    @GetMapping(path = "/{pathid}")
    public String noteInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Note note = noteService.findById(pathid);
        if(note==null)
                return "error/resourceerror";
        model.addAttribute("user", user);
        model.addAttribute("note", note);
        model.addAttribute("title", note.getTitle());
        return "note";
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

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewNote(@ModelAttribute NoteForm noteForm, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Note newNote = noteForm.toNote();
        Profile profile = profileService.findById(newNote.getProfileId());
        user = userService.addNoteToProfileToUser(newNote, profile, user);
        noteService.save(newNote);
        profileService.save(profile);
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("title", "All notes");
        return "allnotes";
    }
}
