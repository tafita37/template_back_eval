package eval.mikolo.mikolo.repository.laptop;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import eval.mikolo.mikolo.model.laptop.Laptop;
import eval.mikolo.mikolo.model.laptop.disque.Disque;
import eval.mikolo.mikolo.model.laptop.disque.TypeDisque;
import eval.mikolo.mikolo.model.laptop.marque.Marque;
import eval.mikolo.mikolo.model.laptop.processeur.Processeur;
import eval.mikolo.mikolo.model.laptop.ram.Ram;
import eval.mikolo.mikolo.model.laptop.ram.TypeRam;
import eval.mikolo.mikolo.model.laptop.stat.StatVenteTotalMois;
import eval.mikolo.mikolo.model.laptop.stock.ResteStockLaptop;
import eval.mikolo.mikolo.model.laptop.transfert.ReceptionLaptop;
import eval.mikolo.mikolo.model.laptop.vente.VenteLaptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class LaptopRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void saveLaptop(Laptop laptop) {
        if (laptop.getIdLaptop() != 0) {
            entityManager.merge(laptop);
        } else {
            entityManager.persist(laptop);
        }
    }

    public List<Laptop> findAllLaptop() {
        String requete="select*from laptop";
        Query query=entityManager.createNativeQuery(requete, Laptop.class);
        return query.getResultList();
    }

    public List<Laptop> findAllLaptop(int numPage) {
        String requete="select*from laptop limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Laptop.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public Optional<Laptop> findLaptopByIdLaptop(int idLaptop) {
        try {
            Laptop ram =  entityManager.find(Laptop.class, idLaptop);
            return Optional.ofNullable(ram);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional 
    public void deleteLaptopByIdLaptop(int idLaptop) {
        Laptop laptop=this.findLaptopByIdLaptop(idLaptop).get();
        entityManager.remove(laptop);
    }

    public int getNbPagesOfLaptop() {
        String sql="select*from v_nb_pages_disque";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    public int getResteStockPointVente(Laptop laptop, Date date) {
        String sql="select sum(reste_stock) as reste_stock from v_etat_stock_point_vente where id_laptop=:idLaptop and coalesce(date_mouvement, :dateMouvement)<=:dateMouvement";
        Query query=entityManager.createNativeQuery(sql);
        query.setParameter("idLaptop", laptop.getIdLaptop());
        query.setParameter("dateMouvement", date);
        int result=((Number) query.getSingleResult()).intValue();
        return result;
    }

    public List<Disque> findAllDisque(int numPage) {
        String requete="select*from disque limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Disque.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public List<StatVenteTotalMois> getStatistiqueVenteTotalMois(int annee) {
        String sql="select*from v_stat_vente_total_mois where annee=:annee";
        Query query=entityManager.createNativeQuery(sql, StatVenteTotalMois.class);
        query.setParameter("annee", annee);
        return query.getResultList();
    }

    public List<Disque> findAllDisque() {
        String requete="select*from disque";
        Query query=entityManager.createNativeQuery(requete, Disque.class);
        return query.getResultList();
    }

    @Transactional
    public void saveDisque(Disque disque) {
        if (disque.getIdDisque() != 0) {
            entityManager.merge(disque);
        } else {
            entityManager.persist(disque);
        }
    }

    @Transactional
    public void saveVenteLaptop(VenteLaptop venteLaptop) {
        if (venteLaptop.getIdVenteLaptop() != 0) {
            entityManager.merge(venteLaptop);
        } else {
            entityManager.persist(venteLaptop);
        }
    }

    public Optional<Disque> findDisqueByIdDisque(int idDisque) {
        try {
            Disque ram =  entityManager.find(Disque.class, idDisque);
            return Optional.ofNullable(ram);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional 
    public void deleteDisqueByIdDisque(int idDisque) {
        Disque disque=this.findDisqueByIdDisque(idDisque).get();
        entityManager.remove(disque);
    }

    public int getNbPagesOfDisque() {
        String sql="select*from v_nb_pages_disque";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    @Transactional
    public void saveTypeDisque(TypeDisque typeDisque) {
        if (typeDisque.getIdTypeDisque() != 0) {
            entityManager.merge(typeDisque);
        } else {
            entityManager.persist(typeDisque);
        }
    }

    public List<TypeDisque> findAllTypeDisque(int numPage) {
        String requete="select*from type_disque limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, TypeDisque.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public List<TypeDisque> findAllTypeDisque() {
        String requete="select*from type_disque";
        Query query=entityManager.createNativeQuery(requete, TypeDisque.class);
        return query.getResultList();
    }

    public int getNbPagesOfTypeDisque() {
        String sql="select*from v_nb_pages_type_disque";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    public int getNbPagesOfTypeDisque(String nomTypeDisque) {
        String sql="select ceil(( select cast(count(*) as decimal)/5 from type_disque where nom_type_disque like :nomTypeDisque )) as nb_page_type_disque;";
        Query query=entityManager.createNativeQuery(sql);
        query.setParameter("nomTypeDisque", "%"+nomTypeDisque+"%");
        return ((Number) query.getSingleResult()).intValue();
    }

    public List<TypeDisque> findTypeDisqueByName(String nomTypeDisque, int numPage) {
        String requete="select*from type_disque where nom_type_disque like :nomTypeDisque limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, TypeDisque.class);
        query.setParameter("nomTypeDisque", "%"+nomTypeDisque+"%");
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public Optional<TypeDisque> findTypeDisqueByIdTypeDisque(int idTypeDisque) {
        try {
            TypeDisque typeDisque =  entityManager.find(TypeDisque.class, idTypeDisque);
            return Optional.ofNullable(typeDisque);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteTypeDisqueByIdTypeDisque(int idTypeDisque) {
        TypeDisque typeDisque=this.findTypeDisqueByIdTypeDisque(idTypeDisque).get();
        entityManager.remove(typeDisque);
    }

    public List<Marque> findAllMarque() {
        String requete="select*from marque";
        Query query=entityManager.createNativeQuery(requete, Marque.class);
        return query.getResultList();
    }

    public List<Marque> findAllMarque(int numPage) {
        String requete="select*from marque limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Marque.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public List<Marque> findMarqueByName(String nomMarque, int numPage) {
        String requete="select*from marque where nom_marque like :nomMarque limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Marque.class);
        query.setParameter("nomMarque", "%"+nomMarque+"%");
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public int getNbPagesOfMarque() {
        String sql="select*from v_nb_pages_marque";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    public int getNbPagesOfMarqueRecherche(String nomMarque) {
        String sql="select ceil(( select cast(count(*) as decimal)/5 from marque where nom_marque like :nomMarque )) as nbPageMarque;";
        Query query=entityManager.createNativeQuery(sql);
        query.setParameter("nomMarque", "%"+nomMarque+"%");
        return ((Number) query.getSingleResult()).intValue();
    }

    @Transactional
    public void saveMarque(Marque marque) {
        if (marque.getIdMarque() != 0) {
            entityManager.merge(marque);
        } else {
            entityManager.persist(marque);
        }
    }

    public Optional<Marque> findMarqueByIdMarque(int idMarque) {
        try {
            Marque marque =  entityManager.find(Marque.class, idMarque);
            return Optional.ofNullable(marque);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteMarqueByIdMarque(int idMarque) {
        Marque marque=this.findMarqueByIdMarque(idMarque).get();
        entityManager.remove(marque);
    }

    public List<Processeur> findAllProcesseur(int numPage) {
        String requete="select*from processeur limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Processeur.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public List<Processeur> findAllProcesseur() {
        String requete="select*from processeur";
        Query query=entityManager.createNativeQuery(requete, Processeur.class);
        return query.getResultList();
    }

    @Transactional
    public void saveProcesseur(Processeur processeur) {
        if (processeur.getIdProcesseur() != 0) {
            entityManager.merge(processeur);
        } else {
            entityManager.persist(processeur);
        }
    }

    public Optional<Processeur> findProcesseurByIdProcesseur(int idProcesseur) {
        try {
            Processeur processeur =  entityManager.find(Processeur.class, idProcesseur);
            return Optional.ofNullable(processeur);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteProcesseurByIdProcesseur(int idProcesseur) {
        Processeur processeur=this.findProcesseurByIdProcesseur(idProcesseur).get();
        entityManager.remove(processeur);
    }

    public int getNbPagesOfProcesseur() {
        String sql="select*from v_nb_pages_processeur";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    @Transactional
    public void saveRam(Ram ram) {
        if (ram.getIdRam() != 0) {
            entityManager.merge(ram);
        } else {
            entityManager.persist(ram);
        }
    }

    public List<Ram> findAllRam() {
        String requete="select*from ram";
        Query query=entityManager.createNativeQuery(requete, Ram.class);
        return query.getResultList();
    }

    public List<Ram> findAllRam(int numPage) {
        String requete="select*from ram limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, Ram.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public Optional<Ram> findRamByIdRam(int idRam) {
        try {
            Ram ram =  entityManager.find(Ram.class, idRam);
            return Optional.ofNullable(ram);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional 
    public void deleteRamByIdRam(int idRam) {
        Ram ram=this.findRamByIdRam(idRam).get();
        entityManager.remove(ram);
    }

    public int getNbPagesOfRam() {
        String sql="select*from v_nb_pages_ram";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    @Transactional
    public void save(TypeRam typeRam) {
        if (typeRam.getIdTypeRam() != 0) {
            entityManager.merge(typeRam);
        } else {
            entityManager.persist(typeRam);
        }
    }

    public List<TypeRam> findAllTypeRam(int numPage) {
        String requete="select*from type_ram limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, TypeRam.class);
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public List<TypeRam> findAllTypeRam() {
        String requete="select*from type_ram";
        Query query=entityManager.createNativeQuery(requete, TypeRam.class);
        return query.getResultList();
    }

    public int getNbPagesOfTypeRam() {
        String sql="select*from v_nb_pages_type_ram";
        Query query=entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).intValue();
    }

    public List<TypeRam> findTypeRamByName(String nomTypeRam, int numPage) {
        String requete="select*from type_ram where nom_type_ram like :nomTypeRam limit 5 offset :debut";
        Query query=entityManager.createNativeQuery(requete, TypeRam.class);
        query.setParameter("nomTypeRam", "%"+nomTypeRam+"%");
        query.setParameter("debut", (numPage-1)*5);
        return query.getResultList();
    }

    public int getNbPagesOfTypeRamRecherche(String nomTypeRam) {
        String sql="select ceil(( select cast(count(*) as decimal)/5 from type_ram where nom_type_ram like :nomTypeRam )) as nbPageTypeRam;";
        Query query=entityManager.createNativeQuery(sql);
        query.setParameter("nomTypeRam", "%"+nomTypeRam+"%");
        return ((Number) query.getSingleResult()).intValue();
    }

    public Optional<TypeRam> findTypeRamByIdTypeRam(int idTypeRam) {
        try {
            TypeRam typeRam =  entityManager.find(TypeRam.class, idTypeRam);
            return Optional.ofNullable(typeRam);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<ReceptionLaptop> findReceptionLaptopByIdReceptionLaptop(int idReceptionLaptop) {
        try {
            ReceptionLaptop receptionLaptop =  entityManager.find(ReceptionLaptop.class, idReceptionLaptop);
            return Optional.ofNullable(receptionLaptop);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteTypeRamByIdTypeRam(int idTypeRam) {
        TypeRam typeRam=this.findTypeRamByIdTypeRam(idTypeRam).get();
        entityManager.remove(typeRam);
    }

    public List<ResteStockLaptop> findResteStockByLaptop() {
        String requete="select*from v_reste_stock_magasin";
        List<ResteStockLaptop> result=entityManager.createNativeQuery(requete, ResteStockLaptop.class).getResultList();
        return result;
    }
}
