package sooa.domain.academic_record_ms;
import lombok.Data;

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

    public AcademicRecordInfo( String student_id, String subjects_pending, String subjects_record, float papa, float papi, boolean status, String faculty, String campus, String career) {
        this.student_id = student_id;
        this.subjects_pending = subjects_pending;
        this.subjects_record = subjects_record;
        this.papa = papa;
        this.papi = papi;
        this.status = status;
        this.faculty = faculty;
        this.campus = campus;
        this.career = career;
    }
}
