package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sooa.domain.register_subjects_ms.*;
import sooa.service.RMQMessagingService;
import sooa.service.SubjectBrowserService;

import java.util.List;

@Component
public class SubjectBrowserProcess {
    @Autowired
    private SubjectBrowserService sbsrvice;
    
    @Autowired
    private RMQMessagingService rmqMessagingService;

    public Subject getSubjectById(String id) {
        return sbsrvice.getSubjectById(id);
    }
    public List<Subject> getSubjectByName(String name) {
        return sbsrvice.getSubjectByName(name);
    }
    
    public Subject getSubjectByCode(String code) {
        return sbsrvice.getSubjectByCode(code);
    }

    public Course getCourseById(String id){
        return sbsrvice.getCourseById(id);
    }

    public List<Course> getCoursesBySubject(String sb){
        return sbsrvice.getCoursesBySubject(sb);
    }
    public List<Course> getCoursesByStudent(String st){
        return sbsrvice.getCoursesByStudent(st);
    }
    public List<Course> getCoursesBySubjectSem(String sb, int semester){
        return sbsrvice.getCoursesBySubjectSem(sb,semester);
    }

    public List<Course> getCoursesByProfessor(String prof){
        return sbsrvice.getCoursesByProfessor(prof);
    }

}
