package eval.mikolo.mikolo.repository.pdv.user;

import eval.mikolo.mikolo.model.pdv.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void save(User user)
    throws Exception {
        if (user.getIdUser() != 0) {
            User defaultUser=entityManager.find(User.class, user.getIdUser());
            defaultUser.setNomUser(user.getNomUser());
            defaultUser.setPrenomUser(user.getPrenomUser());
            defaultUser.setEmailUser(user.getNomUser());
            defaultUser.setDtnUser(user.getDtnUser());
            entityManager.merge(defaultUser);
        } else {
            entityManager.persist(user);
        }
    }

    public Optional<User> findByEmailUserAndMdpUser(String emailUser, String mdpUser) {
        String sql="select*from users where email_users=:emailUser and mdp_users=:mdpUser";
        Query query= entityManager.createNativeQuery(sql, User.class);
        query.setParameter("emailUser", emailUser);
        query.setParameter("mdpUser", mdpUser);
        if(query.getResultList().size()==0) {
            return Optional.empty();
        } 
        return Optional.ofNullable( (User) query.getResultList().get(0));
    }

    public Optional<User> findByEmailUser(String emailUser) {
        String sql="select*from users where email_users=:emailUser";
        Query query= entityManager.createNativeQuery(sql, User.class);
        query.setParameter("emailUser", emailUser);
        if(query.getResultList().size()==0) {
            return Optional.empty();
        } 
        return Optional.ofNullable( (User) query.getResultList().get(0));
    }

    public Optional<User> findByEmailUserAndRole(String emailUser, String role) {
        String sql="select*from users where email_users=:emailUser and role=:role";
        Query query= entityManager.createNativeQuery(sql, User.class);
        query.setParameter("emailUser", emailUser);
        query.setParameter("role", role);
        List<User> users=query.getResultList();
        if(users.size()==0) {
            return Optional.empty();
        } 
        return Optional.ofNullable( (User) users.get(0));
    }

    public Optional<User> findById(int idUser) {
        try {
            User user=entityManager.find(User.class, idUser);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<User> findUserByIdPointVente(int idPointVente) {
        String sql="select*from v_user_id_point_vente where id_point_vente=:idPointVente";
        Query query=entityManager.createNativeQuery(sql, User.class);
        query.setParameter("idPointVente", idPointVente);
        return query.getResultList();
    }

    public List<User> findAll() {
        return entityManager.createNativeQuery("select*from users", User.class).getResultList();
    }

    @Transactional
    public void deleteUserById(int idUser) {
        String sql="delete from point_vente_users where id_users=:idUser";
        Query query=entityManager.createNativeQuery(sql);
        query.setParameter("idUser", idUser);
        query.executeUpdate();
        User user=this.findById(idUser).get();
        entityManager.remove(user);
    }
}
