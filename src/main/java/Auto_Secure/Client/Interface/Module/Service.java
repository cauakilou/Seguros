package Auto_Secure.Client.Interface.Module;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteRepository;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoRepository;

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

}
