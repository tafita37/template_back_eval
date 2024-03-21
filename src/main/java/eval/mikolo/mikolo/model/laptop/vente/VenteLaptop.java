package eval.mikolo.mikolo.model.laptop.vente;

import java.sql.Date;
import eval.mikolo.mikolo.model.laptop.Laptop;
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
@Table(name = "vente_laptop")
public class VenteLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vente_laptop", nullable = false)
    int idVenteLaptop;
    @ManyToOne
    @JoinColumn(name = "id_laptop", nullable = false)
    Laptop laptop;
    @ManyToOne
    @JoinColumn(name = "id_point_vente", nullable = false)
    PointVente pointVente;
    @JoinColumn(name = "date_vente_laptop", nullable = false)
    Date dateVenteLaptop;
    @JoinColumn(name = "quantite_laptop", nullable = false)
    int quantiteLaptop;
    @JoinColumn(name = "prix_vente", nullable = false)
    double prixVente;
    public int getIdVenteLaptop() {
        return idVenteLaptop;
    }
    public void setIdVenteLaptop(int idVenteLaptop)
    throws Exception {
        if(idVenteLaptop<=0) {
            throw new Exception("Veuillez entrer un id de laptop valide");
        }
        this.idVenteLaptop = idVenteLaptop;
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
    public Date getDateVenteLaptop() {
        return dateVenteLaptop;
    }
    public void setDateVenteLaptop(Date dateVenteLaptop)
    throws Exception {
        if(dateVenteLaptop==null) {
            throw new Exception("Veuillez entrer une date de vente de laptop");
        }
        this.dateVenteLaptop = dateVenteLaptop;
    }
    public int getQuantiteLaptop() {
        return quantiteLaptop;
    }
    public void setQuantiteLaptop(int quantiteLaptop)
    throws Exception {
        if(quantiteLaptop<=0) {
            throw new Exception("Veuillez entrer un quantite de laptop plus grande");
        }
        this.quantiteLaptop = quantiteLaptop;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente)
    throws Exception {
        if(prixVente<=0) {
            throw new Exception("Veuillez entrer un prix de vente plus grand");
        }
        this.prixVente = prixVente;
    }
}
