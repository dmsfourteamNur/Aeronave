package Context.MongoDB;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Fourteam.config.Config;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class WriteDbContext_Test {

  WriteDbContext context;

  MongoDatabase mdb = Mockito.mock(MongoDatabase.class);
  MongoCollection<Document> mc = Mockito.mock(MongoCollection.class);
  FindIterable iterable = Mockito.mock(FindIterable.class);
  MongoCursor<Document> cursor;

  @Before
  public void setUp() throws DataBaseException {
    Config.load(getClass().getClassLoader().getResource("config.properties").getFile());
    context = new WriteDbContext();
    when(mdb.getCollection(any())).thenReturn(mc);
    List<Document> testDocuments = Arrays.asList(
      new Document("Algo1", "Valor1"),
      new Document("Algo2", "Valor2")
    );
    FakeMongoCursor fakeCursor = new FakeMongoCursor(testDocuments);
    cursor = Mockito.spy(fakeCursor);
    when(mc.find()).thenReturn(iterable);
    when(iterable.iterator()).thenReturn(cursor);
    context.setDB(mdb);
  }

  @Test
  public void Single() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.Single(b -> true, a);
  }

  @Test
  public void SingleVoid() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.Single(b -> false, a);
  }

  @Test
  public void Update() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.Update(new Marca("Hola"), (b -> true), a);
  }

  // @Test
  // public void Add() throws Exception {
  // DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
  // context.Add("asad", a);
  // }

  @Test
  public void Delete() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.Delete(b -> true, a);
  }

  @Test
  public void Filter() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.Filter(b -> true, a);
  }

  @Test
  public void All() throws Exception {
    DbSet a = new DbSet<>(context, IWriteDbContext.class.getField("Marca"));
    context.All(a);
  }

  @Test
  public void constructor_accept() throws Exception {
    Assert.assertNotNull(context);
  }

  @Test
  public void FindByKey_accept() throws Exception {
    Assert.assertNotNull(context);
  }

  @Test
  public void isConnected() throws DataBaseException {
    Assert.assertTrue(context.isConnected());
  }

  @Test
  public void Commit() throws DataBaseException {
    context.Commit();
  }

  @Test
  public void Transaction() throws DataBaseException {
    context.Transaction();
  }

  @Test
  public void Rollback() throws DataBaseException {
    context.Rollback();
  }
}
