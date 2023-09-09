package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AsientoRepository_Test {

  IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
  DbSet<Asiento> _asiento = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    _database.Asiento = _asiento;
  }

  @Test
  public void FindByKey() throws Exception {
    new AsientoRepository(_database).FindByKey(UUID.randomUUID());
  }

  @Test
  public void Create() throws Exception {
    new AsientoRepository(_database).Create(new Asiento(UUID.randomUUID(), 0, "Primera"));
  }
}
