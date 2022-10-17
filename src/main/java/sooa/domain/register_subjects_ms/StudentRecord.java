package sooa.domain.register_subjects_ms;

import lombok.Data;

@Data
public class StudentRecord {
    private String student;
    private Number[] grades;
    
    public StudentRecord() {
        super();
    }
    
    public StudentRecord(String student, Number[] grades) {
        this.student = student;
        this.grades = grades;
    }
}
