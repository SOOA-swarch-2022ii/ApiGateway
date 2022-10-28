package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import sooa.domain.subjects_ms.*;
import sooa.process.SubjectBrowserProcess;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectsBrowserController {

    @Autowired
    private SubjectBrowserProcess sbjProcess;

    public SubjectsBrowserController(SubjectBrowserProcess sbjProcess) {
        this.sbjProcess = sbjProcess;
    }
    @QueryMapping
    public Subject getSubjectById(@Argument String id) {
        return sbjProcess.getSubjectById(id);
    }
    @QueryMapping
    public Subject getSubjectByName(@Argument String name) {
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
    public Course[] getCoursesBySubject(@Argument String subject){
        return sbjProcess.getCoursesBySubject(subject);
    }
    @QueryMapping
    public Course[] getCoursesByStudent(@Argument String student){
        return sbjProcess.getCoursesByStudent(student);
    }
    @QueryMapping
    public Course[] getCoursesByStudentSem(@Argument String student, @Argument String semester){
        return sbjProcess.getCoursesByStudentSem(student,semester);
    }
    @QueryMapping
    public Course[] getCoursesByProfe(@Argument String profe){
        return sbjProcess.getCoursesByProfe(profe);
    }

}
