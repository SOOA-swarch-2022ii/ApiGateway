package sooa.domain.academic_record_ms;
import lombok.Data;

@Data
public class ProfessoralRecordInfo {

    private String id;
    private String professor_id;
    private String approved_subjects;
    private String course_record;
    private String faculty;
    private String campus;

    public ProfessoralRecordInfo(String id, String professor_id, String approved_subjects, String course_record, String faculty, String campus) {
        this.id = id;
        this.professor_id = professor_id;
        this.approved_subjects = approved_subjects;
        this.course_record = course_record;
        this.faculty = faculty;
        this.campus = campus;
    }
}
