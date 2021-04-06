package serviceRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serviceRest.model.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
}
