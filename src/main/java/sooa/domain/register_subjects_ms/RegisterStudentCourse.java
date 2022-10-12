package sooa.domain.register_subjects_ms;

import lombok.Data;

@Data
public class RegisterStudentCourse {
    private String student_id;
    private String course_id;
    
    public RegisterStudentCourse(String student_id, String course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }
}
