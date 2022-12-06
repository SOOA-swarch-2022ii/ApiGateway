package sooa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sooa.domain.grades_ms.Grades;

import java.util.List;

@Service
public class GradesService {
    @Autowired
    RestTemplate rest;

    //crear lista

    public GradesService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Grades getGrade(String id) {
        return rest.getForObject("http://35.241.129.8:4545/grade/{id}",
                Grades.class, id);
    }

    public Grades getGradeCourse(String subject, float grade) {
        return rest.getForObject("http://35.241.129.8:4545/grade/{id}/{grade}",
                Grades.class, subject, grade);
    }

    public List<Grades> getGrades() {
        return rest.getForObject("http://35.241.129.8:4545/grades",
                List.class);
    }

    //preguntar
    public void updateGradeId(String id, String student, float grade) {
        System.out.println(id+ student + grade);
        rest.put("http://35.241.129.8:4545/grade/"+id+"/"+student+"/"+grade,null);
    }

    public void updateGradeCourse(String subject, int group, String student, float grade) {
        rest.put("http://35.241.129.8:4545/grade/"+subject+"/"+group+"/"+student+"/"+grade,null);
    }

    public void deleteGradeId(String id, String student, float grade) {
        rest.delete("http://35.241.129.8:4545/grade/{id}/{student}/{grade}",
                id,student, grade);
    }


    public void deleteGradeCourse(String subject, int group, String student, float grade) {
        rest.delete("http://35.241.129.8:4545/grade/{subject}/{group}/{student}/{grade}",
                subject, group, student, grade);
    }
}

