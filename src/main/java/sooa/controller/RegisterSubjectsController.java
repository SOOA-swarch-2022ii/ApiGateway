package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sooa.domain.reg_and_auth_ms.User;
import sooa.process.RegisterSubjectsProcess;
import sooa.domain.register_subjects_ms.Course;
import sooa.domain.register_subjects_ms.RegisterStudentCourse;

import java.text.ParseException;
import java.util.List;

@RestController
public class RegisterSubjectsController {

    @Autowired
    private RegisterSubjectsProcess registerSubjectsProcess;

    @MutationMapping
    public Course registerStudentCourse(@Argument("input") RegisterStudentCourse registerStudentCourse) throws ParseException {
        return registerSubjectsProcess.registerStudentCourse(registerStudentCourse);
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
    public List<Course> findCoursesByStudent(@Argument String student_id) {
        return registerSubjectsProcess.getStudentCourses(student_id);
    }
    
}
