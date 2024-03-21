package eval.mikolo.mikolo.model.laptop.stock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import eval.mikolo.mikolo.model.database.ConnexionBdd;
import eval.mikolo.mikolo.model.laptop.disque.Disque;
import eval.mikolo.mikolo.model.laptop.marque.Marque;
import eval.mikolo.mikolo.model.laptop.processeur.Processeur;
import eval.mikolo.mikolo.model.laptop.ram.Ram;
import eval.mikolo.mikolo.model.laptop.transfert.TransfertLaptop;
import eval.mikolo.mikolo.model.pdv.PointVente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "v_reste_stock_magasin")
public class ResteStockLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laptop", nullable = false)
    int idLaptop;
    @Column(name = "model", nullable = false, unique =  true)
    String model;
    @ManyToOne
    @JoinColumn(name = "id_marque", nullable = false)
    Marque marque;
    @ManyToOne
    @JoinColumn(name = "id_processeur", nullable = false)
    Processeur processeur;
    @ManyToOne
    @JoinColumn(name = "id_ram", nullable = false)
    Ram ram;
    @Column(name = "taille_ecran", nullable = false)
    double tailleEcran;
    @ManyToOne
    @JoinColumn(name = "id_disque", nullable = false)
    Disque disque;
    @Column(name = "prix_achat", nullable = false)
    double prixAchat;
    @Column(name = "prix_vente", nullable = false)
    double prixVente;
    @Column(name = "reste_stock", nullable = false)
    int resteStock;
    public ResteStockLaptop(int idLaptop, String model, Marque marque, Processeur processeur, Ram ram, double tailleEcran, Disque disque, double prixAchat, double prixVente, int resteStock)
    throws Exception {
        this.setIdLaptop(idLaptop);
        this.setModel(model);
        this.setMarque(marque);
        this.setProcesseur(processeur);
        this.setRam(ram);
        this.setTailleEcran(tailleEcran);
        this.setDisque(disque);
        this.setPrixAchat(prixAchat);
        this.setPrixVente(prixVente);
        this.setResteStock(resteStock);
    }
    public ResteStockLaptop() {
    }
    public int getIdLaptop() {
        return idLaptop;
    }
    public void setIdLaptop(int idLaptop)
    throws Exception {
        if(idLaptop<=0) {
            throw new Exception("Veuillez entrer un id de laptop valide");
        }
        this.idLaptop = idLaptop;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model)
    throws Exception {
        if(model==null||model.length()==0) {
            throw new Exception("Veuillez entrer un model d'ordinateur");
        }
        this.model = model;
    }
    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque)
    throws Exception {
        if(marque==null) {
            throw new Exception("Veuillez entrer une marque");
        }
        this.marque = marque;
    }
    public Processeur getProcesseur() {
        return processeur;
    }
    public void setProcesseur(Processeur processeur)
    throws Exception {
        if(processeur==null) {
            throw new Exception("Veuillez entrer une processeur");
        }
        this.processeur = processeur;
    }
    public Ram getRam() {
        return ram;
    }
    public void setRam(Ram ram)
    throws Exception {
        if(ram==null) {
            throw new Exception("Veuillez entrer une ram");
        }
        this.ram = ram;
    }
    public double getTailleEcran() {
        return tailleEcran;
    }
    public void setTailleEcran(double tailleEcran)
    throws Exception {
        if(tailleEcran<=0) {
            throw new Exception("Veuillez entrer une taille d'ecran plus grande");
        }
        this.tailleEcran = tailleEcran;
    }
    public Disque getDisque() {
        return disque;
    }
    public void setDisque(Disque disque)
    throws Exception {
        if(disque==null) {
            throw new Exception("Veuillez entrer une disque");
        }
        this.disque = disque;
    }
    public double getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(double prixAchat)
    throws Exception {
        if(prixAchat<=0) {
            throw new Exception("Veuillez entrer un prix d'achat plus grand");
        }
        this.prixAchat = prixAchat;
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

    public double getResteStockMagasin(Connection con, Date dateMouvement)
    throws Exception {
        double result=0;
        boolean jAiOuvert=false;
        if(con==null) {
            jAiOuvert=true;
            con=ConnexionBdd.connexionPostgress("postgres", "AnaTaf37", "mikolo");
        }
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            String sql="select sum(reste_stock) as reste_stock from v_etat_stock_magasin where id_laptop=? and date_mouvement<=?";
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1, this.getIdLaptop());
            preparedStatement.setDate(2, dateMouvement);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                result=resultSet.getDouble("reste_stock");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(jAiOuvert) {
                con.close();
            }
        }
        return result;
    }

    public double getResteStockPointVente(Connection con, Date dateMouvement)
    throws Exception {
        double result=0;
        boolean jAiOuvert=false;
        if(con==null) {
            jAiOuvert=true;
            con=ConnexionBdd.connexionPostgress("postgres", "AnaTaf37", "mikolo");
        }
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            String sql="select reste_stock from v_reste_stock_laptop_point_vente where id_laptop=? and date_mouvement<=?";
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1, this.getIdLaptop());
            preparedStatement.setDate(2, dateMouvement);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                result=resultSet.getDouble("reste_stock");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(jAiOuvert) {
                con.close();
            }
        }
        return result;
    }
    public int getResteStock() {
        return resteStock;
    }
    public void setResteStock(int resteStock) {
        this.resteStock = resteStock;
    }
}
