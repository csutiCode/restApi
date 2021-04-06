package serviceRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceRest.dto.QualifcationDto;
import serviceRest.exceptions.NotFoundException;
import serviceRest.model.Category;
import serviceRest.model.City;
import serviceRest.model.Qualification;
import serviceRest.model.ServiceAccount;
import serviceRest.repository.CityRepository;
import serviceRest.service.CityAndCategoryService;
import serviceRest.service.QualificationService;
import serviceRest.service.ServiceAccountService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ListController {

    @Autowired
    private ServiceAccountService serviceService;

    @Autowired
    private QualificationService qualificationService;

    @Autowired
    private CityAndCategoryService cityAndCategoryService;

    //listing all of the services
    @GetMapping("/all")
    public List<ServiceAccount> findAll() {
        List<ServiceAccount> services = serviceService.findAllServices();
        System.out.println(services);
        return services;
    }

    //to show one selected account
    @GetMapping("/{id}")
    public ResponseEntity<ServiceAccount> show(@PathVariable (value = "id") int id) {
        ServiceAccount account = serviceService.findById(id);
        System.out.println(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    //to qualify an account
    @PostMapping("/{id}/qualify")
    public ResponseEntity<String> qualify(@PathVariable (value = "id") int id, @Valid @RequestBody QualifcationDto dto) {

        Qualification qualification = dtoToQualification(dto, id);
        qualificationService.saveQualification(qualification);
        return new ResponseEntity<>("Qualification saved", HttpStatus.OK);
    }
    //to map a qualificationDto to a real qualification object
    public Qualification dtoToQualification(QualifcationDto dto, int serviceId) {
        Qualification qualification = new Qualification();
        qualification.setQualifier(dto.getQualifier());
        ServiceAccount service = serviceService.findById(serviceId);
        qualification.setOpinion(dto.getOpinion());
        service.getQualifications().add(qualification);
        return qualification;
    }
    //select by city
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<ServiceAccount>> getServicesByCity(@PathVariable (value = "cityName") String cityName) {
        try {
            City city = cityAndCategoryService.findCityByName(cityName);
            long cityId = city.getId();
            List<ServiceAccount> services = serviceService.findServicesByCityId(cityId);
            return  new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception exception) {
            throw new NotFoundException("City with name " + cityName +  " not found");
        }
    }
    //select by category
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<ServiceAccount>> getServicesByCategory(@PathVariable (value = "categoryName") String categoryName) {
        try {
            Category category = cityAndCategoryService.findCategoryByName(categoryName);
            long categoryId = category.getId();
            List<ServiceAccount> services = serviceService.findServicesByCategoryId(categoryId);
            return  new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception exception) {
            throw new NotFoundException("Category with name " + categoryName + " not found.");
        }

    }













}
