package eval.mikolo.mikolo.controller.pdv;

import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import eval.mikolo.mikolo.model.pdv.PointVente;
import eval.mikolo.mikolo.model.pdv.PointVenteUser;
import eval.mikolo.mikolo.model.pdv.user.User;
import eval.mikolo.mikolo.service.mere.authentification.AuthenticationService;
import eval.mikolo.mikolo.service.mere.pdv.PdvService;

@RestController
@RequestMapping("/pdv")
@CrossOrigin("*")
public class Pdv_Controller {
    @Autowired
    PdvService pdvService;
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/user/allUser")
    public Hashtable<String, Object> getAllUser() {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Users recuperees");
            result.put("data", pdvService.getAllUser());
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @GetMapping("/user/findUserById")
    public Hashtable<String, Object> findUserById(@RequestParam int idUser) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "User recuperee");
            result.put("data", pdvService.findUserById(idUser));
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping("/user/insertUser")
    public ResponseEntity<Hashtable<String, Object>> insertUser(@RequestBody User user)
    throws Exception {
        return authenticationService.registerUser(user);
    }

    @PostMapping("/user/modifUser")
    public Hashtable<String, Object> modificateUser(@RequestBody User user) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Users modifier");
            pdvService.saveUser(user);
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping("/insertPDV")
    public ResponseEntity<Hashtable<String, Object>> insertPdv(@RequestBody PointVente pointVente) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Point de vente inseree");
        result.put("data", pdvService.savePointVente(pointVente));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/allPointVente")
    public Hashtable<String, Object> getAllPointVente() {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Point de ventes recuperees");
            result.put("data", pdvService.getAllPointVente());
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    } 

    @GetMapping("/deletePointVenteById")
    public Hashtable<String, Object> deletePointVenteById(@RequestParam int idPointVente) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Point de ventes supprimee");
            pdvService.deletePointVenteById(idPointVente);
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    } 

    @PostMapping("/affectUserToPdv")
    public ResponseEntity<Hashtable<String, Object>> affectUserToPdv(@RequestBody PointVenteUser pointVenteUser) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "User affecte a point de vente");
        result.put("data", pdvService.savePointVenteUser(pointVenteUser));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/modifPdvOfUser")
    public Hashtable<String, Object> modifPdvOfUser(@RequestBody PointVenteUser pointVenteUser) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            PointVenteUser modifPoint=pdvService.findPointVenteUserByUser(pointVenteUser.getUser());
            modifPoint.setPointVente(pointVenteUser.getPointVente());
            result.put("message", "Point de vente de l'user modifier");
            result.put("data", pdvService.savePointVenteUser(modifPoint));
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @GetMapping("/user/deleteUserOfPdv")
    public Hashtable<String, Object> deleteUserOfPdv(@RequestParam int idUser) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            User user=pdvService.findUserById(idUser);
            PointVenteUser pointVenteUser=pdvService.findPointVenteUserByUser(user);
            result.put("message", "User supprimee du point de vente");
            pdvService.deletePointVenteUser(pointVenteUser);
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping("/user/loginUser")
    public Hashtable<String, Object> loginMagasin(@RequestBody User user) {
        return authenticationService.authenticateUser(user);
    }

    @GetMapping("/findPointVenteById") 
    public Hashtable<String, Object> findPointVenteById(@RequestParam int idPointVente) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Point de vente recuperee");
            result.put("data", pdvService.findPointVenteById(idPointVente));
            result.put("status", 200);
        } catch (Exception e) {
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @GetMapping("/user/allUserOfPointVente")
    public Hashtable<String, Object> findUserOfPointVente(@RequestParam int idPointVente) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Users recuperee");
            result.put("data", pdvService.findListUserOfPointVente(idPointVente));
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }

    @GetMapping("/user/deleteUserById")
    public Hashtable<String, Object> deleteUserById(@RequestParam int idUser) {
        Hashtable<String, Object> result=new Hashtable<>();
        try {
            result.put("message", "Users supprimee");
            pdvService.deleteUserById(idUser);
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("message", e.getMessage());
            result.put("status", 500);
        }
        return result;
    }
}
