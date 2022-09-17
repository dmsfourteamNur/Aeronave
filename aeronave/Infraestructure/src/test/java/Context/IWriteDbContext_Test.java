package Context;

import Context.MongoDB.WriteDbContext;
import fourteam.db.DbSet;
import fourteam.db.Exception.DataBaseException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class IWriteDbContext_Test {

  public static class Context extends IWriteDbContext {

    public Context() throws DataBaseException {
      super(Context.class);
      // TODO Auto-generated constructor stub
    }

    @Override
    public void Transaction() {
      // TODO Auto-generated method stub

    }

    @Override
    public void Commit() {
      // TODO Auto-generated method stub

    }

    @Override
    public void Rollback() {
      // TODO Auto-generated method stub

    }

    @Override
    public boolean isConnected() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public void onModelCreating(List<DbSet> sets) {
      // TODO Auto-generated method stub

    }

    @Override
    public void Add(Object obj, DbSet dbSet) {
      // TODO Auto-generated method stub

    }

    @Override
    public void Update(Object obj, BooleanFunction fun, DbSet dbSet) {
      // TODO Auto-generated method stub

    }

    @Override
    public void Delete(BooleanFunction fun, DbSet dbSet) {
      // TODO Auto-generated method stub

    }

    @Override
    public List All(DbSet dbSet) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Object Single(BooleanFunction fun, DbSet dbSet) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public List Filter(BooleanFunction fun, DbSet dbSet) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  @Test
  public void constructor_accept() throws DataBaseException {
    IWriteDbContext context = new Context();
    Assert.assertNotNull(context);
  }
}
