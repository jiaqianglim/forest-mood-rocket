package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;

@Component
public class DossierForm {
    String dossierName;
    LinkedList<String> noteIds;

    public Dossier toDossier(){
        UtilityBeans utilityBeans = new UtilityBeans();
        return new Dossier(utilityBeans.createUUIDString(), dossierName, noteIds);
    }

    public DossierForm() {
    }

    public DossierForm(String dossierName, LinkedList<String> noteIds) {
        this.dossierName = dossierName;
        this.noteIds = noteIds;
    }

    public String getDossierName() {
        return dossierName;
    }

    public void setDossierName(String dossierName) {
        this.dossierName = dossierName;
    }

    public LinkedList<String> getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(LinkedList<String> noteIds) {
        this.noteIds = noteIds;
    }

    
}
