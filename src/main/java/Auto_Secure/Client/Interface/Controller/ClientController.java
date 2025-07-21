package Auto_Secure.Client.Interface.Controller;

import Auto_Secure.Client.Interface.Module.Acionamentos.*;
import Auto_Secure.Client.Interface.Module.Cliente.ClientService;
import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Service;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoRepository;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="/cliente")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    Service service;
    @Autowired
    AcionamentoService acionamentoService;

    @PostMapping
    @ResponseBody
    public Cliente novoCliente(@Valid Cliente cliente){
        clientService.cadastrarNovoCliente(cliente);
        return cliente;
    }

    @GetMapping
    public Iterable<Cliente> clientesCadastrados(){
        return clientService.ClientesCadastrados();
    }


    @GetMapping(path = "/plano/{CPF}")
    public double planodocliente(@PathVariable String CPF){
        return service.valorDoPlanoDoCliente(clientService.clienteId(CPF));
    }

    @DeleteMapping(path = "/excluir/{CPF}")
    public void deletarCliente(@PathVariable String CPF){
        service.deletarCliente(clientService.clienteId(CPF));
    }

    @PatchMapping(path = "/edit")
    @ResponseBody
    public Cliente editarCliente(String CPF){
        return clientService.editarCliente(CPF);
    }

    @PostMapping(path = "/acionar")
    public @ResponseBody Acionamento acionar(String CPF,String desc, int codigo){
        return acionamentoService.acionar(CPF,desc,codigo);
    }

}
