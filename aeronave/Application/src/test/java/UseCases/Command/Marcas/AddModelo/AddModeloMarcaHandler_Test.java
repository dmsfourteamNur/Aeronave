package UseCases.Command.Marcas.AddModelo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.MarcaDto;
import Dto.ModeloDto;
import Fourteam.http.Exception.HttpException;
import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import UseCases.Command.Marcas.Crear.CrearMarcaHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AddModeloMarcaHandler_Test {

  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Test
  public void HandleCorrectly() throws Exception {
    String nombre = "Marca test1";
    Marca entity = new Marca(nombre);
    when(marcaRepository.FindByKey(any())).thenReturn(entity);

    AddModeloMarcaHandler handler = new AddModeloMarcaHandler(marcaRepository, _unitOfWork);

    AddModeloMarcaCommand command = new AddModeloMarcaCommand(UUID.randomUUID());
    command.modelo = new ModeloDto(UUID.randomUUID(), UUID.randomUUID(), "nombre del modelo");
    UUID resp = handler.handle(command);

    verify(_unitOfWork).commit();
    Assert.assertNotNull(resp);
  }

  @Test(expected = HttpException.class)
  public void HandleError() throws Exception {
    String nombre = "Marca test1";
    Marca entity = new Marca(nombre);
    when(marcaRepository.FindByKey(any())).thenReturn(null);

    AddModeloMarcaHandler handler = new AddModeloMarcaHandler(marcaRepository, _unitOfWork);

    AddModeloMarcaCommand command = new AddModeloMarcaCommand(UUID.randomUUID());
    command.modelo = new ModeloDto(UUID.randomUUID(), UUID.randomUUID(), "nombre del modelo");
    UUID resp = handler.handle(command);

    verify(_unitOfWork).commit();
    Assert.assertNotNull(resp);
  }
}
