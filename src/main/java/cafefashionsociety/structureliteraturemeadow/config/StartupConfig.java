package cafefashionsociety.structureliteraturemeadow.config;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.controller.apicontroller.QuoteRestRequest;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.repository.UserRepository;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.UserListService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Configuration
public class StartupConfig implements CommandLineRunner {

        public Logger logger = LoggerFactory.getLogger(StartupConfig.class);

        @Autowired
        UserRepository iUserRepository;

        @Autowired
        CreateService createService;

        @Autowired
        UserService userService;

        @Autowired
        UserListService userListService;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        RedisTemplate redisTemplate;

        @Autowired
        QuoteRestRequest quoteRestRequest;

        @Override
        public void run(String... args) throws Exception {

                redisTemplate.delete("*");

                UtilityBeans utilityBeans = new UtilityBeans();
                User testUser = new User("jeff",
                                passwordEncoder.encode("pass1"),
                                "user1FirstName", "user1LastName", "testuser1@email.com");

                UserList testUserLists = new UserList().createUserList(testUser.getUsername());

                userService.save(testUser);
                userListService.save(testUserLists);

                utilityBeans = new UtilityBeans();
                Profile testProfile = new Profile(utilityBeans.createUUIDString(),
                                "My Personal Profile", "MyTestOrg", "MyTestRole", "MyTestProfileDescription");
                createService.addAndSave(testProfile, testUserLists);

                utilityBeans = new UtilityBeans();
                Profile testWorkProfile = new Profile(utilityBeans.createUUIDString(),
                                "Bill Bezos, Gimble", "Gimble Inc", "General Manager", "2017-2020 job");
                createService.addAndSave(testWorkProfile, testUserLists);

                utilityBeans = new UtilityBeans();
                Note testNote = new Note(utilityBeans.createUUIDString(),
                                testUser.getUsername(), testProfile.getId(),
                                LocalDate.of(2022, 04, 01).toString(), "My first sample note",
                                "I created a new sample note!", "I made my first step in learning!",
                                "Excited");
                createService.addAndSave(testNote, testProfile, testUserLists);

                utilityBeans = new UtilityBeans();
                Note testNote1 = new Note(utilityBeans.createUUIDString(),
                                testUser.getUsername(), testProfile.getId(),
                                LocalDate.of(2022, 04, 01).toString(), "Late for work",
                                "Jenny was late for work today!",
                                "When Jenny is late, everything is delayed because the team has to wait for her. So annoying",
                                "Jenny late");

                createService.addAndSave(testNote1, testWorkProfile, testUserLists);

                utilityBeans = new UtilityBeans();
                Note testNote2 = new Note(utilityBeans.createUUIDString(),
                                testUser.getUsername(), testProfile.getId(),
                                LocalDate.of(2022, 04, 04).toString(), "Late Again",
                                "Jenny is late again, after I told her repeatedly to arrive on time",
                                "Does she think she is special? We expect more from her. Why cant she just listen to us?",
                                "Jenny late, Angry");

                createService.addAndSave(testNote2, testWorkProfile, testUserLists);

                utilityBeans = new UtilityBeans();
                Note testNote3 = new Note(utilityBeans.createUUIDString(),
                                testUser.getUsername(), testProfile.getId(),
                                LocalDate.of(2022, 04, 5).toString(), "Late",
                                "Jenny late again, nothing new", "I am no longer mad, just disappointed",
                                "Great Disappointment");

                createService.addAndSave(testNote3, testWorkProfile, testUserLists);

                List<String> noteIds = new LinkedList<>();
                noteIds.add(0, testNote1.getId());
                noteIds.add(0, testNote2.getId());
                noteIds.add(0, testNote3.getId());

                utilityBeans = new UtilityBeans();
                Dossier testdossier = new Dossier("d" + utilityBeans.createUUIDString(), "Jenny is late",
                                noteIds);

                createService.addAndSave(testdossier, testUserLists);

                logger.info(testdossier.getId());

                logger.info("Test cases inserted into DB");

                // quoteRestRequest.NewQuoteRequest();
                quoteRestRequest.LocalNewRequest();

        }

}
