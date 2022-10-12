package sooa.domain.subjects_ms;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Subject {

    private String Code;
    private String Name;
    private boolean Vigency;
    private String Level;
    private int Credits;
    private String Campus;
    private String Faculty;
    private String Department;
    private String BasicAcademicUnit;
    private String Academic_level;
    private ArrayList<String> Content;

}
