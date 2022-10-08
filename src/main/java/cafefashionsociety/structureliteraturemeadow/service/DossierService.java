package cafefashionsociety.structureliteraturemeadow.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.repository.DossierRepository;

@Service
public class DossierService {

    public Logger logger = LoggerFactory.getLogger(DossierService.class);
    @Autowired
    DossierRepository dossierRepository;

    public Dossier findById(String id) {
        Optional<Dossier> opt = dossierRepository.findById(id);
        Dossier dossier = opt.isEmpty() ? new Dossier(id, "Empty Dossier") : opt.get();
        return dossier;
    }

    public List<Dossier> findAllById(List<String> ids) {
        List<Dossier> dossiers = dossierRepository.findAllByIds(ids);
        return dossiers;
    }

    public void save(Dossier dossier) {
        dossierRepository.save(dossier);
        Dossier savedDossier = findById(dossier.getId());
        logger.info("Dossier " + savedDossier.getName() + " saved");
    }
}
