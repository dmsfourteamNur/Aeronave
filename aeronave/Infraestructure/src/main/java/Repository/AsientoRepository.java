package Repository;

import Context.IWriteDbContext;
import Model.Aeronaves.Asiento;
import Repositories.IAsientoRepository;
import fourteam.db.DbSet;
import java.util.UUID;

public class AsientoRepository implements IAsientoRepository {

  private DbSet<Asiento> _asientos;

  public AsientoRepository(IWriteDbContext database) {
    _asientos = database.Asiento;
  }

  @Override
  public Asiento FindByKey(UUID key) throws Exception {
    return null;
  }

  @Override
  public void Create(Asiento obj) throws Exception {
    _asientos.Add(obj);
  }
}
