package UseCases.Consumers;

import Fourteam.mediator.IMediator;
import IntegrationEvents.TripulacionCreado;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class TripulacionCreadoConsumer_Test {

  IMediator iMediator = Mockito.mock(IMediator.class);

  @Test
  public void constructor_test() {
    new TripulacionCreadoConsumer(iMediator)
      .Consume(new TripulacionCreado(UUID.randomUUID(), "Desripcion", "Estado", null));
  }
}
