package eval.mikolo.mikolo.model.laptop.ram;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_ram")
public class TypeRam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_ram", nullable = false)
    int idTypeRam;
    @Column(name = "nom_type_ram", nullable = false)
    String nomTypeRam;
    public TypeRam(int idTypeRam, String nomTypeRam)
    throws Exception {
        this.setIdTypeRam(idTypeRam);
        this.setNomTypeRam(nomTypeRam);
    }
    public TypeRam() {
    }
    public int getIdTypeRam() {
        return idTypeRam;
    }
    public void setIdTypeRam(int idTypeRam)
    throws Exception {
        if(idTypeRam<=0) {
            throw new Exception("Veuillez entrer un id de type ram valide");
        }
        this.idTypeRam = idTypeRam;
    }
    public String getNomTypeRam() {
        return nomTypeRam;
    }
    public void setNomTypeRam(String nomTypeRam)
    throws Exception {
        if(nomTypeRam==null||nomTypeRam.length()==0) {
            throw new Exception("Veuillez entrer un nom de type de ram");
        }
        this.nomTypeRam = nomTypeRam;
    }
}
