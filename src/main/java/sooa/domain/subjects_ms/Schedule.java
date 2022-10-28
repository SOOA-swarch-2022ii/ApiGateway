package sooa.domain.subjects_ms;

import lombok.Data;

@Data
public class Schedule {
    private String day;
    private String start_h;
    private String end_h;
    private String location;

    public Schedule(){
        super();
    }

    public Schedule(String day, String start_h, String end_h, String location) {
        this.day = day;
        this.start_h = start_h;
        this.end_h = end_h;
        this.location = location;
    }
}
