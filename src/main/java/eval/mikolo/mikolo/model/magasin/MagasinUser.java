package eval.mikolo.mikolo.model.magasin;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "magasin_user")
public class MagasinUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_magasin_user", nullable = false, columnDefinition = "INTEGER")
    int idMagasinUser;
    @Column(name = "nom_magasin_user", nullable = false, columnDefinition = "VARCHAR(30)", unique = true)
    String nomMagasinUser;
    @Column(name = "mdp", nullable = false, columnDefinition = "VARCHAR(20)")
    String mdp;
    @Column(name = "role", nullable = false, columnDefinition = "TEXT")
    private String role;

    public MagasinUser(String nomMagasinUser, String mdp, String role)
    throws Exception {
        this.setNomMagasinUser(nomMagasinUser);
        this.setMdp(mdp);
        this.role=role;
    }
    public MagasinUser(int idMagasinUser, String nomMagasinUser, String mdp)
    throws Exception {
        this.setIdMagasinUser(idMagasinUser);
        this.setNomMagasinUser(nomMagasinUser);
        this.setMdp(mdp);
    }
    public MagasinUser() {
    }
    public int getIdMagasinUser() {
        return idMagasinUser;
    }
    public void setIdMagasinUser(int idMagasinUser)
    throws Exception {
        if(idMagasinUser==0) {
            throw new Exception("Veuillez entrer un id de magasin valide");
        }
        this.idMagasinUser = idMagasinUser;
    }
    public String getNomMagasinUser() {
        return nomMagasinUser;
    }
    public void setNomMagasinUser(String nomMagasinUser)
    throws Exception {
        if(nomMagasinUser==null||nomMagasinUser.length()==0) {
            throw new Exception("Veuillez entrer un nom de magasin user");
        }
        this.nomMagasinUser = nomMagasinUser;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp)
    throws Exception {
        if(mdp==null||mdp.length()==0) {
            throw new Exception("Veuillez entrer un mot de passe de magasin user");
        }
        this.mdp = mdp;
    }

    @Override
    public String getPassword() {
        return mdp;  
    }

    @Override
    public String getUsername() {
        return nomMagasinUser+","+role;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
