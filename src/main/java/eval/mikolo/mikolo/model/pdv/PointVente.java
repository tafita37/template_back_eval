package eval.mikolo.mikolo.model.pdv;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_vente")
public class PointVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_point_vente", nullable = false)
    int idPointVente;
    @Column(name = "nom_point_vente", nullable = false)
    String nomPointVente;

    public PointVente(int idPointVente, String nomPointVente)
    throws Exception {
        this.setIdPointVente(idPointVente);
        this.setNomPointVente(nomPointVente);
    }
    public PointVente() {
    }
    public int getIdPointVente() {
        return idPointVente;
    }
    public void setIdPointVente(int idPointVente)
    throws Exception {
        if(idPointVente<=0) {
            throw new Exception("Veuillez entrer un id de point de vente valide");
        }
        this.idPointVente = idPointVente;
    }
    public String getNomPointVente() {
        return nomPointVente;
    }
    public void setNomPointVente(String nomPointVente)
    throws Exception {
        if(nomPointVente==null||nomPointVente.length()==0) {
            throw new Exception("Veuillez entrer un nom de point de vente");
        }
        this.nomPointVente = nomPointVente;
    }
}
