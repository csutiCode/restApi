package serviceRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceRest.model.Qualification;
import serviceRest.repository.QualificationRepository;

@Service
public class QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    public void saveQualification(Qualification qualification) {
        qualificationRepository.save(qualification);
    }

}
