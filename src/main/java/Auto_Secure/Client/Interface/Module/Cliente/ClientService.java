package Auto_Secure.Client.Interface.Module.Cliente;

import Auto_Secure.Client.Interface.Exceptions.ClienteJaCadastrado;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public Cliente editarCliente(String cpf,ClienteDTO dadosParciais){
        Cliente clienteParaAtualizar = clienteRepository.findById(cpf).orElseThrow(() -> new RuntimeException("recurso não encontrado"));
        // 2. ATUALIZAR CAMPO A CAMPO, APENAS SE UM NOVO VALOR FOI FORNECIDO
        if (dadosParciais.getNome() != null && !dadosParciais.getNome().isBlank()) {
            clienteParaAtualizar.setNome(dadosParciais.getNome());
        }

        if (dadosParciais.getEmail() != null && !dadosParciais.getEmail().isBlank()) {
            clienteParaAtualizar.setEmail(dadosParciais.getEmail());
        }

        if (dadosParciais.getCelular() != null && !dadosParciais.getCelular().isBlank()) {
            clienteParaAtualizar.setCelular(dadosParciais.getCelular());
        }

        if (dadosParciais.getPlano() != null) {
            clienteParaAtualizar.setPlano(dadosParciais.getPlano());
        }

        return clienteRepository.save(clienteParaAtualizar);
    }
 }

