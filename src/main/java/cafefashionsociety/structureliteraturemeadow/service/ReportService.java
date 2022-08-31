package cafefashionsociety.structureliteraturemeadow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.repository.IReportRepository;

@Service
public class ReportService {

    @Autowired
    IReportRepository reportRepository;

    public void save(Report report) {
        reportRepository.save(report);
    }

}
