package Repository;

import Context.IWriteDbContext;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class AeronaveRepository implements IAeronaveRepository {

  private DbSet<Aeronave> _aeronaves;

  public AeronaveRepository(IWriteDbContext database) {
    _aeronaves = database.Aeronave;
  }

  @Override
  public Aeronave FindByKey(UUID key) throws Exception {
    return _aeronaves.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Aeronave obj) throws Exception {
    _aeronaves.Add(obj);
  }

  @Override
  public List<Aeronave> GetAll() throws Exception {
    return _aeronaves.All();
  }

  @Override
  public Aeronave Delete(Aeronave obj) throws Exception {
    _aeronaves.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Aeronave Update(Aeronave obj) throws Exception {
    _aeronaves.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Aeronave FindByMatricula(String matricula) throws Exception {
    return _aeronaves.Single(obj -> obj.matricula.equals(matricula));
  }
}
