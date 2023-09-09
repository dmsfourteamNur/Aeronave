package Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Fourteam.mediator.IMediator;
import Fourteam.mediator.Response;
import Model.Aeronaves.Aeronave;
import UseCases.Command.Aeronaves.AddAsiento.AddAsientoAeronaveCommand;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class AeronaveController_Test {

  IMediator iMediator = Mockito.mock(IMediator.class);

  @Test
  public void Constructor() {
    // verify(WebApi.AddControllers());
    new AeronaveController(iMediator);
  }

  @Test
  public void getAll() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator).getAll();
  }

  @Test
  public void getByKey() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator).getByKey(new GetAeronaveByKeyQuery(UUID.randomUUID()));
  }

  @Test
  public void register() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator).register(new CrearAeronaveCommand(new AeronaveDto()));
  }

  @Test
  public void edit() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator)
      .edit(new Aeronave("matricula", "modelo"), new EditarAeronaveCommand(UUID.randomUUID()));
  }

  @Test
  public void delete() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator).delete(new EliminarAeronaveCommand(UUID.randomUUID()));
  }

  @Test
  public void addAsiento() throws Exception {
    // verify(WebApi.AddControllers());
    when(iMediator.send(any())).thenReturn(new Response<>());
    new AeronaveController(iMediator)
      .addAsiento(
        new AsientoDto(UUID.randomUUID(), 1, "modelo"),
        new AddAsientoAeronaveCommand(UUID.randomUUID())
      );
  }
}
