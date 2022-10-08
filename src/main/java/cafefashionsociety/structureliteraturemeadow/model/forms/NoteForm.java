package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.time.LocalDate;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Note;

public class NoteForm {

    private String userAccId;
    private String profileId;
    private LocalDate incidentDate;
    private String title;
    private String what;
    private String soWhat;
    private String tags;

    public Note toNote() {
        UtilityBeans utilityBeans = new UtilityBeans();
        return new Note(utilityBeans.createUUIDString(), userAccId, profileId, incidentDate, title, what,
                soWhat, tags);
    }

}
