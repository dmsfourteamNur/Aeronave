package Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.MarcaDto;
import Dto.ModeloDto;
import Fourteam.mediator.IMediator;
import Fourteam.mediator.Response;
import UseCases.Command.Marcas.AddModelo.AddModeloMarcaCommand;
import UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import UseCases.Command.Marcas.Editar.EditarMarcaCommand;
import UseCases.Command.Marcas.Eliminar.EliminarMarcaCommand;
import UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyQuery;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class MarcaController_Test {

  IMediator iMediator = Mockito.mock(IMediator.class);

  @Test
  public void Constructor() {
    // verify(WebApi.AddControllers());
    new MarcaController(iMediator);
  }

  @Test
  public void getAll() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator).getAll();
  }

  @Test
  public void getByKey() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator).getByKey(new GetMarcaByKeyQuery(UUID.randomUUID()));
  }

  @Test
  public void register() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator).register(new CrearMarcaCommand(new MarcaDto()));
  }

  @Test
  public void edit() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator)
      .edit(new EditarMarcaCommand(UUID.randomUUID()), new MarcaDto(UUID.randomUUID(), "modelo"));
  }

  @Test
  public void delete() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator).delete(new EliminarMarcaCommand(UUID.randomUUID()));
  }

  @Test
  public void addModelo() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new MarcaController(iMediator)
      .addModelo(
        new ModeloDto(UUID.randomUUID(), UUID.randomUUID(), "modelo"),
        new AddModeloMarcaCommand(UUID.randomUUID())
      );
  }
}
