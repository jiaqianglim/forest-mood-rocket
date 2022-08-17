package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;
import java.util.List;

import cafefashionsociety.structureliteraturemeadow.model.EventType.Incident;
import cafefashionsociety.structureliteraturemeadow.model.EventType.Task;

public class Profile {
    List<Task> tasks = new LinkedList<>();
    List<Incident> incidents = new LinkedList<>();
}
