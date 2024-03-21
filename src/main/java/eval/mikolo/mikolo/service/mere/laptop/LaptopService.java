package eval.mikolo.mikolo.service.mere.laptop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eval.mikolo.mikolo.model.laptop.Laptop;
import eval.mikolo.mikolo.model.laptop.ReceptionRenvoieLaptop;
import eval.mikolo.mikolo.model.laptop.RenvoieLaptop;
import eval.mikolo.mikolo.model.laptop.disque.Disque;
import eval.mikolo.mikolo.model.laptop.disque.TypeDisque;
import eval.mikolo.mikolo.model.laptop.marque.Marque;
import eval.mikolo.mikolo.model.laptop.processeur.Processeur;
import eval.mikolo.mikolo.model.laptop.ram.Ram;
import eval.mikolo.mikolo.model.laptop.ram.TypeRam;
import eval.mikolo.mikolo.model.laptop.stat.StatVenteTotalMois;
import eval.mikolo.mikolo.model.laptop.stock.ResteStockLaptop;
import eval.mikolo.mikolo.model.laptop.stock.StockLaptop;
import eval.mikolo.mikolo.model.laptop.stock.pdv.StockPointVente;
import eval.mikolo.mikolo.model.laptop.transfert.ReceptionLaptop;
import eval.mikolo.mikolo.model.laptop.transfert.TransfertLaptop;
import eval.mikolo.mikolo.model.laptop.vente.VenteLaptop;
import eval.mikolo.mikolo.model.pdv.PointVente;
import eval.mikolo.mikolo.model.pdv.PointVenteUser;
import eval.mikolo.mikolo.model.pdv.user.User;
import eval.mikolo.mikolo.repository.laptop.LaptopRepository;
import eval.mikolo.mikolo.repository.laptop.ReceptionRenvoieLaptopRepository;
import eval.mikolo.mikolo.repository.laptop.RenvoieLaptopRepository;
import eval.mikolo.mikolo.repository.laptop.stock.StockLaptopRepository;
import eval.mikolo.mikolo.repository.laptop.stock.pdv.StockPointVenteRepository;
import eval.mikolo.mikolo.repository.laptop.transfert.ReceptionLaptopRepository;
import eval.mikolo.mikolo.repository.laptop.transfert.TransfertLaptopRepository;
import eval.mikolo.mikolo.repository.pdv.PointVenteRepository;
import eval.mikolo.mikolo.service.mere.pdv.PdvService;

@Service
public class LaptopService {
    @Autowired 
    LaptopRepository laptopRepository;
    @Autowired
    StockLaptopRepository stockLaptopRepository;
    @Autowired
    StockPointVenteRepository stockPointVenteRepository;
    @Autowired
    PointVenteRepository pointVenteRepository;
    @Autowired
    TransfertLaptopRepository transfertLaptopRepository;
    @Autowired
    PdvService pdvService;
    @Autowired
    ReceptionLaptopRepository receptionLaptopRepository;
    @Autowired
    RenvoieLaptopRepository renvoieLaptopRepository;
    @Autowired
    ReceptionRenvoieLaptopRepository receptionRenvoieLaptopRepository;

    public void saveMarque(Marque marque) {
        laptopRepository.saveMarque(marque);
    }

    public void saveProcesseur(Processeur processeur) {
        laptopRepository.saveProcesseur(processeur);
    }

    public void saveTypeRam(TypeRam typeRam) {
        laptopRepository.save(typeRam);
    }

    public List<TypeRam> findAllTypeRam(int numPage) {
        return laptopRepository.findAllTypeRam(numPage);
    }

    public List<TypeRam> findAllTypeRam() {
        return laptopRepository.findAllTypeRam();
    }

    public void saveRam(Ram ram) {
        laptopRepository.saveRam(ram);
    }

    public void saveTypeDisque(TypeDisque typeDisque) {
        laptopRepository.saveTypeDisque(typeDisque);
    }

    public List<TypeDisque> findAllTypeDisque() {
        return laptopRepository.findAllTypeDisque();
    }

    public List<TypeDisque> findAllTypeDisque(int numPage) {
        return laptopRepository.findAllTypeDisque(numPage);
    }

    public void saveDisque(Disque disque) {
        laptopRepository.saveDisque(disque);
    }

    public void saveLaptop(Laptop laptop) {
        laptopRepository.saveLaptop(laptop);
    }

    public List<Marque> getAllMarque(int numPage) {
        return laptopRepository.findAllMarque(numPage);
    }

