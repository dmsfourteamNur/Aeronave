package Repositories;

import Model.Marcas.Marca;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IMarcaRepository extends IRepository<Marca, UUID> {
  public List<Marca> GetAll() throws Exception;

  public Marca Delete(Marca obj) throws Exception;

  public Marca Update(Marca obj) throws Exception;

  public Marca FindByKeyModelo(String keyModelo) throws Exception;
}
