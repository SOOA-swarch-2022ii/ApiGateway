package sooa.controller;

import graphql.GraphQLContext;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sooa.domain.reg_and_auth_ms.User;
import sooa.service.RegAndAuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Controller
public class RegAndAuthController {

    @Autowired
    private RegAndAuthService regAndAuthService;

    @Autowired
    private HttpServletResponse response;



    public RegAndAuthController(RegAndAuthService regAndAuthService) {
        this.regAndAuthService = regAndAuthService;
    }


    @QueryMapping
    public String login(@Argument String username, @Argument  String password) {

        Cookie cookie = new Cookie("JSESSIONID", "Jovan");
        
        //add a cookie to response
        response.addCookie(cookie);
        return regAndAuthService.auth(username, password);
    }

    @QueryMapping
    public List<User> findAll() {
        return regAndAuthService.getUsers();
    }

    @QueryMapping
    public User findOne(@Argument Long id) {
        return regAndAuthService.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument("input") User user) throws ParseException {

        System.out.println(user);

        return regAndAuthService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument("input") User user) {

        return regAndAuthService.updateUser(id, user);
    }

    @MutationMapping
    public void deleteUser(@Argument Long id) {
        regAndAuthService.deleteUser(id);
    }

}
