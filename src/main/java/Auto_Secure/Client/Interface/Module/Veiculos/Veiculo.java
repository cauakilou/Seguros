package Auto_Secure.Client.Interface.Module.Veiculos;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
        import jakarta.validation.constraints.*;
        import java.time.Year;

@Entity
@Table(name = "veiculos")
public class Veiculo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A placa não pode estar em branco.")
    @Pattern(
            regexp = "[A-Z]{3}[0-9][A-Z][0-9]{2}|[A-Z]{3}[0-9]{4}",
            message = "Formato de placa inválido. Use o formato ABC1234 ou ABC1D23."
    )
    @Column(unique = true, nullable = false, length = 7)
    private String placa;

    @NotBlank(message = "O tipo do veículo não pode estar em branco.")
    private String tipo;

    @NotBlank(message = "O modelo do veículo não pode estar em branco.")
    private String modelo;

    // NOVO - Campo para a cor do veículo
    @NotBlank(message = "A cor não pode estar em branco.")
    @Size(max = 50, message = "O nome da cor não pode exceder 50 caracteres.")
    private String cor;

    @NotNull(message = "O ano não pode ser nulo.")
    @Min(value = 1950, message = "O ano do veículo deve ser igual ou superior a 1950.")
    private Year ano;

    @NotNull(message = "O valor não pode ser nulo.")
    @Positive(message = "O valor do veículo deve ser um número positivo.")
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false) // Define a coluna de chave estrangeira na tabela 'veiculos'
    @JsonIgnore // 1. Evita loops infinitos na serialização JSON
    private Cliente cliente;

    // Construtor vazio
    public Veiculo() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa != null) {
            this.placa = placa.toUpperCase().trim();
        } else {
            this.placa = null;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // NOVO - Getter e Setter para o campo 'cor'
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Year getAno() {
        return ano;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}