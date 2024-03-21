package eval.mikolo.mikolo.repository.pdv;

import org.springframework.data.jpa.repository.JpaRepository;
import eval.mikolo.mikolo.model.pdv.PointVenteUser;
import java.util.Optional;
import eval.mikolo.mikolo.model.pdv.user.User;

public interface PointVenteUserRepository extends JpaRepository<PointVenteUser, Integer> {
    Optional<PointVenteUser> findByUser(User user);
}
