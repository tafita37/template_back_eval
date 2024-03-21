package eval.mikolo.mikolo.service.mere.pdv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import eval.mikolo.mikolo.config.JwtService;
import eval.mikolo.mikolo.model.pdv.PointVente;
import eval.mikolo.mikolo.model.pdv.PointVenteUser;
import eval.mikolo.mikolo.model.pdv.user.User;
import eval.mikolo.mikolo.repository.pdv.PointVenteRepository;
import eval.mikolo.mikolo.repository.pdv.PointVenteUserRepository;
import eval.mikolo.mikolo.repository.pdv.user.UserRepository;

@Service
public class PdvService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PointVenteRepository pointVenteRepository;
    @Autowired
    PointVenteUserRepository pointVenteUserRepository;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtService jwtService;

    public void saveUser(User user)
    throws Exception {
        userRepository.save(user);
    }

    public PointVente savePointVente(PointVente pointVente) {
        return pointVenteRepository.save(pointVente);
    }

    public PointVenteUser savePointVenteUser(PointVenteUser pointVenteUser) {
        return pointVenteUserRepository.save(pointVenteUser);
    }

    public PointVente findPointVenteById(int idPointVente) {
        return pointVenteRepository.findById(idPointVente).get();
    }

    public User findUserById(int idUser) {
        return userRepository.findById(idUser).get();
    }

    public List<PointVente> getAllPointVente() {
        return pointVenteRepository.findAll();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserByEmailAndPassword(String emailUser, String mdpUser) {
        return userRepository.findByEmailUserAndMdpUser(emailUser, mdpUser).get();
    }

    public User findUserByEmail(String emailUser) {
        return userRepository.findByEmailUser(emailUser).get();
    }

    public void deletePointVenteById(int idPointVente) {
        pointVenteRepository.deleteById(idPointVente);
    }

    public List<User> findListUserOfPointVente(int idPointVente) {
        return userRepository.findUserByIdPointVente(idPointVente);
    }

    public void deleteUserById(int idUser) {
        userRepository.deleteUserById(idUser);
    }

    public PointVenteUser findPointVenteUserByUser(User user) {
        return pointVenteUserRepository.findByUser(user).get();
    }
    
    public User findUSerConnected(String token) {
        String userName=jwtService.extractUserMail(token);
        return (User) userDetailsService.loadUserByUsername(userName);
    }

    public void deletePointVenteUser(PointVenteUser pointVenteUser) {
        pointVenteUserRepository.delete(pointVenteUser);
    }
}
