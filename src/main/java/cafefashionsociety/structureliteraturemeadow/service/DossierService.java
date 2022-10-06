package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.repository.DossierRepository;

@Service
public class DossierService {
    @Autowired
    DossierRepository dossierRepository;

    public Dossier getDossierById(String id) {
        Optional<Dossier> opt = dossierRepository.getDossierById(id);
        Dossier dossier = opt.isEmpty() ? new Dossier(id) : opt.get();
        return dossier;
    }

    public void addNoteId(String dossierId, String noteId) {
        dossierRepository.addNoteId(dossierId, noteId);
    }

    public void save(Dossier dossier) {
        dossierRepository.save(dossier);

    }
}
