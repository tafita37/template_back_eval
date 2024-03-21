package eval.mikolo.mikolo.controller.magasin;

import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eval.mikolo.mikolo.model.magasin.MagasinUser;
import eval.mikolo.mikolo.service.mere.authentification.AuthenticationService;
import eval.mikolo.mikolo.service.mere.magasin.MagasinUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/magasin")
public class Magasin_Controller {
    @Autowired
    MagasinUserService magasinUserService;
    @Autowired 
    AuthenticationService authenticationService;

    @PostMapping("/signUpMagasin")
    public Hashtable<String, Object> insertMagasin(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }

    @PostMapping("/loginMagasin")
    public Hashtable<String, Object> loginMagasin(@RequestBody MagasinUser magasinUser) {
        return authenticationService.authenticate(magasinUser);
    }
}
