package sooa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sooa.domain.token_auth_ms.*;

//hace los llamados rest al microservicio sooa_user_token_ms
@Service
public class TokenAuthService {

    @Autowired
    RestTemplate rest;

    public TokenAuthService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public User registerUserService(User usuario) {
        return rest.postForObject("http://34.132.175.84:6665/register-user",
                usuario, User.class);
    }

    public User getUserService(String username) {
        return rest.getForObject("http://34.132.175.84:6665/user/un={username}",
                User.class, username);
    }


    public TokenLogin loginUserService ( LoginForm loginForm) {
        return rest.postForObject("http://34.132.175.84:6665/login",
        loginForm, TokenLogin.class);
    }


}