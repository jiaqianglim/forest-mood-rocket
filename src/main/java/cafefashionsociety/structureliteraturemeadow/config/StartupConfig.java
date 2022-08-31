package cafefashionsociety.structureliteraturemeadow.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IReportRepository;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Configuration
public class StartupConfig implements CommandLineRunner {

    @Autowired
    IReportRepository iReportRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<Report> optreport = iReportRepository.findById("r00000000-00000000-00000000-00000000");
        if (optreport.isEmpty()) {
            Report newSampleReport = new Report("My first sample report", "I created a new sample report!",
                    "I made my first step in learning!", "Excited");
            iReportRepository.save(newSampleReport);
        }

        Optional<User> optuser1 = iUserRepository.findById("u00000000-00000000-00000000-00000000");
        if (optuser1.isEmpty()) {
            User newUser1 = new User("user1", passwordEncoder.encode("pass1"), "testuser1", "testuser1@email.com");
            newUser1.setId("u00000000-00000000-00000000-00000000");
            iUserRepository.save(newUser1);
        }

    }

}
