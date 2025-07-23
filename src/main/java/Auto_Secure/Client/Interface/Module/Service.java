package Auto_Secure.Client.Interface.Module;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteRepository;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoRepository;

import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    ClienteRepository clienteRepository;

    VeiculoRepository veiculosRepository;

    public Service(ClienteRepository clienteRepository, VeiculoRepository veiculosRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculosRepository = veiculosRepository;
    }

    public void deletarCliente(Cliente cliente){
        clienteRepository.deleteById(cliente.getCPF());
    }

    public Veiculo veiculoPelaPlaca(String placa){
        if (veiculosRepository.existsById(placa)){
            return veiculosRepository.findById(placa).orElseThrow();
        }
        return null;
    }


    public double calcularValorTotalDoPlano(String cpf) {
        // 1. BUSCA o cliente UMA ÚNICA VEZ.
        Cliente cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente com CPF " + cpf + " não encontrado."));

        // 2. OBTÉM a lista de veículos do cliente.
        Set<Veiculo> veiculos = cliente.getVeiculos();

        // 3. SOMA o valor de todos os veículos usando a API de Streams.
        //    mapToDouble é mais eficiente para trabalhar com primitivos.
        double somaDosValoresDosVeiculos = veiculos.stream()
                .mapToDouble(Veiculo::getValor)
                .sum();

        // 4. OBTÉM o plano do cliente.
        PlanosDeSeguro plano = cliente.getPlano();

        // 5. CALCULA o valor do seguro sobre a SOMA TOTAL e o RETORNA.
        return plano.calcularValor(somaDosValoresDosVeiculos);
    }

}
