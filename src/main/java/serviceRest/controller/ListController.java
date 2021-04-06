package serviceRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceRest.dto.QualifcationDto;
import serviceRest.model.City;
import serviceRest.model.Qualification;
import serviceRest.model.ServiceAccount;
import serviceRest.repository.CityRepository;
import serviceRest.service.QualificationService;
import serviceRest.service.ServiceAccountService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ListController {

    @Autowired
    private ServiceAccountService serviceService;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private QualificationService qualificationService;

    //listing all of the services
    @GetMapping("/all")
    public List<ServiceAccount> findAll() {
        List<ServiceAccount> services = serviceService.findAllServices();
        System.out.println(services);
        return services;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ServiceAccount> show(@PathVariable (value = "id") int id) {
        ServiceAccount account = serviceService.findById(id);
        System.out.println(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/{id}/qualify")
    public ResponseEntity<String> qualify(@PathVariable (value = "id") int id,@Valid @RequestBody QualifcationDto dto) {

        Qualification qualification = dtoToQualification(dto, id);
        qualificationService.saveQualification(qualification);
        return new ResponseEntity<>("Qualification saved", HttpStatus.OK);
    }

    public Qualification dtoToQualification(QualifcationDto dto, int serviceId) {
        Qualification qualification = new Qualification();
        qualification.setQualifier(dto.getQualifier());
        ServiceAccount service = serviceService.findById(serviceId);
        qualification.setOpinion(dto.getOpinion());
        service.getQualifications().add(qualification);
        return qualification;

    }













}
