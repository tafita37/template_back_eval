package eval.mikolo.mikolo.service.mere.magasin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eval.mikolo.mikolo.model.magasin.MagasinUser;
import eval.mikolo.mikolo.repository.magasin.MagasinUserRepository;

@Service
public class MagasinUserService {
    @Autowired
    MagasinUserRepository magasinUserRepository;

    public Optional<MagasinUser> findByNomMagasinUserAndMdp(String nomMagasinUser, String mdp) {
        return magasinUserRepository.findByNomMagasinUserAndMdp(nomMagasinUser, mdp);
    }
}
