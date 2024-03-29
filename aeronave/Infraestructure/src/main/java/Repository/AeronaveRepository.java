package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import java.util.List;
import java.util.UUID;

public class AeronaveRepository implements IAeronaveRepository {

  private DbSet<Aeronave> _aeronaves;

  public AeronaveRepository(IWriteDbContext database) {
    _aeronaves = database.Aeronave;
  }

  public BooleanFunction<Aeronave> equalMatricula(String matricula) {
    return obj -> obj.matricula.equals(matricula);
  }

  public BooleanFunction<Aeronave> equalKey(UUID key) {
    return obj -> obj.key.equals(key);
  }

  @Override
  public Aeronave FindByKey(UUID key) throws Exception {
    return _aeronaves.Single(equalKey(key));
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
    _aeronaves.Delete(equalKey(obj.key));
    return obj;
  }

  @Override
  public Aeronave Update(Aeronave obj) throws Exception {
    _aeronaves.Update(obj, equalKey(obj.key));
    return obj;
  }

  @Override
  public Aeronave FindByMatricula(String matricula) throws Exception {
    return _aeronaves.Single(equalMatricula(matricula));
  }
}
