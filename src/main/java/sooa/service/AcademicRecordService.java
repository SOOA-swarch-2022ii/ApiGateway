package sooa.service;

import sooa.domain.academic_record_ms.AcademicRecordInfo;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicRecordService {
    @Autowired
    RestTemplate rest;

    public AcademicRecordService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public AcademicRecordInfo getAcademicRecord(String student_id){
        return rest.getForObject("http://35.233.7.100:4001/academic-record/{student_id}",
                AcademicRecordInfo.class, student_id);
    }

    public List<AcademicRecordInfo> getAllAcademicRecords() {
        return rest.getForObject("http://35.233.7.100:4001/academic-record/",
                List.class);
    }

    public AcademicRecordInfo createAcademicRecord(AcademicRecordInfo academicRecordInfo){
        return rest.postForObject("http://35.233.7.100:4001/academic-record/", academicRecordInfo,
                AcademicRecordInfo.class);
    }

    public void updateAcademicRecord(String student_id) {
        rest.put("http://35.233.7.100:4001/academic-record/{student_id}",
                student_id);
    }

    public void deleteAcademicRecord(String student_id) {
        rest.delete("http://35.233.7.100:4001/academic-record/{student_id}",
                student_id);
    }

}
