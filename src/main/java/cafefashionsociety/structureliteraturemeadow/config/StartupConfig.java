package cafefashionsociety.structureliteraturemeadow.config;

import java.time.LocalDate;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;

@Configuration
public class StartupConfig implements CommandLineRunner {

        public Logger logger = LoggerFactory.getLogger(StartupConfig.class);

        @Autowired
        IUserRepository iUserRepository;

        @Autowired
        CreateService createService;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {
                UtilityBeans utilityBeans = new UtilityBeans();
                User testUser = new User(utilityBeans.createUUIDString(), "jeff",
                                passwordEncoder.encode("pass1"),
                                "user1FirstName", "user1LastName", "testuser1@email.com");

                utilityBeans = new UtilityBeans();
                Profile testProfile = new Profile(utilityBeans.createUUIDString(),
                                "My Personal Profile", "MyTestOrg", "MyTestRole", "MyTestProfileDescription");
                utilityBeans = new UtilityBeans();
                Profile testWorkProfile = new Profile(utilityBeans.createUUIDString(),
                                "Bill Bezos", "Gimble Inc", "General Manager", "2017-2020 job");

                utilityBeans = new UtilityBeans();
                Note testNote = new Note(utilityBeans.createUUIDString(),
                                testUser.getId(), testProfile.getId(),
                                LocalDate.now(), "My first sample note",
                                "I created a new sample note!", "I made my first step in learning!",
                                "Excited");

                utilityBeans = new UtilityBeans();
                Note testNote1 = new Note(utilityBeans.createUUIDString(),
                                testUser.getId(), testProfile.getId(),
                                LocalDate.now(), "Late for work",
                                "Jenny was late for work today!",
                                "When Jenny is late, everything is delayed because the team has to wait for her. So annoying",
                                "Jenny late");

                utilityBeans = new UtilityBeans();
                Note testNote2 = new Note(utilityBeans.createUUIDString(),
                                testUser.getId(), testProfile.getId(),
                                LocalDate.now(), "Late Again",
                                "Jenny is late again, after I told her repeatedly to arrive on time",
                                "Does she think she is special? We expect more from her. Why cant she just listen to us?",
                                "Jenny late");

                utilityBeans = new UtilityBeans();
                Note testNote3 = new Note(utilityBeans.createUUIDString(),
                                testUser.getId(), testProfile.getId(),
                                LocalDate.now(), "Late",
                                "Jenny late again, nothing new", "I am no longer mad, just disappointed",
                                "Jenny late");
                LinkedList<String> noteIds = new LinkedList<>();
                noteIds.add(testNote1.getId());
                noteIds.add(testNote2.getId());
                noteIds.add(testNote3.getId());
                
                utilityBeans = new UtilityBeans();
                Dossier testdossier = new Dossier(utilityBeans.createUUIDString(), "Jenny is late",
                                noteIds);
                
                createService.addAndSave(testProfile, testUser);
                createService.addAndSave(testWorkProfile, testUser);
                createService.addAndSave(testNote, testProfile, testUser);
                createService.addAndSave(testNote1, testWorkProfile, testUser);
                createService.addAndSave(testNote2, testWorkProfile, testUser);
                createService.addAndSave(testNote3, testWorkProfile, testUser);
                createService.addAndSave(testdossier, testUser);

                logger.info("Test cases inserted into DB");

        }

}
