package cafefashionsociety.structureliteraturemeadow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.repository.DossierRepository;

@Service
public class DossierService {
    @Autowired
    DossierRepository dossierRepository;

    public Dossier getDossierById(String id) {
        List<String> noteIds = dossierRepository.getNoteIdsByDossierId(id);
        return new Dossier(id, noteIds);
    }

    public void addNoteId(String dossierId, String noteId) {
        dossierRepository.addNoteId(dossierId, noteId);
    }

    public void save(Dossier dossier) {
        dossierRepository.save(dossier);

    }
}
