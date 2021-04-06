package serviceRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import serviceRest.dto.ServiceAccountDto;
import serviceRest.model.Category;
import serviceRest.model.City;
import serviceRest.model.ServiceAccount;
import serviceRest.model.User;
import serviceRest.repository.CategoryRepository;
import serviceRest.repository.CityRepository;
import serviceRest.repository.ServiceRepository;
import serviceRest.repository.UserRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceAccountService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<ServiceAccount> findAllServices() {
        return serviceRepository.findAll();
    }


    public void saveService(ServiceAccountDto dto) {
        ServiceAccount service = mapDtoToService(dto);
        serviceRepository.save(service);
    }

    public boolean isServiceAccountAlreadyCreated() {
        User user = userRepository.findUserByEmail(getCurrentUserName());
        if (user != null && user.getServiceAccount() != null) {
            return true;
        } else {
            return false;
        }
    }

    public ServiceAccount mapDtoToService(ServiceAccountDto dto) {
        ServiceAccount serviceAccount;
        //check if it's existing
        //if exists, update
        if (findByEmail() != null) {
            serviceAccount = findByEmail();
            //if doesn't exist, create
        } else {
            serviceAccount = new ServiceAccount();
        }
        serviceAccount.setFirstName(dto.getFirstName());
        serviceAccount.setLastName(dto.getLastName());
        serviceAccount.setProvidedService(dto.getProvidedService());
        serviceAccount.setAbout(dto.getAbout());
        serviceAccount.setEmail(getCurrentUser().getEmail());
        getCurrentUser().setServiceAccount(serviceAccount);

        return serviceAccount;
    }

    public String getCurrentUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal!=null) {
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else {
                return principal.toString();
            }
        } else {
            return null;
        }
    }

    public User getCurrentUser() {
        String username = getCurrentUserName();
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return user;
    }

    //Get the category from database
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public ServiceAccount findByEmail() {
        ServiceAccount account = serviceRepository.findByEmail(getCurrentUser().getEmail());
        return  account;
    }

    public ServiceAccount findById(long id) {
        ServiceAccount account = serviceRepository.findById(id);
        return  account;
    }

    public List<ServiceAccount> findServicesByCityId(long id) {
        return serviceRepository.findByCityId(id);
    }

    public List<ServiceAccount> findServicesByCategoryId(long categoryId) {
        return serviceRepository.findByCategoryId(categoryId);
    }
}
