package cafefashionsociety.structureliteraturemeadow.config;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.Organisation;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;
import cafefashionsociety.structureliteraturemeadow.service.OrganisationService;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Configuration
public class StartupConfig implements CommandLineRunner {

        @Autowired
        IUserRepository iUserRepository;

        @Autowired
        OrganisationService organisationService;

        @Autowired
        ProfileService profileService;

        @Autowired
        NoteService noteService;

        @Autowired
        UserService userService;

        @Autowired
        UtilityBeans projectConfig;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {

                // Create Test User
                Optional<User> optuser1 = iUserRepository.findById("u00000000-00000000-00000000-00000000");
                if (optuser1.isEmpty()) {
                        //
                        String idkey = "00000000-00000000-00000000-00000000";
                        User testUser = new User(idkey, "user1",
                                        passwordEncoder.encode("pass1"),
                                        "user1FirstName", "user1LastName", "testuser1@email.com");
                        Profile testProfile = new Profile(idkey,
                                        "My Personal Profile",
                                        "testProfile@email.com", "Personal",
                                        "",
                                        "", true, "",
                                        testUser.getId(),
                                        true);
                        Note testNote = new Note(idkey,
                                        testUser.getId(), testProfile.getId(),
                                        LocalDate.now(), "My first sample note",
                                        "I created a new sample note!", "I made my first step in learning!",
                                        "Excited");
                        Organisation testOrg = new Organisation(idkey, "OrgTEST",
                                        "testOrg@Email.com", "OrgTESTName", "");

                        testProfile = profileService.addNoteToProfile(testNote, testProfile);
                        testUser = userService.addNoteToProfileToUser(testNote, testProfile, testUser);
                        organisationService.save(testOrg);
                        noteService.save(testNote);
                        profileService.save(testProfile);
                        userService.save(testUser);
                }

        }

}
