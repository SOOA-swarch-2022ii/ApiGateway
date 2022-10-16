package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.register_subjects_ms.RegisterStudentCourse;
import sooa.domain.register_subjects_ms.Course;
import sooa.domain.register_subjects_ms.SubjectCourse;
import sooa.service.RegisterSubjectsService;

import java.util.List;

@Component
public class RegisterSubjectsProcess {
    @Autowired
    private RegisterSubjectsService registerSubjectsService;

    public RegisterSubjectsProcess(RegisterSubjectsService registerSubjectsService) {
        this.registerSubjectsService = registerSubjectsService;
    }

    public Course registerStudentCourse(RegisterStudentCourse registerStudentCourse) {
        return registerSubjectsService.registerStudentCourse(registerStudentCourse);
    }

    public Course unregisterStudentCourse(String student_id, String course_id) {
        return registerSubjectsService.unregisterStudentCourse(student_id, course_id);
    }

    public Course getCourseInfo(String course_id) {
        return registerSubjectsService.getCourseInfo(course_id);
    }

    public List<SubjectCourse> getStudentCourses(String student_id) {
        return registerSubjectsService.getStudentCourses(student_id);
    }
    
}