    public List<Marque> getAllMarque() {
        return laptopRepository.findAllMarque();
    }

    public List<Processeur> getAllProcesseur(int numPage) {
        return laptopRepository.findAllProcesseur(numPage);
    }

    public List<Processeur> getAllProcesseur() {
        return laptopRepository.findAllProcesseur();
    }

    public List<Ram> getAllRam() {
        return laptopRepository.findAllRam();
    }

    public List<Ram> getAllRam(int numPage) {
        return laptopRepository.findAllRam(numPage);
    }

    public List<Disque> getAllDisque() {
        return laptopRepository.findAllDisque();
    }

    public List<Disque> getAllDisque(int numPage) {
        return laptopRepository.findAllDisque(numPage);
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAllLaptop();
    }

    public List<Laptop> getAllLaptop(int numPage) {
        return laptopRepository.findAllLaptop(numPage);
    }

    public Disque findDisqueById(int idDisque) {
        return laptopRepository.findDisqueByIdDisque(idDisque).get();
    }

    public TypeDisque findTypeDisqueById(int idTypeDisque) {
        return laptopRepository.findTypeDisqueByIdTypeDisque(idTypeDisque).get();
    }

    public void deleteDisqueById(int idDisque) {
        laptopRepository.deleteDisqueByIdDisque(idDisque);
    }

    public Marque findMarqueById(int idMarque) {
        return laptopRepository.findMarqueByIdMarque(idMarque).get();
    }

    public Processeur findProcesseurById(int idProcesseur) {
        return laptopRepository.findProcesseurByIdProcesseur(idProcesseur).get();
    }

    public void deleteMarqueById(int idMarque) {
        laptopRepository.deleteMarqueByIdMarque(idMarque);
    }

    public void deleteProcesseurById(int idProcesseur) {
        laptopRepository.deleteProcesseurByIdProcesseur(idProcesseur);
    }

    public Ram findRamById(int idRam) {
        return laptopRepository.findRamByIdRam(idRam).get();
    }

    public TypeRam findTypeRamById(int idTypeRam) {
        return laptopRepository.findTypeRamByIdTypeRam(idTypeRam).get();
    }

    public void deleteRamById(int idRam) {
        laptopRepository.deleteRamByIdRam(idRam);
    }

    public void deleteTypeRamById(int idTypeRam) {
        laptopRepository.deleteTypeRamByIdTypeRam(idTypeRam);
    }

    public void deleteTypeDisqueById(int idTypeDisque) {
        laptopRepository.deleteTypeDisqueByIdTypeDisque(idTypeDisque);
    }

    public Laptop findLaptopById(int idLaptop) {
        return laptopRepository.findLaptopByIdLaptop(idLaptop).get();
    }

    public void deleteLaptopById(int idLaptop) {
        laptopRepository.deleteLaptopByIdLaptop(idLaptop);
    }

    public StockLaptop saveStockLaptop(StockLaptop stockLaptop)
    throws Exception {
        Laptop laptop=this.findLaptopById(stockLaptop.getLaptop().getIdLaptop());
        stockLaptop.setPrixAchat(laptop.getPrixAchat());
        stockLaptop.setPrixVente(laptop.getPrixVente());
        if(stockLaptop.getQuantiteLaptopEntrant()==0||stockLaptop.getQuantiteLaptopSortant()!=0) {
            throw new Exception("Vous ne pouvez faire qu'un ajout de stock uniquement");
        }
        return stockLaptopRepository.save(stockLaptop);
    }

    public StockLaptop sortieStockLaptop(StockLaptop stockLaptop)
    throws Exception {
        Laptop laptop=this.findLaptopById(stockLaptop.getLaptop().getIdLaptop());
        stockLaptop.setPrixAchat(laptop.getPrixAchat());
        stockLaptop.setPrixVente(laptop.getPrixVente());
        if(stockLaptop.getQuantiteLaptopEntrant()!=0||stockLaptop.getQuantiteLaptopSortant()==0) {
            throw new Exception("Vous ne pouvez faire qu'une sortie de stock uniquement");
        }
        return stockLaptopRepository.save(stockLaptop);
    }

