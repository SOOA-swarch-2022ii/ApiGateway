package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sooa.domain.academic_record_ms.AcademicRecordInfo;
import sooa.domain.subjects_ms.*;
import sooa.domain.token_auth_ms.LoginForm;
import sooa.domain.token_auth_ms.TokenLogin;
import sooa.domain.token_auth_ms.User;
import sooa.service.AcademicRecordService;
import sooa.service.TokenAuthService;


@Component
public class TokenAuthProcess {
    @Autowired
    private TokenAuthService tokenAuthService;
    @Autowired
    private AcademicRecordService academicRecordService;

    public User registerUserProcess(User user , AcademicRecordInfo academicRecordInfo) {
        //create user, check the role, if student, create academic record
        User userCreated = tokenAuthService.registerUserService(user);
        if(userCreated.getRole().equals("student")){
            academicRecordService.createAcademicRecord(academicRecordInfo);
        }

        return userCreated;
    }

    public User getUserProcess(String id) {
        return tokenAuthService.getUserService(id);
    }

    public TokenLogin loginProcess(LoginForm loginForm) {
        return tokenAuthService.loginUserService(loginForm);
    }


}
