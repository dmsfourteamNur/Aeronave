package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import java.util.List;
import java.util.UUID;

public class MarcaRepository implements IMarcaRepository {

  private DbSet<Marca> _marcas;

  public BooleanFunction<Marca> equalKey(UUID key) {
    return obj -> obj.key.equals(key);
  }

  public MarcaRepository(IWriteDbContext database) {
    _marcas = database.Marca;
  }

  @Override
  public Marca FindByKey(UUID key) throws Exception {
    return _marcas.Single(equalKey(key));
  }

  @Override
  public void Create(Marca obj) throws Exception {
    _marcas.Add(obj);
  }

  @Override
  public List<Marca> GetAll() throws Exception {
    return _marcas.All();
  }

  @Override
  public Marca Delete(Marca obj) throws Exception {
    _marcas.Delete(equalKey(obj.key));
    return obj;
  }

  @Override
  public Marca Update(Marca obj) throws Exception {
    _marcas.Update(obj, equalKey(obj.key));
    return obj;
  }

  @Override
  public Marca FindByKeyModelo(String keyModelo) throws Exception {
    return _marcas.Single(obj ->
      obj.modelos
        .stream()
        .filter(model -> model.key.toString().equals(keyModelo))
        .findAny()
        .orElse(null) !=
      null
    );
  }
}
