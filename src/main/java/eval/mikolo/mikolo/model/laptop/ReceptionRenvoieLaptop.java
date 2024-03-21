package eval.mikolo.mikolo.model.laptop;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reception_renvoie_laptop")
public class ReceptionRenvoieLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reception_renvoie_laptop", nullable = false)
    int idReceptionRenvoieLaptop;
    @ManyToOne
    @JoinColumn(name = "id_renvoie_laptop", nullable = false)
    RenvoieLaptop renvoieLaptop;
    @Column(name = "quantite_recu", nullable = false)
    int quantiteRecu;
    @Column(name = "date_reception", nullable = false)
    Date dateReception;
    public int getIdReceptionRenvoieLaptop() {
        return idReceptionRenvoieLaptop;
    }
    public void setIdReceptionRenvoieLaptop(int idReceptionRenvoieLaptop)
    throws Exception {
        if(idReceptionRenvoieLaptop<=0) {
            throw new Exception("Veuillez entrer un id de reception de laptop valide");
        }
        this.idReceptionRenvoieLaptop = idReceptionRenvoieLaptop;
    }
    public RenvoieLaptop getRenvoieLaptop() {
        return renvoieLaptop;
    }
    public void setRenvoieLaptop(RenvoieLaptop renvoieLaptop)
    throws Exception {
        if(renvoieLaptop==null) {
            throw new Exception("Veuillez entrer un laptop");
        }
        this.renvoieLaptop = renvoieLaptop;
    }
    public int getQuantiteRecu() {
        return quantiteRecu;
    }
    public void setQuantiteRecu(int quantiteRecu)
    throws Exception {
        if(quantiteRecu<=0) {
            throw new Exception("Veuillez entrer une quantite plus grande");
        }
        this.quantiteRecu = quantiteRecu;
    }
    public Date getDateReception() {
        return dateReception;
    }
    public void setDateReception(Date dateReception)
    throws Exception {
        if(dateReception==null) {
            throw new Exception("Veuillez entrer une date de reception de renvoie");
        }
        this.dateReception = dateReception;
    }
}
