package Context;

import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Marcas.Marca;
import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) throws DataBaseException {
    super(dbContextClass);
  }

  public DbSet<Aeronave> Aeronave;
  public DbSet<Asiento> Asiento;
  public DbSet<Marca> Marca;
}
