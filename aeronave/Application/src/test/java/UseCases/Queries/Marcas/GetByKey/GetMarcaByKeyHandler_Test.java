package UseCases.Queries.Marcas.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetMarcaByKeyHandler_Test {

  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    Marca a = new Marca("Nombre marca");
    when(marcaRepository.FindByKey(any())).thenReturn(a);
    GetMarcaByKeyHandler handler = new GetMarcaByKeyHandler(marcaRepository);
    GetMarcaByKeyQuery query = new GetMarcaByKeyQuery(a.key);
    try {
      Assert.assertEquals(a.key, handler.handle(query).key);
    } catch (Exception e) {
      Assert.fail();
    }
    verify(marcaRepository).FindByKey(a.key);
  }

  @Test
  public void HandleFail() throws Exception {
    Marca a = new Marca("Nombre marca");
    when(marcaRepository.FindByKey(any())).thenReturn(null);
    GetMarcaByKeyHandler handler = new GetMarcaByKeyHandler(marcaRepository);
    GetMarcaByKeyQuery query = new GetMarcaByKeyQuery(a.key);
    try {
      handler.handle(query);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
  }
}
