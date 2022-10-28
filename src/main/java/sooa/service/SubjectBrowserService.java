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
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/subjects/name={name}",
        Subject.class, name);
    }

    public Subject getSubjectById(String id) {
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/subjects/id={id}",
                Subject.class, id);
    }
    
    public Subject getSubjectByCode(String code) {
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/subjects/code={code}",
                Subject.class, code);
    }

    public Course getCourseById(String id){
        Course curso_encontrado = rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/id="+id,
        Course.class);
        System.out.println("we are trying to get "+id);
        return curso_encontrado;
    }

    public Course[] getCoursesBySubject(String subject){
        Course[] cursosen = rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/sb="+subject,
        Course[].class);
        System.out.println("we are trying to get "+subject);
        return cursosen;
    }
    public Course[] getCoursesByStudent(String student){
        Course[] cursosen = rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/st="+student,
        Course[].class);
        System.out.println("we are trying to get courses of "+student);
        return cursosen;
    }
    public Course[] getCoursesByStudentSem(String student, String semester){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/st="+student+"/sm="+semester,
        Course[].class);
    }

    public Course[] getCoursesByProfe(String profe){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/profe="+profe,
        Course[].class,profe);
    }
}
