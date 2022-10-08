package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.repository.ProfileRepository;

@Service
public class ProfileService {

    public Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    ProfileRepository profileRepository;

    public Profile findById(String id) {
        Optional<Profile> opt = profileRepository.findById(id);
        return opt.get();
    }

    public List<Profile> findAllById(List<String> ids) {
        List<Profile> profiles = profileRepository.findAllById(ids);
        return profiles;
    }

    public void save(Profile profile) {
        profileRepository.save(profile);
        Profile savedProfile = (profileRepository.findById(profile.getId())).get();
        logger.info("Profile " + savedProfile.getDisplayName() + " saved");
    }

}
