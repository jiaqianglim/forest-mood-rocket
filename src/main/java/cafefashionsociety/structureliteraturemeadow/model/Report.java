package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;

@Document
public class Report {
    // Incident, Task, Reflection, Workshop
    @Id
    @Indexed
    private String id;
    private String userId;
    private String profileId;
    private Date creationDate;
    private Date incidentnDate;
    private String title;
    private String what;
    private String soWhat;
    private String tags;
}
