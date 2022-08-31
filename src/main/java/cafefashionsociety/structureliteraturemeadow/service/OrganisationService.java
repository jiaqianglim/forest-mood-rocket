package cafefashionsociety.structureliteraturemeadow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Organisation;
import cafefashionsociety.structureliteraturemeadow.repository.IOrganisationRepository;

@Service
public class OrganisationService {
    @Autowired
    IOrganisationRepository iOrganisationRepository;

    public void save(Organisation organisation) {
        iOrganisationRepository.save(organisation);
    }
}
