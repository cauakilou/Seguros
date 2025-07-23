package Auto_Secure.Client.Interface.Module.Acionamentos;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Acionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // 1. Define a relação: Muitas Apólices para Um Cliente.
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotBlank
    private String descricao;

    @NotNull
    private boolean resolvido;

    @NotNull
    private String dataDeInicio;

    private String dataDeFinalizacao;

    @NotNull
    private long codigoDeAcionamento;

    private String decisaoFinal;

    private String responsavel;

    public Acionamento(){}
    public Acionamento(Cliente cliente, String descricao, long codigoDeAcionamento) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.codigoDeAcionamento = codigoDeAcionamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public @NotNull String getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio() {
        this.dataDeInicio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"));
    }

    public String getDataDeFinalizacao() {
        return dataDeFinalizacao;
    }

    public void setDataDeFinalizacao() {
        this.dataDeFinalizacao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"));
    }

    public long getCodigoDeAcionamento() {
        return codigoDeAcionamento;
    }

    public void setCodigoDeAcionamento(long codigoDeAcionamento) {
        this.codigoDeAcionamento = codigoDeAcionamento;
    }

    public String getDecisaoFinal() {

        return decisaoFinal;
    }

    public void setDecisaoFinal(String decisaoFinal, String responsavel) {
        setResolvido(true);
        setDataDeFinalizacao();
        this.decisaoFinal = decisaoFinal;
        setresponsavel(responsavel);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getresponsavel() {
        return responsavel;
    }

    public void setresponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
