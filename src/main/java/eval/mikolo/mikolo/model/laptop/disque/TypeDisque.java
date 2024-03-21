package eval.mikolo.mikolo.model.laptop.disque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_disque")
public class TypeDisque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_disque", nullable = false)
    int idTypeDisque;
    @Column(name = "nom_type_disque", nullable = false)
    String nomTypeDisque;
    public TypeDisque(int idTypeDisque, String nomTypeDisque)
    throws Exception {
        this.setIdTypeDisque(idTypeDisque);
        this.setNomTypeDisque(nomTypeDisque);
    }
    public TypeDisque() {
    }
    public int getIdTypeDisque() {
        return idTypeDisque;
    }
    public void setIdTypeDisque(int idTypeDisque)
    throws Exception {
        if(idTypeDisque<=0) {
            throw new Exception("Veuillez entrer un id de type disque valide");
        }
        this.idTypeDisque = idTypeDisque;
    }
    public String getNomTypeDisque() {
        return nomTypeDisque;
    }
    public void setNomTypeDisque(String nomTypeDisque)
    throws Exception {
        if(nomTypeDisque==null||nomTypeDisque.length()==0) {
            throw new Exception("Veuillez entrer un nom de type de disque");
        }
        this.nomTypeDisque = nomTypeDisque;
    }
}
