package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.repository.IProfileRepository;

@Service
public class ProfileService {

    @Autowired
    IProfileRepository iProfileRepository;

    public void save(Profile profile) {
        iProfileRepository.save(profile);
    }

    public Profile addReportToProfile(Report report, Profile profile) {
        Map<String, String> profileCreatedReports = profile.getCreatedReports();
        profileCreatedReports.put(report.getId(), report.getTitle());
        profile.setCreatedReports(profileCreatedReports);
        return profile;
    }

}
