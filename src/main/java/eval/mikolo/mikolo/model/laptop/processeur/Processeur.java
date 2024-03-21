package eval.mikolo.mikolo.model.laptop.processeur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "processeur")
public class Processeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_processeur", nullable = false)
    int idProcesseur;
    @Column(name = "nom_processeur", nullable = false)
    String nomProcesseur;
    @Column(name = "frequence", nullable = false)
    double frequence;
    @Column(name = "nb_coeur", nullable = false)
    double nbCoeur;
    public Processeur(int idProcesseur, String nomProcesseur, double frequence, double nbCoeur)
    throws Exception {
        this.setIdProcesseur(idProcesseur);
        this.setNomProcesseur(nomProcesseur);
        this.setFrequence(frequence);
        this.setNbCoeur(nbCoeur);
    }
    public Processeur() {
    }
    public int getIdProcesseur() {
        return idProcesseur;
    }
    public void setIdProcesseur(int idProcesseur)
    throws Exception {
        if(idProcesseur<=0) {
            throw new Exception("Veuillez entrer un id de processeur valide");
        }
        this.idProcesseur = idProcesseur;
    }
    public String getNomProcesseur() {
        return nomProcesseur;
    }
    public void setNomProcesseur(String nomProcesseur)
    throws Exception {
        if(nomProcesseur==null||nomProcesseur.length()==0) {
            throw new Exception("Veuillez entrer un nom de processeur");
        }
        this.nomProcesseur = nomProcesseur;
    }
    public double getFrequence() {
        return frequence;
    }
    public void setFrequence(double frequence)
    throws Exception {
        if(frequence<=0) {
            throw new Exception("Veuillez entrer une frequence plus grande");
        }
        this.frequence = frequence;
    }
    public double getNbCoeur() {
        return nbCoeur;
    }
    public void setNbCoeur(double nbCoeur)
    throws Exception {
        if(nbCoeur<=0) {
            throw new Exception("Veuillez entrer un nombre de coeur plus grande");
        }
        this.nbCoeur = nbCoeur;
    }
}
