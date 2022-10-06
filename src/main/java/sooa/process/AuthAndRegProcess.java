package sooa.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.academic_records_ms.AcademicInfo;
import sooa.domain.reg_and_auth_ms.User;
import sooa.service.AcademicRecordService;
import sooa.service.RMQMessagingService;
import sooa.service.RegAndAuthService;

import java.util.List;

@Component
public class AuthAndRegProcess {

    @Autowired
    private RegAndAuthService regAndAuthService;

    @Autowired
    private AcademicRecordService academicRecordService;

    @Autowired
    private RMQMessagingService rmqMessagingService;

    public AuthAndRegProcess(RegAndAuthService regAndAuthService) {
        this.regAndAuthService = regAndAuthService;
    }

    public String auth(String userName, String password) {
        return regAndAuthService.auth(userName, password);
    }

    // USA DOS MS
    public User createUser(User user, AcademicInfo academicInfo) {

        User createdUser = regAndAuthService.createUser(user);

        // Aqui va el codigo que agrega la información propia del rol
        if (createdUser.getRole() == User.Role.ESTUDIANTE){
          //
        }

        return createdUser;
    }

    public List<User> getAllUsers() {
        rmqMessagingService.sendSimpleMessage("La cola funciona");
        return regAndAuthService.getUsers();
    }

    public User getUser(Long id) {
        System.out.println(rmqMessagingService.receiveMessage());
        return regAndAuthService.getUser(id);
    }

    public User getUserByUsername(String username) {
        return regAndAuthService.getUserByUsername(username);
    }


    public User updateUser(Long id, User user) {
        return regAndAuthService.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        regAndAuthService.deleteUser(id);
    }

}
