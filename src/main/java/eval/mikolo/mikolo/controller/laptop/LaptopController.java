package eval.mikolo.mikolo.controller.laptop;

import java.util.Hashtable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import eval.mikolo.mikolo.config.JwtService;
import eval.mikolo.mikolo.model.laptop.Laptop;
import eval.mikolo.mikolo.model.laptop.ReceptionRenvoieLaptop;
import eval.mikolo.mikolo.model.laptop.RenvoieLaptop;
import eval.mikolo.mikolo.model.laptop.disque.Disque;
import eval.mikolo.mikolo.model.laptop.disque.TypeDisque;
import eval.mikolo.mikolo.model.laptop.marque.Marque;
import eval.mikolo.mikolo.model.laptop.processeur.Processeur;
import eval.mikolo.mikolo.model.laptop.ram.Ram;
import eval.mikolo.mikolo.model.laptop.ram.TypeRam;
import eval.mikolo.mikolo.model.laptop.stock.StockLaptop;
import eval.mikolo.mikolo.model.laptop.transfert.ReceptionLaptop;
import eval.mikolo.mikolo.model.laptop.transfert.TransfertLaptop;
import eval.mikolo.mikolo.model.laptop.vente.VenteLaptop;
import eval.mikolo.mikolo.model.pdv.PointVente;
import eval.mikolo.mikolo.service.mere.laptop.LaptopService;
import eval.mikolo.mikolo.service.mere.pdv.PdvService;