    public StockPointVente sortieStockLaptopPointVente(StockPointVente stockPointVente)
    throws Exception {
        Laptop laptop=this.findLaptopById(stockPointVente.getLaptop().getIdLaptop());
        stockPointVente.setPrixAchat(laptop.getPrixAchat());
        stockPointVente.setPrixVente(laptop.getPrixVente());
        if(stockPointVente.getQuantiteLaptopEntrant()!=0||stockPointVente.getQuantiteLaptopSortant()==0) {
            throw new Exception("Vous ne pouvez faire qu'une sortie de stock uniquement");
        }
        return stockPointVenteRepository.save(stockPointVente);
    }

    public TransfertLaptop transfererStockPointVente(TransfertLaptop transfertLaptop) throws Exception {
        Laptop laptop=this.findLaptopById(transfertLaptop.getLaptop().getIdLaptop());
        if(transfertLaptop.getQuantiteLaptop()>laptop.getResteStockMagasin(null, transfertLaptop.getDateTransfertLaptop())) {
            System.out.println(transfertLaptop.getQuantiteLaptop());
            System.out.println(laptop.getResteStockMagasin(null, transfertLaptop.getDateTransfertLaptop()));
            throw new Exception("Vous n'avez pas assez de "+laptop.getModel()+" en stock");
        }
        StockLaptop stockLaptop=new StockLaptop(laptop, 0, transfertLaptop.getQuantiteLaptop(), transfertLaptop.getDateTransfertLaptop(), laptop.getPrixAchat(), laptop.getPrixVente());
        this.sortieStockLaptop(stockLaptop);
        return transfertLaptopRepository.save(transfertLaptop);
    }

    public RenvoieLaptop renvoieLaptop(RenvoieLaptop renvoieLaptop) throws Exception {
        Laptop laptop=this.findLaptopById(renvoieLaptop.getLaptop().getIdLaptop());
        if(renvoieLaptop.getQuantiteLaptop()>laptopRepository.getResteStockPointVente(laptop, renvoieLaptop.getDateRenvoieLaptop())) {
            throw new Exception("Vous n'avez pas assez de "+laptop.getModel()+" en stock");
        }
        StockPointVente stockPointVente=new StockPointVente(renvoieLaptop.getPointVente(), laptop, 0, renvoieLaptop.getQuantiteLaptop(), renvoieLaptop.getDateRenvoieLaptop());
        this.sortieStockLaptopPointVente(stockPointVente);
        return renvoieLaptopRepository.save(renvoieLaptop);
    }

    public TransfertLaptop saveTransfertLaptop(TransfertLaptop transfertLaptop) {
        return transfertLaptopRepository.save(transfertLaptop);
    }

    public RenvoieLaptop saveRenvoieLaptop(RenvoieLaptop renvoieLaptop) {
        return renvoieLaptopRepository.save(renvoieLaptop);
    }

    public List<TransfertLaptop> getListeTransfertOfPointVente(PointVente pointVente) {
        return transfertLaptopRepository.findByPointVente(pointVente);
    }

    public ReceptionLaptop receptionPointVente(ReceptionLaptop receptionLaptop, String token)
    throws Exception {
        StockPointVente stockPointVente=new StockPointVente(receptionLaptop.getTransfertLaptop().getPointVente(), receptionLaptop.getTransfertLaptop().getLaptop(),
        receptionLaptop.getQuantiteRecu(), receptionLaptop.getDateReception());
        Laptop laptop=stockPointVente.getLaptop();
        stockPointVente.setPrixAchat(laptop.getPrixAchat());
        stockPointVente.setPrixVente(laptop.getPrixVente());
        User user=pdvService.findUSerConnected(token);
        PointVenteUser pointVenteUser=pdvService.findPointVenteUserByUser(user);
        if(receptionLaptop.getTransfertLaptop().getPointVente().getIdPointVente()!=pointVenteUser.getPointVente().getIdPointVente()) {
            throw new Exception("Ce transfert de laptop ne vous est pas destinee");
        }
        if(receptionLaptop.getQuantiteRecu()>receptionLaptop.getTransfertLaptop().getQuantiteLaptop()) {
            throw new Exception("Vous avez recu trop de laptop");
        }
        receptionLaptop.getTransfertLaptop().setEtatTransfertLaptop(11);
        this.saveTransfertLaptop(receptionLaptop.getTransfertLaptop());
        stockPointVenteRepository.save(stockPointVente);
        return receptionLaptopRepository.save(receptionLaptop);
    }

