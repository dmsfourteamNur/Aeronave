package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Fourteam.db.IDbSet.BooleanFunction;
import Model.Aeronaves.Aeronave;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class AeronaveRepository_Test {

  IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
  DbSet<Aeronave> _aeronaves = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    _database.Aeronave = _aeronaves;
  }

  @Test
  public void constructor_accept() {
    AeronaveRepository repository = new AeronaveRepository(_database);
    Assert.assertNotNull(repository);
  }

  @Test
  public void probando_lambda_by_key() {
    AeronaveRepository repository = new AeronaveRepository(_database);
    Aeronave a = new Aeronave();
    a.key = UUID.randomUUID();
    BooleanFunction<Aeronave> equalkey = repository.equalKey(a.key);
    equalkey.run(a);
  }

  @Test
  public void FindByKey_accept() throws Exception {
    // Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
    Aeronave a = new Aeronave();
    when(_aeronaves.Single(any())).thenReturn(a);
    AeronaveRepository repository = new AeronaveRepository(_database);
    // ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
    repository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(repository);
  }

  @Test
  public void FindByMatricula() throws Exception {
    // Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
    Aeronave a = new Aeronave();
    a.matricula = "ABC";
    when(_aeronaves.Single(any())).thenReturn(a);
    AeronaveRepository repository = new AeronaveRepository(_database);

    BooleanFunction<Aeronave> equalMatricula = repository.equalMatricula("null");
    equalMatricula.run(a);
    // ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
    repository.FindByMatricula("A");
    Assert.assertNotNull(repository);
  }

  @Test
  public void GetAll_accept() throws Exception {
    AeronaveRepository repository = new AeronaveRepository(_database);
    repository.GetAll();
    Assert.assertNotNull(repository);
  }

  @Test
  public void Create_accept() throws Exception {
    AeronaveRepository repository = new AeronaveRepository(_database);
    repository.Create(new Aeronave());
    Assert.assertNotNull(repository);
  }

  @Test
  public void Delete_accept() throws Exception {
    AeronaveRepository repository = new AeronaveRepository(_database);
    repository.Delete(new Aeronave());
    Assert.assertNotNull(repository);
  }

  @Test
  public void Update_accept() throws Exception {
    AeronaveRepository repository = new AeronaveRepository(_database);
    repository.Update(new Aeronave());
    Assert.assertNotNull(repository);
  }
}
