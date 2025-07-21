package Auto_Secure.Client.Interface.Controller;

import Auto_Secure.Client.Interface.Module.Acionamentos.Acionamento;
import Auto_Secure.Client.Interface.Module.Acionamentos.AcionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/acionamento")
public class AcionamentoController {

    @Autowired
    AcionamentoService acionamentoService;

    @GetMapping
    public Iterable<Acionamento> acionamentos(){
        return acionamentoService.mostrarAcionamentos();
    }

    @PatchMapping(path = "/finalizar")
    @ResponseBody
    public Acionamento finalizar(long id, String decisao, String responsavel){
        return acionamentoService.atualizar(id, decisao, responsavel);
    }
}
