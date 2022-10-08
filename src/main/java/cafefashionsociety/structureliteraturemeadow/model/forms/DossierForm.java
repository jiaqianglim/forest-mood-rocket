package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.util.List;

import org.springframework.stereotype.Component;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Component
public class DossierForm {
    String dossierName;
    List<DossierFormNoteDTO> dossierFormNoteDTOs;

    public Dossier toDossier() {
        UtilityBeans utilityBeans = new UtilityBeans();
        Dossier dossier = new Dossier(utilityBeans.createUUIDString(), dossierName);
        List<String> noteIds = dossier.getNoteIds();
        for (DossierFormNoteDTO dto : dossierFormNoteDTOs) {
            if (dto.getNoteInputChoice().equals("yes")) {
                noteIds.add(dto.getNoteId());
            }
        }
        dossier.setNoteIds(noteIds);
        return dossier;
    }

    public DossierForm() {
    }

    public DossierForm(String dossierName, List<DossierFormNoteDTO> dossierFormNoteDTOs) {
        this.dossierName = dossierName;
        this.dossierFormNoteDTOs = dossierFormNoteDTOs;
    }

    public String getDossierName() {
        return dossierName;
    }

    public void setDossierName(String dossierName) {
        this.dossierName = dossierName;
    }
}
