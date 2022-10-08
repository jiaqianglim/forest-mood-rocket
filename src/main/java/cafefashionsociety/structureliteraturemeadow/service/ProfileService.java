package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.repository.IProfileRepository;

@Service
public class ProfileService {

    public Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    IProfileRepository iProfileRepository;

    public Profile findById(String id) {
        Optional<Profile> opt = iProfileRepository.findById(id);
        return opt.get();
    }

    public Iterable<Profile> findAllById(LinkedList<String> ids) {
        Iterable<Profile> profiles = iProfileRepository.findAllById(ids);
        return profiles;
    }

    public void save(Profile profile) {
        iProfileRepository.save(profile);
        Profile savedProfile = (iProfileRepository.findById(profile.getId())).get();
        logger.info("Profile " + savedProfile.getDisplayName() + " saved");
    }

}
