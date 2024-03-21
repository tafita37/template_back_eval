package eval.mikolo.mikolo.model.laptop.transfert;

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
@Table(name = "reception_laptop")
public class ReceptionLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reception_laptop", nullable = false)
    int idReceptionLaptop;
    @ManyToOne
    @JoinColumn(name = "id_transfert_laptop", nullable = false)
    TransfertLaptop transfertLaptop;
    @Column(name = "quantite_recu", nullable = false)
    int quantiteRecu;
    @Column(name = "date_reception", nullable = false)
    Date dateReception;
    public int getIdReceptionLaptop() {
        return idReceptionLaptop;
    }
    public void setIdReceptionLaptop(int idReceptionLaptop)
    throws Exception {
        if(idReceptionLaptop<=0) {
            throw new Exception("Veuillez entrer un numero de reception de laptop valide");
        }
        this.idReceptionLaptop = idReceptionLaptop;
    }
    public TransfertLaptop getTransfertLaptop() {
        return transfertLaptop;
    }
    public void setTransfertLaptop(TransfertLaptop transfertLaptop)
    throws Exception {
        if(transfertLaptop==null) {
            throw new Exception("Veuillez entrer un transfert de laptop");
        }
        this.transfertLaptop = transfertLaptop;
    }
    public int getQuantiteRecu() {
        return quantiteRecu;
    }
    public void setQuantiteRecu(int quantiteRecu)
    throws Exception {
        if(quantiteRecu<=0) {
            throw new Exception("Veuillez entrer une quantite recu plus grande");
        }
        this.quantiteRecu = quantiteRecu;
    }
    public Date getDateReception() {
        return dateReception;
    }
    public void setDateReception(Date dateReception)
    throws Exception {
        if(dateReception==null) {
            throw new Exception("Veuillez entrer une date de reception");
        }
        this.dateReception = dateReception;
    }
}
