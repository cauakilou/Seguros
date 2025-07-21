package Auto_Secure.Client.Interface.Module;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteRepository;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VeiculoRepository veiculosRepository;


    public double valorDoPlanoDoCliente(Cliente cliente){
        return cliente.getPlano().calcularValor(veiculoPelaPlaca(cliente.getVeiculos().toString()).getValor());
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
