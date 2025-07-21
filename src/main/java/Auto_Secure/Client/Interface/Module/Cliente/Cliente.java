package Auto_Secure.Client.Interface.Module.Cliente;


import Auto_Secure.Client.Interface.Module.PlanosDeSeguro;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @NotBlank
    private String CPF;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String celular;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PlanosDeSeguro plano;

    @OneToMany(
            mappedBy = "cliente", // 1. Indica que o lado "dono" do relacionamento está na classe Veiculo, no campo "cliente".
            cascade = CascadeType.ALL, // 2. Operações (salvar, deletar) no Cliente se propagam para seus veículos.
            orphanRemoval = true, // 3. Se um veículo for removido desta lista, ele será deletado do banco.
            fetch = FetchType.LAZY // 4. Boa prática de performance: só carrega os veículos quando explicitamente solicitado.
    )
    private Set<Veiculo> veiculos = new HashSet<>(); // 5. A coleção de veículos

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public PlanosDeSeguro getPlano() {
        return plano;
    }

    public void setPlano(PlanosDeSeguro plano) {
        this.plano = plano;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
        veiculo.setCliente(null);
    }

    // Getters e Setters
    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }



}
