package sooa.domain.academic_record_ms;
import lombok.Data;

import java.util.ArrayList;

@Data
public class AcademicRecordInfo {

    private String student_id;
    private String subjects_pending;
    private String subjects_record;
    private float papa;
    private float papi;
    private boolean status;
    private String faculty;
    private String campus;
    private String career;
    public AcademicRecordInfo(){super();};
    public AcademicRecordInfo( String student_id, String faculty, String campus, String career) {
        this.student_id = student_id;
        this.subjects_pending = "";
        this.subjects_record = "";
        this.papa = 0;
        this.papi = 0;
        this.status = true;
        this.faculty = faculty;
        this.campus = campus;
        this.career = career;

    }
}
