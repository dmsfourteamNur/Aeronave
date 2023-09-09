package UseCases.Queries.Marcas.GetAll;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Marcas.Marca;
import Model.Marcas.Modelo;
import Repositories.IMarcaRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllMarcaHandler_Test {

  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);

  @Test
  public void HandleCorrectly() throws Exception {
    Marca a = new Marca("Nombre marca");
    a.agregarModelo(new Modelo(a.getKey(), "Modelo 1"));
    List<Marca> list = new ArrayList<Marca>();
    list.add(a);
    when(marcaRepository.GetAll()).thenReturn(list);
    GetAllMarcaHandler handler = new GetAllMarcaHandler(marcaRepository);
    GetAllMarcaQuery query = new GetAllMarcaQuery();
    Assert.assertEquals(list.size(), handler.handle(query).size());
    verify(marcaRepository).GetAll();
  }
}
