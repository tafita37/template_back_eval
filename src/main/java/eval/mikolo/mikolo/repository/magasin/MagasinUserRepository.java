package eval.mikolo.mikolo.repository.magasin;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import eval.mikolo.mikolo.model.magasin.MagasinUser;

public interface MagasinUserRepository extends JpaRepository<MagasinUser, Integer> {
    Optional<MagasinUser> findByNomMagasinUserAndMdp(String nomMagasinUser, String mdp);
    Optional<MagasinUser> findByNomMagasinUser(String nomMagasinUser);
    Optional<MagasinUser> findByNomMagasinUserAndRole(String nomMagasinUser, String role);
}
