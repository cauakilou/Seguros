package Auto_Secure.Client.Interface.Controller;

import Auto_Secure.Client.Interface.Module.Acionamentos.*;
import Auto_Secure.Client.Interface.Module.Cliente.ClientService;
import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteDTO;
import Auto_Secure.Client.Interface.Module.Service;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/cliente")
public class ClientController {



    ClientService clientService;
    Service service;
    AcionamentoService acionamentoService;

    public ClientController(ClientService clientService, Service service, AcionamentoService acionamentoService) {
        this.clientService = clientService;
        this.service = service;
        this.acionamentoService = acionamentoService;
    }

    @PostMapping
    public Cliente novoCliente(@Valid Cliente cliente){
        clientService.cadastrarNovoCliente(cliente);
        return cliente;
    }

    @GetMapping
    public Iterable<Cliente> clientesCadastrados(){
        return clientService.ClientesCadastrados();
    }


    @GetMapping(path = "/plano/{cpf}")
    public double valorDoPlanoDoCliente(@PathVariable String cpf){
        return service.calcularValorTotalDoPlano(cpf);
    }


    @DeleteMapping(path = "/excluir/{CPF}")
    public void deletarCliente(@PathVariable String CPF){
        service.deletarCliente(clientService.clienteId(CPF));
    }

    @PatchMapping(path = "/edit/{cpf}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable String cpf, ClienteDTO atualizar){
        Cliente clienteAtualizado = clientService.editarCliente(cpf,atualizar);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @PostMapping(path = "/acionar")
    public Acionamento acionar(String CPF,String desc, int codigo){
        return acionamentoService.acionar(CPF,desc,codigo);
    }

}
