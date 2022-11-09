package sooa.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.academic_record_ms.AcademicRecordInfo;
import sooa.service.AcademicRecordService;

import java.util.List;

@Component
public class AcademicRecordProcess {

    @Autowired
    private AcademicRecordService academicRecordService;

    public AcademicRecordInfo createAcademicRecord(AcademicRecordInfo academicRecordInfo) {

        return academicRecordService.createAcademicRecord(academicRecordInfo);
    }

    public List<AcademicRecordInfo> getAllAcademicRecords() {
        return academicRecordService.getAllAcademicRecords();
    }

    public AcademicRecordInfo getAcademicRecord(String student_id) {
        return academicRecordService.getAcademicRecord(student_id);
    }

    public void updateAcademicRecord(String student_id) {
        academicRecordService.updateAcademicRecord(student_id);
    }

    public void deleteAcademicRecord(String student_id) {
        academicRecordService.deleteAcademicRecord(student_id);
    }

}
