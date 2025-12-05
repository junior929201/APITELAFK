package juniorApi.ApiSant.Service;

import juniorApi.ApiSant.model.Cartao;
import juniorApi.ApiSant.repository.ApiRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ApiService {
    private static ApiRepository apiRepository ;

    public ApiService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    /// //////////////////

    public static List<Cartao> getAll() {
        return apiRepository.findAll();
    }

    public Cartao salvarCartaoDados(Cartao cartao) {
        return apiRepository.save(cartao);
    }
}
