package sooa.domain.register_subjects_ms;

import lombok.Data;

@Data
public class SubjectCourse {
    private Course course;
    private Subject subject;

    public SubjectCourse(){
        super();
    }
    
    public SubjectCourse(Course course, Subject subject) {
        this.course = course;
        this.subject = subject;
    }
}
