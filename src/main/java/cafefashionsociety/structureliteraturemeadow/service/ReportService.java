package cafefashionsociety.structureliteraturemeadow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.repository.IReportRepository;

@Service
public class ReportService {

    @Autowired
    IReportRepository reportRepository;

    public Report findById(String id){
        Optional<Report> opt = reportRepository.findById(id);
        return opt.get();
    }

    public void save(Report report) {
        reportRepository.save(report);
    }

}
