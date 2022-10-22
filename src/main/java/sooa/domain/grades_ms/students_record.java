package sooa.domain.grades_ms;
import lombok.Data;

@Data
public class students_record {
    private String  _id;
    private String  student;
    private float[] grades;

    public students_record(){
        super();
    }
}