    public ReceptionRenvoieLaptop receptionRenvoiePointVente(ReceptionRenvoieLaptop receptionRenvoieLaptop, String token)
    throws Exception {
        StockLaptop stockLaptop=new StockLaptop(receptionRenvoieLaptop.getRenvoieLaptop().getLaptop(), receptionRenvoieLaptop.getQuantiteRecu(), 0, receptionRenvoieLaptop.getDateReception());
        if(receptionRenvoieLaptop.getQuantiteRecu()>receptionRenvoieLaptop.getRenvoieLaptop().getQuantiteLaptop()) {
            throw new Exception("Vous avez recu trop de laptop");
        }
        receptionRenvoieLaptop.getRenvoieLaptop().setEtatRenvoieLaptop(11);
        this.saveRenvoieLaptop(receptionRenvoieLaptop.getRenvoieLaptop());
        stockLaptopRepository.save(stockLaptop);
        return receptionRenvoieLaptopRepository.save(receptionRenvoieLaptop);
    }

    public TransfertLaptop findTransfertLaptopById(int idTransfertLaptop) {
        return transfertLaptopRepository.findById(idTransfertLaptop).get();
    }

    public RenvoieLaptop findRenvoieLaptopById(int idRenvoieLaptop) {
        return renvoieLaptopRepository.findById(idRenvoieLaptop).get();
    }

    public ReceptionLaptop findReceptionLaptopById(int idReceptionLaptop) {
        return laptopRepository.findReceptionLaptopByIdReceptionLaptop(idReceptionLaptop).get();
    }

    public List<ResteStockLaptop> getResteStockLaptopByLaptop() {
        return laptopRepository.findResteStockByLaptop();
    }

    public int countNbPagesMarque() {
        return laptopRepository.getNbPagesOfMarque();
    }

    public int countNbPagesLaptop() {
        return laptopRepository.getNbPagesOfLaptop();
    }

    public int countNbPagesDisque() {
        return laptopRepository.getNbPagesOfDisque();
    }

    public int countNbPagesTypeDisque() {
        return laptopRepository.getNbPagesOfTypeDisque();
    }

    public int countNbPagesTypeDisque(String nomTypeDisque) {
        return laptopRepository.getNbPagesOfTypeDisque(nomTypeDisque);
    }

    public int countNbPagesMarqueRecherche(String nomMarque) {
        return laptopRepository.getNbPagesOfMarqueRecherche(nomMarque);
    }

    public int countNbPagesTypeRamRecherche(String nomTypeRam) {
        return laptopRepository.getNbPagesOfTypeRamRecherche(nomTypeRam);
    }

    public int countNbPagesProcesseur() {
        return laptopRepository.getNbPagesOfProcesseur();
    }

    public int countNbPagesRam() {
        return laptopRepository.getNbPagesOfRam();
    }

    public int countNbPagesTypeRam() {
        return laptopRepository.getNbPagesOfTypeRam();
    }

    public List<Marque> findMarqueByName(String nomMarque, int numPage) {
        return laptopRepository.findMarqueByName(nomMarque, numPage);
    }

    public List<TypeRam> findTypeRamByName(String nomTypeRam, int numPage) {
        return laptopRepository.findTypeRamByName(nomTypeRam, numPage);
    }

    public List<TypeDisque> findTypeDisqueByName(String nomTypeDisque, int numPage) {
        return laptopRepository.findTypeDisqueByName(nomTypeDisque, numPage);
    }

    public List<TransfertLaptop> getAllTransfertLaptop() {
        return transfertLaptopRepository.findAll();
    }

    public List<RenvoieLaptop> getAllRenvoieLaptop() {
        return renvoieLaptopRepository.findAll();
    }

    public void vendreLaptop(VenteLaptop venteLaptop)
    throws Exception {
        venteLaptop.setLaptop(this.findLaptopById(venteLaptop.getLaptop().getIdLaptop()));
        if(venteLaptop.getQuantiteLaptop()>laptopRepository.getResteStockPointVente(venteLaptop.getLaptop(), venteLaptop.getDateVenteLaptop())) {
            throw new Exception("Vous n'avez pas assez de "+venteLaptop.getLaptop().getModel()+" en stock");
        }
        stockPointVenteRepository.save(new StockPointVente(venteLaptop.getPointVente(), venteLaptop.getLaptop(), 0, venteLaptop.getQuantiteLaptop(), venteLaptop.getDateVenteLaptop()));
        laptopRepository.saveVenteLaptop(venteLaptop);
    }

    public List<StatVenteTotalMois> getStatVenteTotalMois(int annee) {
        return laptopRepository.getStatistiqueVenteTotalMois(annee);
    }
}
