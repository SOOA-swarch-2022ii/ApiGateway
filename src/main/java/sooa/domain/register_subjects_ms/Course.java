package sooa.domain.register_subjects_ms;

import lombok.Data;

@Data
public class Course {
    private String id;
    private String subject;
    private String academic_semester;
    private Schedule[] schedule;
    private String start_date;
    private String end_date;
    private Number places;
    private Number group_number ;
    private String[] professors ;
    private StudentRecord[] students_record ;
    
    public Course(String id,
    String subject,
    String academic_semester,
    Schedule[] schedule,
    String start_date,
    String end_date,
    Number places,
    Number group_number,
    String[] professors,
    StudentRecord[] students_record) {
        this.id = id;
        this.subject = subject;
        this.academic_semester = academic_semester;
        this.schedule = schedule;
        this.start_date = start_date;
        this.end_date = end_date;
        this.places = places;
        this.group_number = group_number;
        this.professors = professors;
        this.students_record = students_record;
    }
}
