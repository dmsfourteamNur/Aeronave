package UseCases.Command.Marcas.Eliminar;

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

public class EliminarMarcaHandler_Test {

  IMarcaFactory marcaFactory = Mockito.mock(IMarcaFactory.class);
  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    UUID key = UUID.randomUUID();
    String nombre = "Marca test1";

    Marca entity = new Marca(nombre);
    entity.key = key;
    when(marcaRepository.Delete(any())).thenReturn(entity);
    when(marcaRepository.FindByKey(any())).thenReturn(entity);

    EliminarMarcaHandler handler = new EliminarMarcaHandler(
      marcaFactory,
      marcaRepository,
      _unitOfWork
    );

    MarcaDto dto = new MarcaDto();
    dto.key = key;
    dto.nombre = nombre;

    EliminarMarcaCommand command = new EliminarMarcaCommand(dto.key);
    command.marca.nombre = nombre;
    UUID resp = handler.handle(command);

    Assert.assertEquals(dto.key, resp);
  }

  @Test
  public void HandleFailed() throws Exception {
    when(marcaRepository.FindByKey(any())).thenReturn(null);
    EliminarMarcaHandler handler = new EliminarMarcaHandler(
      marcaFactory,
      marcaRepository,
      _unitOfWork
    );
    MarcaDto dto = new MarcaDto();
    dto.nombre = "ABC";
    dto.key = UUID.randomUUID();
    EliminarMarcaCommand command = new EliminarMarcaCommand(dto.key);
    try {
      handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
