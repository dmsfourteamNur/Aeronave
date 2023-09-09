package UseCases.Consumers;

import Factories.IAeronaveFactory;
import Fourteam.mediator.IMediator;
import IntegrationEvents.AeronaveCreado;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

public class AeronaveCreadoConsumer_Test {

  IMediator iMediator = Mockito.mock(IMediator.class);

  @Test
  public void constructor_test() {
    new AeronaveCreadoConsumer(iMediator)
      .Consume(new AeronaveCreado(UUID.randomUUID(), "Matricula", "key_modelo", null));
  }
}
