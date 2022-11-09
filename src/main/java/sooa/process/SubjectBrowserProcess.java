package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.subjects_ms.*;
import sooa.service.SubjectBrowserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectBrowserProcess {
    @Autowired
    private SubjectBrowserService sbsrvice;
    
    public Subject getSubjectById(String id) {
        return sbsrvice.getSubjectById(id);
    }
    public Subject getSubjectByName(String name) {
        return sbsrvice.getSubjectByName(name);
    }
    
    public Subject getSubjectByCode(String code) {
        return sbsrvice.getSubjectByCode(code);
    }

    public Course getCourseById(String id){
        return sbsrvice.getCourseById(id);
    }

    public Course[] getCoursesBySubject(String subject){
        return sbsrvice.getCoursesBySubject(subject);
    }
    public Course[] getCoursesByStudent(String student){
        return sbsrvice.getCoursesByStudent(student);
    }
    public Course[] getCoursesByStudentSem(String student, String semester){
        return sbsrvice.getCoursesByStudentSem(student,semester);
    }

    public Course[] getCoursesByProfe(String profe){
        return sbsrvice.getCoursesByProfe(profe);
    }

    public Course createCourse(Course course) {
        Course createdCourse = sbsrvice.createCourse(course);
        return createdCourse;
    }

    public Subject createSubject(Subject subject) {
        Subject createdSubject = sbsrvice.createSubject(subject);
        return createdSubject;
    }

    public Course updateCourse(Course course) {
        Course updatedCourse = sbsrvice.updateCourse(course);
        return updatedCourse;
    }

}
