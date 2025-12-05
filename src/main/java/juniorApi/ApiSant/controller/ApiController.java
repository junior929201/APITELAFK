package juniorApi.ApiSant.controller;

import juniorApi.ApiSant.Service.ApiService;
import juniorApi.ApiSant.model.Cartao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PutMapping("/adicionar")
    public Cartao adicionarCartao(@RequestBody Cartao cartao) {return apiService.salvarCartaoDados(cartao);}

    @GetMapping("/97hasod8HGashb/mostrar")
    public List<Cartao> getAll(){ return apiService.getAll();}
}
