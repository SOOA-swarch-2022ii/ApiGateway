package sooa.domain.token_auth_ms;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private Date birthdate;
    private String names;
    private String last_names;
    private String role;
    private String email;
    private String phone;

    public User() {
        super();
    }

}

class Date{
    private String day;
    private String month;
    private String year;
}
