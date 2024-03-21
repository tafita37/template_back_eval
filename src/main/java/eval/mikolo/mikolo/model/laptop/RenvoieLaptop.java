package eval.mikolo.mikolo.model.laptop;

import java.sql.Date;
import eval.mikolo.mikolo.model.pdv.PointVente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "renvoie_laptop")
public class RenvoieLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_renvoie_laptop", nullable = false)
    int idRenvoieLaptop;
    @ManyToOne
    @JoinColumn(name = "id_laptop", nullable = false)
    Laptop laptop;
    @ManyToOne
    @JoinColumn(name = "id_point_vente", nullable = false)
    PointVente pointVente;
    @Column(name = "quantite_laptop", nullable = false)
    int quantiteLaptop;
    @Column(name = "date_renvoie_laptop", nullable = false)
    Date dateRenvoieLaptop;
    @Column(name = "etat_renvoie_laptop", nullable = false)
    int etatRenvoieLaptop;
    public int getIdRenvoieLaptop() {
        return idRenvoieLaptop;
    }
    public void setIdRenvoieLaptop(int idRenvoieLaptop)
    throws Exception {
        if(idRenvoieLaptop<=0) {
            throw new Exception("Veuillez entrer un id de renvoie de laptop");
        }
        this.idRenvoieLaptop = idRenvoieLaptop;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop)
    throws Exception {
        if(laptop==null) {
            throw new Exception("Veuillez entrer un laptop");
        }
        this.laptop = laptop;
    }
    public PointVente getPointVente() {
        return pointVente;
    }
    public void setPointVente(PointVente pointVente)
    throws Exception {
        if(pointVente==null) {
            throw new Exception("Veuillez entrer un point de vente");
        }
        this.pointVente = pointVente;
    }
    public Date getDateRenvoieLaptop() {
        return dateRenvoieLaptop;
    }
    public void setDateRenvoieLaptop(Date dateRenvoieLaptop)
    throws Exception {
        if(dateRenvoieLaptop==null) {
            throw new Exception("Veuillez entrer une date de renvoie de laptop");
        }
        this.dateRenvoieLaptop = dateRenvoieLaptop;
    }
    public int getQuantiteLaptop() {
        return quantiteLaptop;
    }
    public void setQuantiteLaptop(int quantiteLaptop)
    throws Exception {
        if(quantiteLaptop<=0) {
            throw new Exception("Veuillez entrer une quantite de laptop plus grande");
        }
        this.quantiteLaptop = quantiteLaptop;
    }
    public int getEtatRenvoieLaptop() {
        return etatRenvoieLaptop;
    }
    public void setEtatRenvoieLaptop(int etatRenvoieLaptop)
    throws Exception {
        if(etatRenvoieLaptop<=0) {
            throw new Exception("Veuillez entrer un etat de renvoie de laptop valide");
        }
        this.etatRenvoieLaptop = etatRenvoieLaptop;
    }
}
