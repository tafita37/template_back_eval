package eval.mikolo.mikolo.model.laptop.ram;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ram")
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ram", nullable = false)
    int idRam;
    @Column(name = "capacite", nullable = false)
    double capacite;
    @Column(name = "frequence", nullable = false)
    double frequence;
    @ManyToOne
    @JoinColumn(name = "id_type_ram", nullable = false)
    TypeRam typeRam;
    public Ram(int idRam, double capacite, double frequence, TypeRam typeRam)
    throws Exception {
        this.setIdRam(idRam);
        this.setCapacite(capacite);
        this.setFrequence(frequence);
        this.setTypeRam(typeRam);
    }
    public Ram() {
    }
    public int getIdRam() {
        return idRam;
    }
    public void setIdRam(int idRam)
    throws Exception {
        if(idRam<=0) {
            throw new Exception("Veuillez entrer un id de ram valide");
        }
        this.idRam = idRam;
    }
    public double getCapacite() {
        return capacite;
    }
    public void setCapacite(double capacite)
    throws Exception {
        if(capacite<=0) {
            throw new Exception("Veuillez entrer une capacite de ram plus grande");
        }
        this.capacite = capacite;
    }
    public double getFrequence() {
        return frequence;
    }
    public void setFrequence(double frequence)
    throws Exception {
        if(frequence<=0) {
            throw new Exception("Veuillez entrer une frequence de ram plus grande");
        }
        this.frequence = frequence;
    }
    public TypeRam getTypeRam() {
        return typeRam;
    }
    public void setTypeRam(TypeRam typeRam)
    throws Exception {
        if(typeRam==null) {
            throw new Exception("Veuillez entrer le type de ram correspondant");
        }
        this.typeRam = typeRam;
    }
}
