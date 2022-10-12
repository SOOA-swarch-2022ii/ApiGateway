package sooa.domain.subjects_ms;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Course {
    private String id;
    private String subject;
    private Schedule schedule;
    private String academic_semester;
    private String start_date;
    private String end_date;
    private int group_number;
    private int places;
    private ArrayList<String> Professors;
    private ArrayList<StudentRecord> studentsRecord;
}
