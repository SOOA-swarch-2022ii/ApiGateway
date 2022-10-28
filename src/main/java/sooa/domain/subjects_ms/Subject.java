package sooa.domain.subjects_ms;

import lombok.Data;

@Data
public class Subject {
    private String _id;
    private String academic_level;
    private String basic_academic_unit;
    private String faculty;
    private String level;
    private Boolean vigency;
    private String campus;
    private String name;
    private String code;
    private String[] content;
    private Number credits;
    private String department;

    public Subject(){
        super();
    }
    
    public Subject(String _id, String academic_level, String basic_academic_unit, 
    String faculty, String level, Boolean vigency, String campus,
    String name, String code, String[] content, Number credits, String department) {
        this._id = _id;
        this.academic_level = academic_level;
        this.basic_academic_unit = basic_academic_unit;
        this.faculty = faculty;
        this.level = level;
        this.vigency = vigency;
        this.campus = campus;
        this.name = name;
        this.code = code;
        this.content = content;
        this.credits = credits;
        this.department = department;

    }
}
