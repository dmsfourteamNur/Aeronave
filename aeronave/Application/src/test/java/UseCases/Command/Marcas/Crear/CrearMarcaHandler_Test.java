package UseCases.Command.Marcas.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Dto.MarcaDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Factories.IMarcaFactory;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearMarcaHandler_Test {

  IMarcaFactory marcaFactory = Mockito.mock(IMarcaFactory.class);
  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    String nombre = "Marca test1";

    Marca entity = new Marca(nombre);
    when(marcaFactory.Create(nombre)).thenReturn(entity);

    CrearMarcaHandler handler = new CrearMarcaHandler(marcaFactory, marcaRepository, _unitOfWork);

    MarcaDto dto = new MarcaDto();
    dto.nombre = nombre;

    CrearMarcaCommand command = new CrearMarcaCommand(dto);
    UUID resp = handler.handle(command);

    // verify(marcaRepository).Create(resp);
    verify(_unitOfWork).commit();
    Assert.assertNotNull(resp);
  }

  @Test
  public void HandleFailed() throws Exception {
    when(marcaRepository.FindByKey(any())).thenReturn(null);
    CrearMarcaHandler handler = new CrearMarcaHandler(marcaFactory, marcaRepository, _unitOfWork);
    MarcaDto dto = new MarcaDto();
    dto.nombre = "ABC";
    CrearMarcaCommand command = new CrearMarcaCommand(dto);
    try {
      handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
