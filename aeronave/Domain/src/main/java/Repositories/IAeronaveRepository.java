package Repositories;

import Model.Aeronaves.Aeronave;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IAeronaveRepository extends IRepository<Aeronave, UUID> {
  public List<Aeronave> GetAll() throws Exception;

  public Aeronave Delete(Aeronave aeronave) throws Exception;

  public Aeronave Update(Aeronave aeronave) throws Exception;

  public Aeronave FindByMatricula(String matricula) throws Exception;
}
