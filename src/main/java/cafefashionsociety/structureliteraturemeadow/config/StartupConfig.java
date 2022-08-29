package cafefashionsociety.structureliteraturemeadow.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.repository.IReportRepository;

@Configuration
public class StartupConfig implements CommandLineRunner {

    @Autowired
    IReportRepository iReportRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Report> opt = iReportRepository.findById("r00000000-00000000-00000000-00000000");
        if (opt.isEmpty()) {
            Report newSampleReport = new Report("My first sample report", "I created a new sample report!",
                    "I made my first step in learning!", "Excited");
            iReportRepository.save(newSampleReport);
        }

    }

}