@RestController
@CrossOrigin("*")
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @Autowired
    PdvService pdvService;
    @Autowired 
    UserDetailsService userDetailsService;
    @Autowired
    JwtService jwtService;

    @PostMapping("/marque/insertMarque")
    public ResponseEntity<Hashtable<String, Object>> insertMarque(@RequestBody Marque marque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque inseree");
        result.put("status", HttpStatus.CREATED.value());
        laptopService.saveMarque(marque);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/processeur/insertProcesseur")
    public ResponseEntity<Hashtable<String, Object>> insertProcesseur(@RequestBody Processeur processeur) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Processeur inseree");
        result.put("status", HttpStatus.CREATED.value());
        laptopService.saveProcesseur(processeur);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/ram/insertTypeRam")
    public ResponseEntity<Hashtable<String, Object>> insertTypeRam(@RequestBody TypeRam typeRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de ram inseree");
        result.put("status", HttpStatus.CREATED.value());
        laptopService.saveTypeRam(typeRam);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/ram/allTypeRam/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllTypeRam(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de ram recuperee");
        result.put("status", HttpStatus.CREATED.value());
        result.put("data", laptopService.findAllTypeRam(numPage));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/ram/allTypeRam")
    public ResponseEntity<Hashtable<String, Object>> getAllTypeRam() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de ram recuperee");
        result.put("status", HttpStatus.OK.value());
        result.put("data", laptopService.findAllTypeRam());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/ram/insertRam")
    public ResponseEntity<Hashtable<String, Object>> insertRam(@RequestBody Ram ram)
    throws Exception {
        ram.setCapacite(ram.getCapacite());
        ram.setFrequence(ram.getFrequence());
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Ram inseree");
        result.put("status", HttpStatus.CREATED.value());
        laptopService.saveRam(ram);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/ram/deleteRamById")
    public ResponseEntity<Hashtable<String, Object>> deleteRamById(@RequestParam int idRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Ram supprimee");
        laptopService.deleteRamById(idRam);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/ram/deleteTypeRamById")
    public ResponseEntity<Hashtable<String, Object>> deleteTypeRamById(@RequestParam int idTypeRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "TypeRam supprimee");
        laptopService.deleteTypeRamById(idTypeRam);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/disque/deleteTypeDisqueById")
    public ResponseEntity<Hashtable<String, Object>> deleteTypeDisqueById(@RequestParam int idTypeDisque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "TypeDisque supprimee");
        laptopService.deleteTypeDisqueById(idTypeDisque);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/disque/insertTypeDisque")
    public ResponseEntity<Hashtable<String, Object>> insertTypeDisque(@RequestBody TypeDisque typeDisque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de disque inseree");
        laptopService.saveTypeDisque(typeDisque);
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/disque/allTypeDisque")
    public ResponseEntity<Hashtable<String, Object>> getAllTypeDisque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de disque recuperee");
        result.put("data", laptopService.findAllTypeDisque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/disque/allTypeDisque/{numPage}")
    public ResponseEntity<Hashtable<String, Object> >getAllTypeDisque(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de disque recuperee");
        result.put("data", laptopService.findAllTypeDisque(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/disque/insertDisque")
    public ResponseEntity<Hashtable<String, Object>> insertDisque(@RequestBody Disque disque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Disque inseree");
        laptopService.saveDisque(disque);
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/marque/allMarque/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllMarque(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque recuperee");
        result.put("data", laptopService.getAllMarque(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/marque/allMarque")
    public ResponseEntity<Hashtable<String, Object>> getAllMarque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque recuperee");
        result.put("data", laptopService.getAllMarque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/marque/nbPagesMarque")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesMarque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de marques recuperee");
        result.put("data", laptopService.countNbPagesMarque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/nbPagesLaptop")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesLaptop() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de laptop recuperee");
        result.put("data", laptopService.countNbPagesLaptop());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/disque/nbPagesDisque")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesDisque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de disques recuperee");
        result.put("data", laptopService.countNbPagesDisque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/disque/nbPagesTypeDisque")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesTypeDisque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de type de disque recuperee");
        result.put("data", laptopService.countNbPagesTypeDisque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/disque/nbPagesTypeDisqueRecherche")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesTypeDisque(@RequestParam String nomTypeDisque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de type de disque recuperee");
        result.put("data", laptopService.countNbPagesTypeDisque(nomTypeDisque));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/ram/nbPagesRam")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesRam() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de ram recuperee");
        result.put("data", laptopService.countNbPagesRam());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/ram/nbPagesTypeRam")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesTypeRam() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de type de ram recuperee");
        result.put("data", laptopService.countNbPagesTypeRam());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/marque/nbPagesMarqueRecherche")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesMarque(@RequestParam String nomMarque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de marques recuperee");
        result.put("data", laptopService.countNbPagesMarqueRecherche(nomMarque));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/ram/nbPagesTypeRamRecherche")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesTypeRam(@RequestParam String nomTypeRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de type de ram recuperee");
        result.put("data", laptopService.countNbPagesTypeRamRecherche(nomTypeRam));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/processeur/nbPagesProcesseur")
    public ResponseEntity<Hashtable<String, Object>> getNbPagesProcesseur() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Nombre de pages de processeur recuperee");
        result.put("data", laptopService.countNbPagesProcesseur());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/marque/findMarqueById")
    public ResponseEntity<Hashtable<String, Object>> findMarqueById(@RequestParam int idMarque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque recuperee");
        result.put("data", laptopService.findMarqueById(idMarque));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/marque/deleteMarqueById")
    public ResponseEntity<Hashtable<String, Object>> deleteMarqueById(@RequestParam int idMarque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque effacee");
        laptopService.deleteMarqueById(idMarque);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @PostMapping("/marque/findMarqueByName")
    public ResponseEntity<Hashtable<String, Object>> findMarqueByName(@RequestParam String nomMarque, @RequestParam int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Marque retrouvee");
        result.put("data", laptopService.findMarqueByName(nomMarque, numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @PostMapping("/ram/findTypeRamByName")
    public ResponseEntity<Hashtable<String, Object>> findTypeRamByName(@RequestParam String nomTypeRam, @RequestParam int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "TypeRam retrouvee");
        result.put("data", laptopService.findTypeRamByName(nomTypeRam, numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @PostMapping("/disque/findTypeDisqueByName")
    public ResponseEntity<Hashtable<String, Object>> findTypeDisqueByName(@RequestParam String nomTypeDisque, @RequestParam int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de Disque retrouvee");
        result.put("data", laptopService.findTypeDisqueByName(nomTypeDisque, numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/disque/findTypeDisqueById")
    public ResponseEntity<Hashtable<String, Object>> findTypeDisqueById(@RequestParam int idTypeDisque) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Type de Disque retrouvee");
        result.put("data", laptopService.findTypeDisqueById(idTypeDisque));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 

    @GetMapping("/processeur/allProcesseur/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllProcesseur(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Processeur recuperee");
        result.put("data", laptopService.getAllProcesseur(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/processeur/allProcesseur")
    public ResponseEntity<Hashtable<String, Object>> getAllProcesseur() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Processeur recuperee");
        result.put("data", laptopService.getAllProcesseur());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/processeur/deleteProcesseurById")
    public ResponseEntity<Hashtable<String, Object>> deleteProcesseurById(@RequestParam int idProcesseur) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Processeur supprimee");
        laptopService.deleteProcesseurById(idProcesseur);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/processeur/findProcesseurById")
    public ResponseEntity<Hashtable<String, Object>> findProcesseurById(@RequestParam int idProcesseur) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Processeur recuperee");
        result.put("data", laptopService.findProcesseurById(idProcesseur));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/ram/allRam/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllRam(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Ram recuperee");
        result.put("data", laptopService.getAllRam(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/ram/allRam")
    public ResponseEntity<Hashtable<String, Object>> getAllRam() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Ram recuperee");
        result.put("data", laptopService.getAllRam());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/ram/findRamById")
    public ResponseEntity<Hashtable<String, Object>> findRamById(@RequestParam int idRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Ram recuperee");
        result.put("data", laptopService.findRamById(idRam));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/ram/findTypeRamById")
    public ResponseEntity<Hashtable<String, Object>> findTypeRamById(@RequestParam int idTypeRam) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "TypeRam recuperee");
        result.put("data", laptopService.findTypeRamById(idTypeRam));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/disque/allDisque")
    public ResponseEntity<Hashtable<String, Object>> getAllDisque() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Disque dur recuperee");
        result.put("data", laptopService.getAllDisque());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/disque/allDisque/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllDisque(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Disque dur recuperee");
        result.put("data", laptopService.getAllDisque(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/disque/findDisqueById")
    public ResponseEntity<Hashtable<String, Object>> findDisqueById(@RequestParam int idDisque)  {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Disque dur recuperee");
        result.put("data", laptopService.findDisqueById(idDisque));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/disque/deleteDisqueById")
    public ResponseEntity<Hashtable<String, Object>> deleteDisqueById(@RequestParam int idDisque)  {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Disque dur supprimee");
        laptopService.deleteDisqueById(idDisque);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/insertLaptop")
    public ResponseEntity<Hashtable<String, Object>> insertLaptop(@RequestBody Laptop laptop) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop inseree");
        laptopService.saveLaptop(laptop);
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/allLaptop")
    public ResponseEntity<Hashtable<String, Object>> getAllLaptop() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop recuperee");
        result.put("data", laptopService.getAllLaptop());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/allLaptop/{numPage}")
    public ResponseEntity<Hashtable<String, Object>> getAllLaptop(@PathVariable int numPage) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop recuperee");
        result.put("data", laptopService.getAllLaptop(numPage));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/findLaptopById")
    public ResponseEntity<Hashtable<String, Object>> findLaptopById(@RequestParam int idLaptop) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop recuperee");
        result.put("data", laptopService.findLaptopById(idLaptop));
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/deleteLaptopById")
    public ResponseEntity<Hashtable<String, Object>> deleteLaptopById(@RequestParam int idLaptop) {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop supprimee");
        laptopService.deleteLaptopById(idLaptop);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/newStockLaptop")
    public ResponseEntity<Hashtable<String, Object>> newStockLaptop(@RequestBody StockLaptop stockLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Stock de laptop ajoutee");
        result.put("data", laptopService.saveStockLaptop(stockLaptop));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/transfererLaptop")
    public ResponseEntity<Hashtable<String, Object>> transfererLaptop(@RequestBody TransfertLaptop transfertLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        PointVente pointVente=pdvService.findPointVenteById(transfertLaptop.getPointVente().getIdPointVente());
        result.put("message", "Laptop transferee au point de vente "+pointVente.getNomPointVente());
        laptopService.transfererStockPointVente(transfertLaptop);
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/renvoieLaptop")
    public ResponseEntity<Hashtable<String, Object>> renvoieLaptop(@RequestBody RenvoieLaptop renvoieLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop renvoie au magasin centrale");
        result.put("data", laptopService.renvoieLaptop(renvoieLaptop));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/receptionLaptop")
    public ResponseEntity<Hashtable<String, Object>> receiveLaptop(@RequestHeader Map<String, String> headers, @RequestBody ReceptionLaptop receptionLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        String token=headers.get("authorization").substring(7);
        receptionLaptop.setTransfertLaptop(laptopService.findTransfertLaptopById(receptionLaptop.getTransfertLaptop().getIdTransfertLaptop()));
        result.put("message", "Laptop recu");
        result.put("data", laptopService.receptionPointVente(receptionLaptop, token));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/receptionRenvoieLaptop")
    public ResponseEntity<Hashtable<String, Object>> receiveSendLaptop(@RequestHeader Map<String, String> headers, @RequestBody ReceptionRenvoieLaptop receptionRenvoieLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        String token=headers.get("authorization").substring(7);
        receptionRenvoieLaptop.setRenvoieLaptop(laptopService.findRenvoieLaptopById(receptionRenvoieLaptop.getRenvoieLaptop().getIdRenvoieLaptop()));
        result.put("message", "Laptop recu");
        result.put("data", laptopService.receptionRenvoiePointVente(receptionRenvoieLaptop, token));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/resteStock")
    public ResponseEntity<Hashtable<String, Object>> getResteStock() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Reste de stock recuperee");
        result.put("data", laptopService.getResteStockLaptopByLaptop());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/allTransfertLaptop")
    public ResponseEntity<Hashtable<String, Object>> getAllTransfertLaptop() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Transfert de laptop recuperee");
        result.put("data", laptopService.getAllTransfertLaptop());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/allRenvoieLaptop")
    public ResponseEntity<Hashtable<String, Object>> getAllRenvoieLaptop() {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Renvoie de laptop recuperee");
        result.put("data", laptopService.getAllRenvoieLaptop());
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/vendreLaptop")
    public ResponseEntity<Hashtable<String, Object>> vendreLaptop(@RequestBody VenteLaptop venteLaptop)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop vendu");
        laptopService.vendreLaptop(venteLaptop);
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/statVenteMois")
    public ResponseEntity<Hashtable<String, Object>> getStatOfVente(@RequestParam int annee)
    throws Exception {
        Hashtable<String, Object> result=new Hashtable<>();
        result.put("message", "Laptop vendu");
        result.put("data", laptopService.getStatVenteTotalMois(annee));
        result.put("status", HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
