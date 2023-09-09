package UseCases.DomainEventHandler.Aeronave;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Event.AeronaveChange;
import Event.AeronaveCreado;
import Fourteam.massTransit.IPublishEndpoint;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import core.ConfirmedDomainEvent;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class PublishIntegrationEventWhenAeronaveCreadoHandler_Test {

  IPublishEndpoint iPublishEndpoint = Mockito.mock(IPublishEndpoint.class);
  IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);

  @Test
  public void crearConstructor() {
    new PublishIntegrationEventWhenAeronaveCreadoHandler(iPublishEndpoint);
  }

  @Test
  public void handle() throws Exception {
    String matricula = "ASD";
    String keyModelo = UUID.randomUUID().toString();
    Aeronave a = new Aeronave(matricula, keyModelo);

    a.agregarAsiento(new Asiento(a.key, 1, keyModelo));
    a.agregarAsiento(new Asiento(a.key, 2, keyModelo));
    ConfirmedDomainEvent<AeronaveCreado> cde = new ConfirmedDomainEvent<AeronaveCreado>(
      new AeronaveCreado(a.key, a.matricula)
    );

    new PublishIntegrationEventWhenAeronaveCreadoHandler(iPublishEndpoint).handle(cde);
  }
}
