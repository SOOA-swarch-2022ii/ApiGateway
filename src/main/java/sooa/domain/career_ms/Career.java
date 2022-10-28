package sooa.domain.career_ms;

import lombok.Data;

@Data
public class Career {
    private int     _id;
    private String  academic_level;
    private String  name;
    private int     SNIES_code;
    private int     credits;
    private String  departament;
    private String  faculty;
    private String  campus;
    private String[] pensum;

    public Career() {

    }
    public Career(int _id, String academic_level, String name, int SNIES_code, int credits, String departament, String faculty, String campus, String[] pensum) {

        this._id            = _id;
        this.academic_level = academic_level;
        this.name           = name;
        this.SNIES_code     = SNIES_code;
        this.credits        = credits;
        this.departament    = departament;
        this.faculty        = faculty;
        this.campus         = campus;
        this.pensum         = pensum;
    }

    public Career(int _id, String academic_level, String name, int SNIES_code, int credits, String departament, String faculty, String campus) {

        this._id            = _id;
        this.academic_level = academic_level;
        this.name           = name;
        this.SNIES_code     = SNIES_code;
        this.credits        = credits;
        this.departament    = departament;
        this.faculty        = faculty;
        this.campus         = campus;
    }
}
