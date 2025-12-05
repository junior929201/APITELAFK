package juniorApi.ApiSant.repository;

import juniorApi.ApiSant.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ApiRepository extends JpaRepository<Cartao, Long> {

}
