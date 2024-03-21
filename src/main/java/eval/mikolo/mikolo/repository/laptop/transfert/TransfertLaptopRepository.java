package eval.mikolo.mikolo.repository.laptop.transfert;

import org.springframework.data.jpa.repository.JpaRepository;
import eval.mikolo.mikolo.model.laptop.transfert.TransfertLaptop;
import eval.mikolo.mikolo.model.pdv.PointVente;
import java.util.List;

public interface TransfertLaptopRepository extends JpaRepository<TransfertLaptop, Integer> {
    List<TransfertLaptop> findByPointVente(PointVente pointVente);
}