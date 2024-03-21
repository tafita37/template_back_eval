package eval.mikolo.mikolo.model.pdv;

import java.sql.Date;

import eval.mikolo.mikolo.model.pdv.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_vente_users")
public class PointVenteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_point_vente_users", nullable = false)
    int idPointVenteUser;
    @ManyToOne
    @JoinColumn(name = "id_point_vente", nullable = false)
    PointVente pointVente;
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    User user;
    @Column(name = "date_debut_affectation", nullable = false)
    Date dateDebutAffectation;
    @Column(name = "date_fin_affectation")
    Date dateFinAffectation;
    public int getIdPointVenteUser() {
        return idPointVenteUser;
    }
    public void setIdPointVenteUser(int idPointVenteUser)
    throws Exception {
        if(idPointVenteUser<=0) {
            throw new Exception("Veuillez entrer un id de point de vente user valide");
        }
        this.idPointVenteUser = idPointVenteUser;
    }
    public PointVente getPointVente() {
        return pointVente;
    }
    public void setPointVente(PointVente pointVente)
    throws Exception {
        if(pointVente==null) {
            throw new Exception("Veuillez entrer un point de vente");
        }
        this.pointVente = pointVente;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user)
    throws Exception {
        if(user==null) {
            throw new Exception("Veuillez entrer un utilisateur");
        }
        this.user = user;
    }
    public Date getDateDebutAffectation() {
        return dateDebutAffectation;
    }
    public void setDateDebutAffectation(Date dateDebutAffectation)
    throws Exception {
        if(dateDebutAffectation==null) {
            throw new Exception("Veuillez entrer une date de debut d'affectation");
        }
        this.dateDebutAffectation = dateDebutAffectation;
    }
    public Date getDateFinAffectation() {
        return dateFinAffectation;
    }
    public void setDateFinAffectation(Date dateFinAffectation) {
        this.dateFinAffectation = dateFinAffectation;
    }
}
