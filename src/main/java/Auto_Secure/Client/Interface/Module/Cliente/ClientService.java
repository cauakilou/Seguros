package Auto_Secure.Client.Interface.Module.Cliente;

import Auto_Secure.Client.Interface.Exceptions.ClienteJaCadastrado;
import Auto_Secure.Client.Interface.Exceptions.CpfInvalido;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClienteRepository clienteRepository;

    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }



    @Transactional
    public Cliente cadastrarNovoCliente(Cliente cliente){
        if(clienteRepository.existsById(cliente.getCPF())){
            throw new ClienteJaCadastrado("o cliente de já esta cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Iterable<Cliente> ClientesCadastrados(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente clienteId(String CPF){
        if (clienteRepository.existsById(CPF)){
            return clienteRepository.findById(CPF).orElseThrow();
        }
        return null;
    }

    @Transactional
    public Cliente editarCliente(String CPF){
        if (clienteRepository.existsById(CPF)){
            clienteRepository.save(clienteId(CPF));
            return clienteId(CPF);
        }
        else {
            return null;
        }
    }
}
