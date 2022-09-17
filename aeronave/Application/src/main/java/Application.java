import Factories.AeronaveFactory;
import Factories.IAeronaveFactory;
import Factories.IMarcaFactory;
import Factories.MarcaFactory;
import UseCases.Command.Aeronaves.AddAsiento.AddAsientoAeronaveHandler;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveHandler;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveHandler;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveHandler;
import UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado.UpdateAsientosWhenAeronaveCreadoHandler;
import UseCases.Command.Marcas.AddModelo.AddModeloMarcaHandler;
import UseCases.Command.Marcas.Crear.CrearMarcaHandler;
import UseCases.Command.Marcas.Editar.EditarMarcaHandler;
import UseCases.Command.Marcas.Eliminar.EliminarMarcaHandler;
import UseCases.DomainEventHandler.Aeronave.PublishIntegrationEventWhenAeronaveCreadoHandler;
import UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveHandler;
import UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyHandler;
import UseCases.Queries.Marcas.GetAll.GetAllMarcaHandler;
import UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyHandler;
import fourteam.extensions.IServiceCollection;
import fourteam.mediator.IMediator;

public class Application {

  public static void AddApplication() {
    // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring

    IMediator.registerHandler(GetAllAeronaveHandler.class);
    IMediator.registerHandler(GetAeronaveByKeyHandler.class);
    IMediator.registerHandler(CrearAeronaveHandler.class);
    IMediator.registerHandler(EliminarAeronaveHandler.class);
    IMediator.registerHandler(EditarAeronaveHandler.class);
    IMediator.registerHandler(AddAsientoAeronaveHandler.class);

    // MARCA
    IMediator.registerHandler(GetAllMarcaHandler.class);
    IMediator.registerHandler(GetMarcaByKeyHandler.class);
    IMediator.registerHandler(CrearMarcaHandler.class);
    IMediator.registerHandler(EliminarMarcaHandler.class);
    IMediator.registerHandler(EditarMarcaHandler.class);
    IMediator.registerHandler(AddModeloMarcaHandler.class);

    IMediator.registerHandler(UpdateAsientosWhenAeronaveCreadoHandler.class);
    IMediator.registerHandler(PublishIntegrationEventWhenAeronaveCreadoHandler.class);
    IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
    IServiceCollection.AddTransient(IMarcaFactory.class, MarcaFactory.class);

    Domain.addDomain();
  }
}
