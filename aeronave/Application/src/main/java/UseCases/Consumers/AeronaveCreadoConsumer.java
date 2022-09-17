package UseCases.Consumers;

import fourteam.massTransit.IConsumer;
import fourteam.mediator.IMediator;

public class AeronaveCreadoConsumer extends IConsumer<IntegrationEvents.AeronaveCreado> {

  public AeronaveCreadoConsumer(IMediator mediator) {
    System.out.println("Entro al constructor del consumer");
  }

  @Override
  public void Consume(IntegrationEvents.AeronaveCreado object) {
    // TODO Auto-generated method stub
    System.out.println("Entro al consumido " + object.matricula);
  }
}
