package eval.mikolo.mikolo.model.laptop.stock;

import java.sql.Date;
import eval.mikolo.mikolo.model.laptop.Laptop;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_laptop_magasin")
public class StockLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock_laptop_magasin", nullable = false)
    int idStockLaptop;
    @ManyToOne
    @JoinColumn(name = "id_laptop", nullable = false)
    Laptop laptop;
    @Column(name = "quantite_laptop_entrant", nullable = false)
    double quantiteLaptopEntrant;
    @Column(name = "quantite_laptop_sortant", nullable = false)
    double quantiteLaptopSortant;
    @Column(name = "date_mouvement", nullable = false)
    Date dateMouvement;
    @Column(name = "prix_achat", nullable = false)
    double prixAchat;
    @Column(name = "prix_vente", nullable = false)
    double prixVente;
    
    public StockLaptop(Laptop laptop, double quantiteLaptopEntrant, double quantiteLaptopSortant, Date dateMouvement,double prixAchat, double prixVente)
    throws Exception {
        this.setLaptop(laptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setQuantiteLaptopSortant(quantiteLaptopSortant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(prixAchat);
        this.setPrixVente(prixVente);
    }
    
    public StockLaptop(Laptop laptop, double quantiteLaptopEntrant, double quantiteLaptopSortant, Date dateMouvement)
    throws Exception {
        this.setLaptop(laptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setQuantiteLaptopSortant(quantiteLaptopSortant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(laptop.getPrixAchat());
        this.setPrixVente(laptop.getPrixVente());
    }
    public StockLaptop(int idStockLaptop, Laptop laptop, double quantiteLaptopEntrant, double quantiteLaptopSortant, Date dateMouvement, double prixAchat, double prixVente)
    throws Exception {
        this.setIdStockLaptop(idStockLaptop);
        this.setQuantiteLaptopEntrant(quantiteLaptopEntrant);
        this.setQuantiteLaptopSortant(quantiteLaptopSortant);
        this.setDateMouvement(dateMouvement);
        this.setPrixAchat(prixAchat);
        this.setPrixVente(prixVente);
    }
    public StockLaptop() {
    }
    public int getIdStockLaptop() {
        return idStockLaptop;
    }
    public void setIdStockLaptop(int idStockLaptop)
    throws Exception {
        if(idStockLaptop<=0) {
            throw new Exception("Veuillez entrer un id de stock de laptop valide");
        }
        this.idStockLaptop = idStockLaptop;
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
            throw new Exception("Veuillez entrer une date de mouvement");
        }
        this.dateMouvement = dateMouvement;
    }
    public double getQuantiteLaptopEntrant() {
        return quantiteLaptopEntrant;
    }
    public void setQuantiteLaptopEntrant(double quantiteLaptopEntrant)
    throws Exception {
        if(quantiteLaptopEntrant<0) {
            throw new Exception("Quantite entrante negative");
        }
        this.quantiteLaptopEntrant = quantiteLaptopEntrant;
    }
    public double getQuantiteLaptopSortant() {
        return quantiteLaptopSortant;
    }
    public void setQuantiteLaptopSortant(double quantiteLaptopSortant)
    throws Exception {
        if(quantiteLaptopSortant<0) {
            throw new Exception("Quantite sortante negative");
        }
        this.quantiteLaptopSortant = quantiteLaptopSortant;
    }
    public double getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
}
