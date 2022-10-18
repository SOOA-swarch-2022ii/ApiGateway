package sooa.service;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import sooa.domain.register_subjects_ms.*;

//hace los llamados rest al microservicio sooa_subjects_ms
@Service
public class SubjectBrowserService {

    @Autowired
    RestTemplate rest;

    public SubjectBrowserService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public List<Subject> getSubjectByName(String name) {
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/subjects/name={name}",
        List.class, name);
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
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/id={id}",
        Course.class, id);
    }

    public List<Course> getCoursesBySubject(String sb){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/sb={subject_code}",
        List.class, sb);
    }
    public List<Course> getCoursesByStudent(String st){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/st={student}",
        List.class, st);
    }
    public List<Course> getCoursesBySubjectSem(String sb, int semester){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/sb={student}/sm={semester}",
        List.class, sb,semester);
    }

    public List<Course> getCoursesByProfessor(String prof){
        return rest.getForObject("http://localhost:6666/sooa-sb-ms/courses/profe={professor}",
        List.class, prof);
    }


}
