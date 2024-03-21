package eval.mikolo.mikolo.model.laptop.stock.pdv;

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
@Table(name = "stock_point_vente")
public class StockPointVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock_point_vente", nullable = false)
    int idStockPointVente;
    @ManyToOne
    @JoinColumn(name = "id_point_vente", nullable = false)
    PointVente pointVente;
    @ManyToOne
    @JoinColumn(name = "id_laptop", nullable = false)
    Laptop laptop;
    @Column(name = "quantite_laptop_entrant", nullable = false)
    int quantiteLaptopEntrant;
    @Column(name = "quantite_laptop_sortant", nullable = false)
    int quantiteLaptopSortant;
    @Column(name = "date_mouvement", nullable = false)
    Date dateMouvement;
    @Column(name = "prix_achat", nullable = false)
    double prixAchat;
    @Column(name = "prix_vente", nullable = false)
    double prixVente;
    
    public StockPointVente(PointVente pointVente, Laptop laptop, int quantiteLaptopEntrant, int quantiteLaptopSortant, Date dateMouvement)
    throws Exception {
        this.setPointVente(pointVente);
        this.setLaptop(laptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setQuantiteLaptopSortant(quantiteLaptopSortant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(laptop.getPrixAchat());
        this.setPrixVente(laptop.getPrixVente());
    }
    public StockPointVente(PointVente pointVente, Laptop laptop, int quantiteLaptopEntrant, Date dateMouvement)
    throws Exception {
        this.setPointVente(pointVente);
        this.setLaptop(laptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(laptop.getPrixAchat());
        this.setPrixVente(laptop.getPrixVente());
    }
    public StockPointVente(int idStockPointVente, PointVente pointVente, Laptop laptop, int quantiteLaptopEntrant, int quantiteLaptopSortant, Date dateMouvement, double prixAchat, double prixVente)
    throws Exception {
        this.setIdStockPointVente(idStockPointVente);
        this.setPointVente(pointVente);
        this.setLaptop(laptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setQuantiteLaptopSortant(quantiteLaptopSortant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(prixAchat);
        this.setPrixVente(prixVente);
    }
    public StockPointVente() {
    }
    public int getIdStockPointVente() {
        return idStockPointVente;
    }
    public void setIdStockPointVente(int idStockPointVente)
    throws Exception {
        if(idStockPointVente<=0) {
            throw new Exception("Veuillez entrer un id de stock de point de vente valide");
        }
        this.idStockPointVente = idStockPointVente;
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
    public Date getDateMouvement() {
        return dateMouvement;
    }
    public void setDateMouvement(Date dateMouvement)
    throws Exception {
        if(dateMouvement==null) {
            throw new Exception("Veuillez entrer une date de mouvement de stock");
        }
        this.dateMouvement = dateMouvement;
    }
    public int getQuantiteLaptopEntrant() {
        return quantiteLaptopEntrant;
    }
    public void setQuantiteLaptopEntrant(int quantiteLaptopEntrant)
    throws Exception {
        if(quantiteLaptopEntrant<0) {
            throw new Exception("Veuillez entrer une quantite entrante plus grande");
        }
        this.quantiteLaptopEntrant = quantiteLaptopEntrant;
    }
    public int getQuantiteLaptopSortant() {
        return quantiteLaptopSortant;
    }
    public void setQuantiteLaptopSortant(int quantiteLaptopSortant)
    throws Exception {
        if(quantiteLaptopSortant<0) {
            throw new Exception("Veuillez entrer une quantite sortante plus grande");
        }
        this.quantiteLaptopSortant = quantiteLaptopSortant;
    }
    public double getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(double prixAchat)
    throws Exception {
        if(prixAchat<0) {
            throw new Exception("Prix d'achat negatif");
        }
        this.prixAchat = prixAchat;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente)
    throws Exception {
        if(prixVente<0) {
            throw new Exception("Prix de vente negatif");
        }
        this.prixVente = prixVente;
    }
}
