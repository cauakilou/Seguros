package Auto_Secure.Client.Interface.Controller;

import Auto_Secure.Client.Interface.Module.Cliente.ClientService;
import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import Auto_Secure.Client.Interface.Module.Veiculos.Veiculo;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/veiculo")
public class VeiculoController {

    VeiculoService veiculoService;
    ClientService clientService;

    public VeiculoController(ClientService clientService, VeiculoService veiculoService) {
        this.clientService = clientService;
        this.veiculoService = veiculoService;
    }

    @PostMapping
    @ResponseBody
    public Veiculo adicionarVeiculo(@Valid Veiculo veiculo,String CPF){
    return veiculoService.cadastrarNovoVeiculo(veiculo,CPF);
    }

    @GetMapping
    public Iterable<Veiculo> mostrarVeiculo(){
        return veiculoService.veiculoCadastrados();
    }

    @PatchMapping(path = "/edit")
    @ResponseBody
    public Veiculo editarveiculo(String placa){
        return veiculoService.editarVeiculo(placa);
    }
}
