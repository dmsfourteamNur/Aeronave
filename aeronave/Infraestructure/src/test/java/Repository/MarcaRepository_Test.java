package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Model.Marcas.Marca;
import fourteam.db.DbSet;
import fourteam.db.IDbSet.BooleanFunction;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class MarcaRepository_Test {

  IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
  DbSet<Marca> _marcas = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    _database.Marca = _marcas;
  }

  @Test
  public void constructor_accept() {
    MarcaRepository repository = new MarcaRepository(_database);
    Assert.assertNotNull(repository);
  }

  @Test
  public void FindByKey_accept() throws Exception {
    // Mockito.verify(_marcas).Single(obj -> obj.key.equals(UUID.randomUUID()));
    Marca a = new Marca("Nombre");

    BooleanFunction<Marca> fun = o -> {
      return true;
    };
    _marcas.Single(fun);
    MarcaRepository repository = new MarcaRepository(_database);
    // verify(_marcas).Single(any());

    // ArgumentCaptor<Marca> captor = ArgumentCaptor.forClass(Marca.class);
    repository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(repository);
  }

  @Test
  public void GetAll_accept() throws Exception {
    MarcaRepository repository = new MarcaRepository(_database);
    repository.GetAll();
    Assert.assertNotNull(repository);
  }

  @Test
  public void Create_accept() throws Exception {
    MarcaRepository repository = new MarcaRepository(_database);
    repository.Create(new Marca("Nombre"));
    Assert.assertNotNull(repository);
  }

  @Test
  public void Delete_accept() throws Exception {
    MarcaRepository repository = new MarcaRepository(_database);
    repository.Delete(new Marca("Nombre"));
    Assert.assertNotNull(repository);
  }

  @Test
  public void Update_accept() throws Exception {
    MarcaRepository repository = new MarcaRepository(_database);
    repository.Update(new Marca("Nombre"));
    Assert.assertNotNull(repository);
  }
}
