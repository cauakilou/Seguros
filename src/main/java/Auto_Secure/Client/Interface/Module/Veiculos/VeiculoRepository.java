package Auto_Secure.Client.Interface.Module.Veiculos;

import Auto_Secure.Client.Interface.Module.Cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {
    Set<Veiculo> findByCliente(Cliente cliente);
}