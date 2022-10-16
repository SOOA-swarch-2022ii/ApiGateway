package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import sooa.process.RegisterSubjectsProcess;
import sooa.domain.register_subjects_ms.Course;
import sooa.domain.register_subjects_ms.SubjectCourse;
import sooa.domain.register_subjects_ms.RecordStudentCourse;

import java.text.ParseException;
import java.util.List;

@RestController
public class RegisterSubjectsController {

    @Autowired
    private RegisterSubjectsProcess registerSubjectsProcess;

    @MutationMapping
    public Course registerStudentCourse(@Argument("recordStudentCourse") RecordStudentCourse recordStudentCourse) throws ParseException {
        return registerSubjectsProcess.registerStudentCourse(recordStudentCourse);
    }

    @MutationMapping
    public Course unregisterStudentCourse(@Argument String student_id, @Argument String course_id) {
        return registerSubjectsProcess.unregisterStudentCourse(student_id, course_id);
    }

    @QueryMapping
    public Course findOneCourse(@Argument String course_id) {
        return registerSubjectsProcess.getCourseInfo(course_id);
    }

    @QueryMapping
    public List<SubjectCourse> findCoursesByStudent(@Argument String student_id) {
        return registerSubjectsProcess.getStudentCourses(student_id);
    }
    
}
