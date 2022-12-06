package sooa.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sooa.domain.subjects_ms.*;

//hace los llamados rest al microservicio sooa_subjects_ms
@Service
public class SubjectBrowserService {

    @Autowired
    RestTemplate rest;

    public SubjectBrowserService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Subject getSubjectByName(String name) {
        return rest.getForObject("http://34.140.18.162:6666/subjects/name={name}",
        Subject.class, name);
    }

    public Subject getSubjectById(String id) {
        return rest.getForObject("http://34.140.18.162:6666/subjects/id={id}",
                Subject.class, id);
    }
    
    public Subject getSubjectByCode(String code) {
        return rest.getForObject("http://34.140.18.162:6666/subjects/code={code}",
                Subject.class, code);
    }

    public Course getCourseById(String id){
        Course curso_encontrado = rest.getForObject("http://34.140.18.162:6666/courses/id="+id,
        Course.class);
        System.out.println("we are trying to get "+id);
        return curso_encontrado;
    }

    public Course[] getCoursesBySubject(String subject){
        Course[] cursosen = rest.getForObject("http://34.140.18.162:6666/courses/sb="+subject,
        Course[].class);
        System.out.println("we are trying to get "+subject);
        return cursosen;
    }
    public Course[] getCoursesByStudent(String student){
        Course[] cursosen = rest.getForObject("http://34.140.18.162:6666/courses/st="+student,
        Course[].class);
        System.out.println("we are trying to get courses of "+student);
        return cursosen;
    }
    public Course[] getCoursesByStudentSem(String student, String semester){
        return rest.getForObject("http://34.140.18.162:6666/courses/st="+student+"/sm="+semester,
        Course[].class);
    }

    public Course[] getCoursesByProfe(String profe){
        return rest.getForObject("http://34.140.18.162:6666/courses/profe="+profe,
        Course[].class,profe);
    }

    public Subject createSubject(Subject sb) {
        return rest.postForObject("http://34.140.18.162:6666/new-subject",
        sb, Subject.class);
    }
    
    public Course createCourse(Course course) {
        return rest.postForObject("http://34.140.18.162:6666/new-course",
        course, Course.class);
    }

    public Course updateCourse(Course course) {
        rest.put("http://34.140.18.162:6666/update-course", course);
        return course;
    }

}
