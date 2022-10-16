package sooa.process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooa.domain.academic_records_ms.AcademicInfo;
import sooa.service.AcademicRecordService;
import sooa.domain.reg_and_auth_ms.User;
import sooa.service.RMQMessagingService;
import java.util.List;

@Component
public class SubjectBrowserProcess {
    @Autowired
    private AcademicRecordService academicRecordService;

    
    @Autowired
    private RMQMessagingService rmqMessagingService;

}
