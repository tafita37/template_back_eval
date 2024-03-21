package eval.mikolo.mikolo.service.mere.authentification;

import java.util.Hashtable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import eval.mikolo.mikolo.config.JwtService;
import eval.mikolo.mikolo.controller.magasin.AuthenticationResponse;
import eval.mikolo.mikolo.controller.magasin.RegisterRequest;
import eval.mikolo.mikolo.model.magasin.MagasinUser;
import eval.mikolo.mikolo.model.pdv.user.User;
import eval.mikolo.mikolo.repository.magasin.MagasinUserRepository;
import eval.mikolo.mikolo.repository.pdv.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class   AuthenticationService {
    
    private final MagasinUserRepository magasinUserRepository;
    
    private final JwtService jwtService;
    
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    public Hashtable <String,Object> register(RegisterRequest request) {
        Hashtable <String,Object> registerResponse = new Hashtable<>();
        try {
            MagasinUser magasinUser=new MagasinUser(request.getMail(), passwordEncoder.encode(request.getPassword()), "MAGASIN");
            magasinUserRepository.save(magasinUser); 
            var jwtToken = jwtService.generateToken(magasinUser);
            AuthenticationResponse tokenObj =AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    
            registerResponse.put("status" , 200);
            registerResponse.put("message", "Compte créer !");
            registerResponse.put("data", tokenObj);
        } catch (Exception e) {
            registerResponse.put("status" , 500);
            registerResponse.put("message", e.getMessage());
        }

        return registerResponse;
    } 

    public ResponseEntity<Hashtable <String,Object>> registerUser(User user)
    throws Exception {
        Hashtable <String,Object> result = new Hashtable<>();
        user.setMdpUser(passwordEncoder.encode(user.getMdpUser()));
        user.setRole("PDV");
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse tokenObj =AuthenticationResponse.builder()
                                                                .token(jwtToken)
                                                                .build();
        result.put("status", HttpStatus.CREATED.value());
        result.put("message", "Compte créer !");
        result.put("data", tokenObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } 

    public Hashtable <String,Object> authenticate(MagasinUser magasinUser){
        Hashtable <String,Object> authenticationResponse = new Hashtable<>();
        try {
            magasinUser.setRole("MAGASIN");
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(magasinUser.getUsername(), magasinUser.getPassword())
            );
            var user = magasinUserRepository.findByNomMagasinUser(magasinUser.getNomMagasinUser()).orElseThrow(); 
            String jwtToken = jwtService.generateToken(user);
            AuthenticationResponse tokenObj = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
            authenticationResponse.put("status", 200);
            authenticationResponse.put("message", "Vous etes connectée");
            authenticationResponse.put("data", tokenObj);
        } 
        catch (Exception e) {
            e.printStackTrace();
            authenticationResponse.put("status", 400);
            authenticationResponse.put("message", "Mot de passe ou mail incorectes !");
            authenticationResponse.put("data", "no data");
            return authenticationResponse;
        }
        return authenticationResponse;
    }

    public Hashtable <String,Object> authenticateUser(User utilisateur){
        Hashtable <String,Object> authenticationResponse = new Hashtable<>();
        try {
            utilisateur.setRole("PDV");
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(utilisateur.getUsername(), utilisateur.getPassword())
            );
            var user = userRepository.findByEmailUser(utilisateur.getEmailUser()).orElseThrow(); 
            String jwtToken = jwtService.generateToken(user);
            AuthenticationResponse tokenObj = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
            authenticationResponse.put("status", 200);
            authenticationResponse.put("message", "Vous etes connectée");
            authenticationResponse.put("data", tokenObj);
        } 
        catch (Exception e) {
            e.printStackTrace();
            authenticationResponse.put("status", 400);
            authenticationResponse.put("message", "Mot de passe ou mail incorectes !");
            authenticationResponse.put("data", "no data");
            return authenticationResponse;
        }
        return authenticationResponse;
    }

}