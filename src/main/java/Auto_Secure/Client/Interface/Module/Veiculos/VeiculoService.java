package Auto_Secure.Client.Interface.Module.Veiculos;

import Auto_Secure.Client.Interface.Exceptions.RegraDeNegocioException;
import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }


    @Transactional
    public Veiculo cadastrarNovoVeiculo(Veiculo veiculo, String cpf){
            if(clienteRepository.existsById(cpf)){
                veiculo.setCliente(clienteRepository.findById(cpf).orElseThrow());
            }
        if(veiculoRepository.existsById(veiculo.getPlaca())){
            throw new RegraDeNegocioException("placa já registrada" + veiculo.getPlaca());
        }
        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public Iterable<Veiculo> veiculoCadastrados(){
        return veiculoRepository.findAll();
    }
    @Transactional
    public Veiculo veiculosId(String placa){
        if (veiculoRepository.existsById(placa)){
            return veiculoRepository.findById(placa).orElseThrow();
        }
        return null;
    }

    @Transactional
    public Veiculo editarVeiculo(String placa){
        if (veiculoRepository.existsById(placa)){
            veiculoRepository.save(veiculosId(placa));
            return veiculosId(placa);
        }
        else {
            return null;
        }
    }
    }

