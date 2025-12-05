package juniorApi.ApiSant.Service;

import juniorApi.ApiSant.model.Pessoa;
import juniorApi.ApiSant.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    private static final String TOKENAPI =
            "574a7ff49027efebaa19dc18b17e4ead1dadf7eac42d65cb8acfa969a897e976";
    ////////////////////


    /// consultar cpf
    public Pessoa consultarCPF(String cpf, Long id) throws Exception {
        String UrlChamada = "https://bk.elaidisparos.tech/consultar-filtrada/cpf?cpf="
                + cpf + "&token=" + TOKENAPI;

        URL url = new URL(UrlChamada);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        int codigoResposta = conexao.getResponseCode();
        if (codigoResposta != 200) {
            throw new Exception("Erro ao consultar CPF: " + codigoResposta);
        }

        BufferedReader leitor = new BufferedReader(
                new InputStreamReader(conexao.getInputStream())
        );

        StringBuilder resposta = new StringBuilder();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            resposta.append(linha);
        }

        leitor.close();
        conexao.disconnect();

        // Pega o ID do JSON sem mapear tudo
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(resposta.toString());
        String nome = jsonNode.get("nome").asString();  // pega o nome completo com consuta

        // Converte JSON para Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setCpf(cpf);
        pessoa.setNome(nome);

        return salvarPessoa(pessoa);
    }


    /// /////////////////////////
    public Pessoa salvarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> getAllPessoas(){
        return pessoaRepository.findAll();
    }
}
