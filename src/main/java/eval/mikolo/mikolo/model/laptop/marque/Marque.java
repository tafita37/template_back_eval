package eval.mikolo.mikolo.model.laptop.marque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marque", nullable = false, columnDefinition = "INTEGER")
    int idMarque;
    @Column(name = "nom_marque", columnDefinition = "VARCHAR(30)", unique = true)
    String nomMarque;
    public Marque(int idMarque, String nomMarque)
    throws Exception {
        this.setIdMarque(idMarque);
        this.setNomMarque(nomMarque);
    }
    public Marque() {
    }
    public int getIdMarque() {
        return idMarque;
    }
    public void setIdMarque(int idMarque)
    throws Exception {
        if(idMarque<=0) {
            throw new Exception("Veuillez entrer une id de marque valide");
        }
        this.idMarque = idMarque;
    }
    public String getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(String nomMarque)
    throws Exception {
        if(nomMarque==null||nomMarque.length()==0) {
            throw new Exception("Veuillez entrer un nom de marque");
        }
        this.nomMarque = nomMarque;
    }
}
