package sooa.domain.grades_ms;
import lombok.Data;

@Data
public class Grades {
    private String  _id;
    private students_record[] students_record;

    public Grades(){
        super();
    }
}
