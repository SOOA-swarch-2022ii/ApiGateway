package sooa.domain.academic_record_ms;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProfessoralRecordInfo {

    private String id;
    private String professor_id;
    private ArrayList<String> approved_subjects;
    private ArrayList<String> course_record;
    private String faculty;
    private String campus;

    public ProfessoralRecordInfo(String id, String professor_id, String faculty, String campus) {
        this.professor_id = professor_id;
        this.approved_subjects = new ArrayList<String>();
        this.course_record = new ArrayList<String>();
        this.faculty = faculty;
        this.campus = campus;
    }
}
