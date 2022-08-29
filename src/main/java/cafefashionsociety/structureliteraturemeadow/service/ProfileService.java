package cafefashionsociety.structureliteraturemeadow.service;

import org.springframework.beans.factory.annotation.Autowired;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.repository.IProfileRepository;

public class ProfileService {

    @Autowired
    IProfileRepository iProfileRepository;

    public void save(Profile profile){
        iProfileRepository.save(profile);
    }
}
