package eval.mikolo.mikolo.repository.laptop.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import eval.mikolo.mikolo.model.laptop.stock.StockLaptop;

public interface StockLaptopRepository extends JpaRepository<StockLaptop, Integer> {
    
}