package sooa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import graphql.execution.ResolveType;
import sooa.domain.career_ms.Career;

import java.util.List;

@Service
public class CareerService {
    @Autowired
    RestTemplate rest;

    public CareerService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Career getCareer(int _id) {
        return rest.getForObject("http://35.195.29.127:4445/career/{_id}",
                Career.class, _id);
    }

    public List<Career> getCareers() {
        return rest.getForObject("http://35.195.29.127:4445/career",
                List.class);
    }

    public Career createCareer(Career career) {
        return rest.postForObject("http://35.195.29.127:4445/career",
                career, Career.class);
    }
    //preguntar
    public void updateDeleteCareer(int _id, String subject) {
        rest.put("http://35.195.29.127:4445/career/delete/"+_id+"/"+ subject,null);
    }

    public void updateAddCareer(int _id, String subject) {
        rest.put("http://35.195.29.127:4445/career/add/"+_id+"/"+ subject,null);
    }

    public void deleteCareer(int _id) {
        rest.delete("http://35.195.29.127:4445/career/{_id}",
                _id);
    }
}