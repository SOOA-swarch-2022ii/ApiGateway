package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import sooa.domain.academic_record_ms.AcademicRecordInfo;
import sooa.process.AcademicRecordProcess;

import java.util.List;

@RestController
public class AcademicRecordController {

    @Autowired
    private AcademicRecordProcess academicRecordProcess;

    public AcademicRecordController(AcademicRecordProcess academicRecordProcess) {
        this.academicRecordProcess = academicRecordProcess;
    }

    @QueryMapping
    public List<AcademicRecordInfo> findAllAcademicRecords() {
        return academicRecordProcess.getAllAcademicRecords();
    }

    @QueryMapping
    public AcademicRecordInfo findAcademicRecord(@Argument String student_id) {
        return academicRecordProcess.getAcademicRecord(student_id);
    }

    @MutationMapping
    public void updateAcademicRecord(@Argument String student_id) {
        academicRecordProcess.updateAcademicRecord(student_id);
    }

    @MutationMapping
    public void deleteAcademicRecord(@Argument String student_id) {
        academicRecordProcess.deleteAcademicRecord(student_id);
    }

}
