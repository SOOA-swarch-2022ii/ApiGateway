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

import sooa.domain.subjects_ms.Subject;
@Service
public class SubjectBrowserService {

    @Autowired
    RestTemplate rest;

    public SubjectBrowserService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Subject getSubjectByName(String name) {
        return rest.getForObject("http://sooa-sb-container:6666/sooa-sb-ms/subjects/name={name}",
                Subject.class, name);
    }
}
