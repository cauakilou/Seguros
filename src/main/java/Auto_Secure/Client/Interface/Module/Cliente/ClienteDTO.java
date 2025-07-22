package Auto_Secure.Client.Interface.Module.Cliente;

import Auto_Secure.Client.Interface.Module.PlanosDeSeguro;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;

import java.util.HashSet;
import java.util.Set;

public class ClienteDTO {
        private String nome;
        private String email;
        private String celular;
        private PlanosDeSeguro plano;

        // Getters e Setters para todos os campos
        public String getNome() {return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getCelular() { return celular; }
        public void setCelular(String celular) { this.celular = celular; }
        public PlanosDeSeguro getPlano() { return plano; }
        public void setPlano(PlanosDeSeguro plano) { this.plano = plano; }

    }

