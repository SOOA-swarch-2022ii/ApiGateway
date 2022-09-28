package sooa.domain.reg_and_auth_ms;

import lombok.Data;
import java.util.Date;

@Data
public class User
{

    private Role role;
    private String name;
    private String phone;
    private String address;
    private String nationality;
    private Sex    sex;
    private Date   dateOfBirth;
    private int    identificationNumber;

    private String email;
    private String password;

    public User() {

    }
    public User(Role role, String name, String phone, String address, String nationality,
                Sex sex, Date dateOfBirth, int identificationNumber, String email, String password) {

        this.role                 = role;
        this.name                 = name;
        this.phone                = phone;
        this.address              = address;
        this.nationality          = nationality;
        this.sex                  = sex;
        this.dateOfBirth          = dateOfBirth;
        this.identificationNumber = identificationNumber;
        this.email                = email;
        this.password             = password;
    }

    public enum Role {
        ESTUDIANTE,
        PROFESOR,
    }


    public enum Sex {
        HOMBRE,
        MUJER,
    }

}