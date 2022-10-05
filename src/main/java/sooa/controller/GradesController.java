package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sooa.domain.grades_ms.Grades;
import sooa.process.GradesProcess;

import java.text.ParseException;
import java.util.List;

@Controller
public class GradesController {
    @Autowired
    private GradesProcess GradesProcess;

    public GradesController(GradesProcess GradesProcess) {
        this.GradesProcess = GradesProcess;
    }

    @QueryMapping
    public List<Grades> getGrades() {
        return GradesProcess.getGrades();
    }

    @QueryMapping
    public Grades getGrade(@Argument String id) {
        return GradesProcess.getGrade(id);
    }

    @QueryMapping
    public Grades getGradeCourse(@Argument ("subject") String subject,@Argument ("group") int group) {
        return GradesProcess.getGradeCourse(subject,group);
    }

    @MutationMapping
    public void updateGradeId(@Argument String id, @Argument("student") String student, @Argument("grade") float grade) {
        GradesProcess.updateGradeId(id, student, grade);
    }

    @MutationMapping
    public void updateGradeCourse(@Argument ("subject") String subject,@Argument ("group") int group, @Argument("student") String student, @Argument("grade") float grade) {
        GradesProcess.updateGradeCourse(subject,group,student,grade);
    }

    @MutationMapping
    public void deleteGradeId(@Argument String id, @Argument("student") String student, @Argument("grade") float grade) {
        GradesProcess.deleteGradeId(id, student, grade);
    }

    @MutationMapping
    public void deleteGradeCourse(@Argument("subject") String subject,@Argument("group") int group, 
				  @Argument("student") String student, @Argument("grade") float grade) {
        GradesProcess.deleteGradeCourse(subject, group, student, grade);
    }
}
