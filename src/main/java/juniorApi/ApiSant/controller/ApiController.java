package juniorApi.ApiSant.controller;

import juniorApi.ApiSant.Service.ApiService;
import juniorApi.ApiSant.Service.PessoaService;
import juniorApi.ApiSant.model.Cartao;
import juniorApi.ApiSant.model.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final PessoaService pessoaService;

    private final ApiService apiService;
    public ApiController(PessoaService pessoaService, ApiService apiService) {
        this.pessoaService = pessoaService;
        this.apiService = apiService;
    }

    @GetMapping("/cpf")
    public Pessoa consultarCPF(@RequestBody Pessoa pessoa) throws Exception {
        // Validação simples de CPF
        pessoaService.salvarPessoa(pessoa);
        Long id = pessoa.getId();
        return pessoaService.consultarCPF(pessoa.getCpf(), id);

    }

    @PostMapping("/adicionar")
    public Cartao adicionarCartao(@RequestBody Cartao cartao) {
        return apiService.salvarCartaoDados(cartao);
    }

    @GetMapping("/97hasod8HGashb/mostrar")
    public Map<String, Object> getAll() {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        List<Cartao> cartoes = apiService.getAll();

        Map<String, Object> map = new HashMap<>();
        map.put("pessoas", pessoas);
        map.put("cartoes", cartoes);

        return map;
    }
}
