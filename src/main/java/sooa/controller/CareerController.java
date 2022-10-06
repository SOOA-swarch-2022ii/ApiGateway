package sooa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sooa.domain.career_ms.Career;
import sooa.process.CareerProcess;

import java.text.ParseException;
import java.util.List;

@Controller
public class CareerController {
    @Autowired
    private CareerProcess careerProcess;


    public CareerController(CareerProcess careerProcess) {
        this.careerProcess = careerProcess;
    }

    @QueryMapping
    public List<Career> getCareers() {
        return careerProcess.getCareers();
    }

    @QueryMapping
    public Career getCareer(@Argument int _id) {
        return careerProcess.getCareer(_id);
    }

    @MutationMapping
    public Career createCareer(@Argument("input") Career career) throws ParseException {
        return careerProcess.createCareer(career);
    }

    @MutationMapping
    public void updateDeleteCareer(@Argument int _id, @Argument("subject") String subject) {
        careerProcess.updateDeleteCareer(_id, subject);
    }

    @MutationMapping
    public void updateAddCareer(@Argument int _id, @Argument("subject") String subject) {
        careerProcess.updateAddCareer(_id, subject);
    }

    @MutationMapping
    public void deleteCareer(@Argument int _id) {
        careerProcess.deleteCareer(_id);
    }
}