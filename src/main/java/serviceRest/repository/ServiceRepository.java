package serviceRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import serviceRest.model.ServiceAccount;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceAccount, Long> {

    ServiceAccount findByEmail(String email);

    ServiceAccount findById(long id);

    List<ServiceAccount> findByCityId(long id);

}
