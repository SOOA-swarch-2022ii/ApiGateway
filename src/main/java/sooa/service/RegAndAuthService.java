package sooa.service;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sooa.domain.reg_and_auth_ms.User;

import java.util.List;

@Service
public class RegAndAuthService {

    @Autowired
    RestTemplate rest;

    public RegAndAuthService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public User getCurrentUser(){
        return rest.getForObject("http://localhost:8080/register/user",
                User.class);
    }

    public User getUser(Long id) {
        return rest.getForObject("http://localhost:8080/register/user/{id}",
                User.class, id);
    }

    public User getUserByUsername(String username) {
        return rest.getForObject("http://localhost:8080/register/user/username/{username}",
                User.class, username);
    }

    public List<User> getUsers() {
        System.out.println(getCurrentUser());
        return rest.getForObject("http://localhost:8080/register/users",
                List.class);
    }

    public User createUser(User user) {
        return rest.postForObject("http://localhost:8080/register/create",
                user, User.class);
    }

    public User updateUser(Long id, User user) {
        rest.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return rest.patchForObject("http://localhost:8080/register/update/{id}",
                user, User.class, id);
    }

    public void deleteUser(Long id) {
        rest.delete("http://localhost:8080/register/delete/{id}",
                id);
    }

    public String getRole(Long id) {
        return rest.getForObject("http://localhost:8080/register/role/{id}",
                String.class, id);
    }

    public String auth(String username, String password) {

        final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();

        factory.setHttpClient(httpClient);

        rest.setRequestFactory(factory);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = rest.postForEntity(
                "http://localhost:8080/auth", request , String.class);

        return response.getBody();
    }
}
