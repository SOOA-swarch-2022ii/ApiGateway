package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import sooa.domain.token_auth_ms.*;
import sooa.domain.academic_record_ms.*;
import sooa.process.TokenAuthProcess;
import sooa.process.AcademicRecordProcess;

import java.text.ParseException;

@RestController
public class TokenAuthController {

    @Autowired
    private TokenAuthProcess tokenAuthProcess;

    public TokenAuthController(TokenAuthProcess tokenAuthProcess) {
        this.tokenAuthProcess = tokenAuthProcess;
    }

    @QueryMapping
    public User getUser(@Argument String username) {
        return tokenAuthProcess.getUserProcess(username);
    }

    @MutationMapping
    public User registerUser(@Argument("userInput") User user, @Argument("academicRecordInfoInput") AcademicRecordInfo academicRecordInfo) throws ParseException {
        return tokenAuthProcess.registerUserProcess(user, academicRecordInfo);
    }

    @MutationMapping
    public TokenLogin login(@Argument("loginForm") LoginForm login) {
        return tokenAuthProcess.loginProcess(login);
    }
}
