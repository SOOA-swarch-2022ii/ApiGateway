package sooa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sooa.domain.register_subjects_ms.RegisterStudentCourse;
import sooa.domain.register_subjects_ms.Course;

import java.util.List;

@Service
public class RegisterSubjectsService {
    @Autowired
    RestTemplate rest;

    public RegisterSubjectsService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Course registerStudentCourse(RegisterStudentCourse registerStudentCourse){
        return rest.postForObject("http://localhost:3000//register-subject/", registerStudentCourse,
                Course.class);
    }


    public Course getCourseInfo(String course_id){
        return rest.getForObject("http://localhost:3000/register-subject/course/{course_id} ",
                Course.class, course_id);
    }

    public List<Course> getStudentCourses(String student_id){
        return rest.getForObject("http://localhost:3000//register-subject/student/" + student_id ,
        List.class);
    }

    public Course unregisterStudentCourse(String student_id, String course_id){
        return rest.getForObject("http://localhost:3000//register-subject/delete/{student_id}/{student_id} ", 
        Course.class, student_id, course_id);
    }

}
