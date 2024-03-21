package eval.mikolo.mikolo.model.pdv.user;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    int idUser;
    @Column(name = "nom_users")
    String nomUser;
    @Column(name = "prenom_users")
    String prenomUser;
    @Column(name = "email_users")
    String emailUser;
    @Column(name = "dtn_users")
    Date dtnUser;
    @Column(name = "mdp_users")
    String mdpUser;
    @Column(name = "role")
    private String role;
    public User(String nomUser, String prenomUser, String emailUser, Date dtnUser, String mdpUser, String role)
    throws Exception {
        this.setNomUser(nomUser);
        this.setPrenomUser(prenomUser);
        this.setEmailUser(emailUser);
        this.setDtnUser(dtnUser);
        this.setMdpUser(mdpUser);
        this.setRole(role);
    }
    public User(int idUser, String nomUser, String prenomUser, String emailUser, Date dtnUser, String mdpUser, String role)
    throws Exception {
        this.setIdUser(idUser);
        this.setNomUser(nomUser);
        this.setPrenomUser(prenomUser);
        this.setEmailUser(emailUser);
        this.setDtnUser(dtnUser);
        this.setMdpUser(mdpUser);
        this.setRole(role);
    }
    public User() {
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser)
    throws Exception {
        if(idUser<=0) {
            throw new Exception("Veuillez entrer un id de user valide");
        }
        this.idUser = idUser;
    }
    public String getNomUser() {
        return nomUser;
    }
    public void setNomUser(String nomUser)
    throws Exception {
        if(nomUser==null||nomUser.length()==0) {
            throw new Exception("Veuillez entrer un nom de user");
        }
        this.nomUser = nomUser;
    }
    public String getPrenomUser() {
        return prenomUser;
    }
    public void setPrenomUser(String prenomUser)
    throws Exception {
        if(prenomUser==null||prenomUser.length()==0) {
            throw new Exception("Veuillez entrer un prenom de user");
        }
        this.prenomUser = prenomUser;
    }
    public Date getDtnUser() {
        return dtnUser;
    }
    public void setDtnUser(Date dtnUser)
    throws Exception {
        if(dtnUser==null) {
            throw new Exception("Veuillez entrer une date de naissance de l'user");
        }
        this.dtnUser = dtnUser;
    }
    public String getMdpUser() {
        return mdpUser;
    }
    public void setMdpUser(String mdpUser)
    throws Exception {
        if(mdpUser==null||mdpUser.length()==0) {
            throw new Exception("Veuillez entrer un mot de passe");
        }
        this.mdpUser = mdpUser;
    }
    public String getEmailUser() {
        return emailUser;
    }
    public void setEmailUser(String emailUser)
    throws Exception {
        if(emailUser==null||emailUser.length()==0) {
            throw new Exception("Veuillez entrer un email");
        }
        this.emailUser = emailUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new CustomGrantedAuthority(role));
    }
    @Override
    public String getPassword() {
        return mdpUser;
    }
    @Override
    public String getUsername() {
        return emailUser+","+role;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}