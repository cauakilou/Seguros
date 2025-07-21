package Auto_Secure.Client.Interface.Module.Acionamentos;

import Auto_Secure.Client.Interface.Module.Cliente.ClientService;
import Auto_Secure.Client.Interface.Module.Cliente.ClienteRepository;
import Auto_Secure.Client.Interface.Module.Veiculos.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AcionamentoService {

    @Autowired
    AcionamentoRepository acionamentoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    VeiculoRepository veiculoRepository;

    @Transactional
    public Acionamento acionar(String CPF, String desc, int codigo){
        Acionamento acionamento = new Acionamento(clientService.clienteId(CPF),desc,codigo);
        acionamento.setDataDeInicio();
        acionamento.setResolvido(false);
        acionamentoRepository.save(acionamento);
        return acionamento;
    }

    @Transactional
    public Iterable<Acionamento> mostrarAcionamentos(){
        return acionamentoRepository.findAll();
    }

    @Transactional
    public Acionamento atualizar(long id, String decisaoFinal, String responsavel){
        if (acionamentoRepository.existsById(id)){
            acionamentoRepository.findById(id).orElseThrow()
                    .setDecisaoFinal(decisaoFinal, responsavel);
    }
        return null;
    }
}
