package serviceRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceRest.dto.ServiceAccountDto;
import serviceRest.model.ServiceAccount;
import serviceRest.repository.UserRepository;
import serviceRest.service.ServiceAccountService;

@RestController
@RequestMapping("/serviceAccount")
public class AccountController {

    //after the successful authentication at this page we can create/update our own account

    @Autowired
    private ServiceAccountService serviceService;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/create")
    public ResponseEntity<String> createService(@RequestBody ServiceAccountDto dto) {
        if (!serviceService.isServiceAccountAlreadyCreated()) {
            serviceService.saveService(dto);
            return new ResponseEntity ("Successful created", HttpStatus.CREATED);
        } else {
            System.out.println("Account already created");
            return new ResponseEntity ("Account already exists", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/show")
    public ResponseEntity<ServiceAccount> show() {
        ServiceAccount account = serviceService.findByEmail();
        System.out.println(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ServiceAccountDto accountDto){
        serviceService.saveService(accountDto);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }





}
