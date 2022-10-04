package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    UtilityBeans projectConfig;

    public Note toNote() {
        return new Note(projectConfig.createUUIDString(), userAccId, profileId, incidentDate, title, what,
                soWhat, tags);
    }

}
