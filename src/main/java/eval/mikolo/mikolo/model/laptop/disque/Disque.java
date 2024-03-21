package eval.mikolo.mikolo.model.laptop.disque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "disque")
public class Disque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disque", nullable = false)
    int idDisque;
    @Column(name = "capacite", nullable = false)
    double capacite;
    @Column(name = "vitesse", nullable = false)
    double vitesse;
    @ManyToOne
    @JoinColumn(name = "id_type_disque", nullable = false)
    TypeDisque typeDisque;
    public Disque(int idDisque, double capacite, double vitesse, TypeDisque typeDisque)
    throws Exception {
        this.setIdDisque(idDisque);
        this.setCapacite(capacite);
        this.setVitesse(vitesse);
        this.setTypeDisque(typeDisque);
    }
    public Disque() {
    }
    public int getIdDisque() {
        return idDisque;
    }
    public void setIdDisque(int idDisque)
    throws Exception {
        if(idDisque<=0) {
            throw new Exception("Veuillez entrer un id de disque correct");
        }
        this.idDisque = idDisque;
    }
    public double getCapacite() {
        return capacite;
    }
    public void setCapacite(double capacite)
    throws Exception {
        if(capacite<=0) {
            throw new Exception("Veuillez entrer une capacite de disque dur plus grande");
        }
        this.capacite = capacite;
    }
    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse)
    throws Exception {
        if(vitesse<=0) {
            throw new Exception("Veuillez entrer une vitesse de disque dur plus grande");
        }
        this.vitesse = vitesse;
    }
    public TypeDisque getTypeDisque() {
        return typeDisque;
    }
    public void setTypeDisque(TypeDisque typeDisque)
    throws Exception {
        if(typeDisque==null) {
            throw new Exception("Veuillez entrer un type de disque");
        }
        this.typeDisque = typeDisque;
    }
}
