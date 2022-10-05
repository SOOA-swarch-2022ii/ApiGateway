package sooa.service;

import sooa.domain.academic_record_ms.AcademicRecordInfo;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicRecordService {
    @Autowired
    RestTemplate rest;

    public AcademicRecordService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public AcademicRecordInfo getAcademicRecord(String id){
        return rest.getForObject("http://localhost:4001/academic-record/{id}",
                AcademicRecordInfo.class, id);
    }

}
