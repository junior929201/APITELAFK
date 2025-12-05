package juniorApi.ApiSant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartoes")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeNoCartao;
    private String telefone;
    private String numeroCartao;
    private String cvv;
    private String validade;
    private String nome;


    public Cartao() {

    }

    public Cartao(Long id, String nomeNoCartao, String telefone, String numeroCartao, String cvv, String validade) {
        this.id = id;
        this.nomeNoCartao = nomeNoCartao;
        this.telefone = telefone;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
