package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.util.List;

import org.springframework.stereotype.Component;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Component
public class DossierForm {
    String dossierName;
    List<String> noteIds;

    public Dossier toDossier() {
        UtilityBeans utilityBeans = new UtilityBeans();
        Dossier dossier = new Dossier(utilityBeans.createUUIDString(), dossierName, noteIds);
        return dossier;
    }

    public String getDossierName() {
        return dossierName;
    }

    public void setDossierName(String dossierName) {
        this.dossierName = dossierName;
    }

    public List<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(List<String> noteIds) {
        this.noteIds = noteIds;
    }

}