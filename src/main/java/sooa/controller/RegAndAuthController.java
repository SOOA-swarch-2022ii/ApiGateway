package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sooa.domain.academic_records_ms.AcademicInfo;
import sooa.domain.reg_and_auth_ms.User;
import sooa.process.AuthAndRegProcess;
import sooa.service.RegAndAuthService;

import java.text.ParseException;
import java.util.List;

@RestController
public class RegAndAuthController {

    @Autowired
    private AuthAndRegProcess authAndRegProcess;

    public RegAndAuthController(AuthAndRegProcess authAndRegProcess) {
        this.authAndRegProcess = authAndRegProcess;
    }

    @PostMapping(path = "/auth", consumes = "multipart/form-data", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String loginForm(@RequestPart String username, @RequestPart String password){
        return authAndRegProcess.auth(username, password);
    }

    @QueryMapping
    public List<User> findAll() {
        return authAndRegProcess.getAllUsers();
    }

    @QueryMapping
    public User findOne(@Argument Long id) {
        return authAndRegProcess.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument("userInput") User user,
                           @Argument("academicInfoInput") AcademicInfo academicInfo) throws ParseException {

        return authAndRegProcess.createUser(user, academicInfo);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument("input") User user) {
        return authAndRegProcess.updateUser(id, user);
    }

    @MutationMapping
    public void deleteUser(@Argument Long id) {
        authAndRegProcess.deleteUser(id);
    }

}
