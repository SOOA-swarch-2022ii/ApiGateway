package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sooa.domain.academic_records_ms.AcademicInfo;
import sooa.domain.reg_and_auth_ms.User;
import sooa.domain.subjects_ms.Course;
import sooa.domain.subjects_ms.Subject;
import sooa.process.SubjectBrowserProcess;
import sooa.service.SubjectBrowserService;

import java.text.ParseException;
import java.util.List;

@RestController
public class SubjectsBrowserController {

    @Autowired
    private SubjectBrowserProcess sbjProcess;

    public SubjectsBrowserController(SubjectBrowserProcess sbjProcess) {
        this.sbjProcess = sbjProcess;
    }
    
/*findSubjectsByName(name: String!): [Subject]
    findSubjectsByID(id: ID!): [Subject]
    findSubjectByCode(code: String!): Subject

    findCoursesBySubject(subject: String!): [Course]
    findCourseById(id: ID!): Course
    findCoursesByStudent(student: String!): [Course]
    findCoursesByProfessor(student: String!): [Course] */

    @QueryMapping
    public Subject getSubjectById(@Argument String id) {
        return sbjProcess.getSubjectById(id);
    }
    @QueryMapping
    public List<Subject> getSubjectByName(@Argument String name) {
        return sbjProcess.getSubjectByName(name);
    }
    @QueryMapping
    public Subject getSubjectByCode(@Argument String code) {
        return sbjProcess.getSubjectByCode(code);
    }
    @QueryMapping
    public Course getCourseById(@Argument String id){
        return sbjProcess.getCourseById(id);
    }
    @QueryMapping
    public List<Course> getCoursesBySubject(@Argument String sb){
        return sbjProcess.getCoursesBySubject(sb);
    }
    @QueryMapping
    public List<Course> getCoursesByStudent(@Argument String st){
        return sbjProcess.getCoursesByStudent(st);
    }
    @QueryMapping
    public List<Course> getCoursesBySubjectSem(@Argument String sb, @Argument int semester){
        return sbjProcess.getCoursesBySubjectSem(sb,semester);
    }
    @QueryMapping
    public List<Course> getCoursesByProfessor(@Argument String prof){
        return sbjProcess.getCoursesByProfessor(prof);
    }

}
