package sooa.domain.register_subjects_ms;

import lombok.Data;

@Data
public class RecordStudentCourse {
    private String student_id;
    private String course_id;

    public RecordStudentCourse(){
        super();
    }
    
    public RecordStudentCourse(String student_id, String course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getStudent_id() {
        return student_id;
    }
}
