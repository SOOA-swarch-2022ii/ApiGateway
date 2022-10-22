package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.grades_ms.Grades;
import sooa.service.GradesService;

import java.util.List;

@Component
public class GradesProcess {
    @Autowired
    private GradesService gradesService;

    public GradesProcess(GradesService gradesService) {
        this.gradesService = gradesService;
    }

    public List<Grades> getGrades() {
        return gradesService.getGrades();
    }

    public Grades getGrade(String id) {
        return gradesService.getGrade(id);
    }

    public Grades getGradeCourse(String subject, float grade) {
        return gradesService.getGradeCourse(subject, grade);
    }

    public void updateGradeId(String id,String student, float grade) {
        gradesService.updateGradeId(id, student, grade);
    }

    public void updateGradeCourse(String subject, int group, String student, float grade) {
        gradesService.updateGradeCourse(subject, group, student, grade);
    }

    public void deleteGradeId(String id, String student, float grade) {
        gradesService.deleteGradeId(id, student, grade);
    }
    
    public void deleteGradeCourse(String subject, int group, String student, float grade) {
        gradesService.deleteGradeCourse(subject, group, student, grade);
    }
}
