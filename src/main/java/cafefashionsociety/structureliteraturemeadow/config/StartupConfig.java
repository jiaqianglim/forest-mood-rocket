package cafefashionsociety.structureliteraturemeadow.config;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.Organisation;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;
import cafefashionsociety.structureliteraturemeadow.service.OrganisationService;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
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
        ReportService reportService;

        @Autowired
        UserService userService;

        @Autowired
        ProjectConfig projectConfig;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {

                // Create Test User
                Optional<User> optuser1 = iUserRepository.findById("u00000000-00000000-00000000-00000000");
                if (optuser1.isEmpty()) {
                        //
                        String idkey = "00000000-00000000-00000000-00000000";
                        User newTestUser = new User(idkey, "user1",
                                        passwordEncoder.encode("pass1"),
                                        "user1FirstName", "user1LastName", "testuser1@email.com");
                        Profile newTestProfile = new Profile(idkey,
                                        "My Personal Profile",
                                        "testProfile@email.com", "Personal",
                                        "",
                                        "", true, "",
                                        newTestUser.getId(),
                                        true);
                        Report newTestReport = new Report(idkey,
                                        newTestUser.getId(), newTestProfile.getId(),
                                        LocalDate.now(), "My first sample report",
                                        "I created a new sample report!", "I made my first step in learning!",
                                        "Excited");
                        Organisation newTestOrg = new Organisation(idkey, "OrgTEST",
                                        "testOrg@Email.com", "OrgTESTName", "");

                        newTestProfile = profileService.addReportToProfile(newTestProfile, newTestReport);
                        newTestUser = userService.addProfileToUser(newTestUser, newTestProfile);
                        newTestUser = userService.addReportToUser(newTestUser, newTestReport);
                        organisationService.save(newTestOrg);
                        reportService.save(newTestReport);
                        profileService.save(newTestProfile);
                        userService.save(newTestUser);
                }

        }

}
