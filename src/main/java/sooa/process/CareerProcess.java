package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.career_ms.Career;
import sooa.service.CareerService;

import java.util.List;

@Component
public class CareerProcess {
    
    @Autowired
    private CareerService careerService;

    public CareerProcess(CareerService careerService) {
        this.careerService = careerService;
    }

    public List<Career> getCareers() {
        return careerService.getCareers();
    }

    public Career getCareer( int _id) {
        return careerService.getCareer(_id);
    }

    public Career createCareer(Career career) {
        return careerService.createCareer(career);
    }

    public void updateDeleteCareer(int _id, String subject) {
        careerService.updateDeleteCareer(_id, subject);
    }

    public void updateAddCareer(int _id, String subject) {
        careerService.updateAddCareer(_id, subject);
    }

    public void deleteCareer(int _id) {
        careerService.deleteCareer(_id);
    }
}
