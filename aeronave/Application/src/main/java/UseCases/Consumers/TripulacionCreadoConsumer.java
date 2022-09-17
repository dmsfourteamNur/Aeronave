package UseCases.Consumers;

import core.IRepository;
import core.IntegrationEvent;
import fourteam.massTransit.IConsumer;
import fourteam.mediator.IMediator;

public class TripulacionCreadoConsumer extends IConsumer<IntegrationEvents.TripulacionCreado> {

  public TripulacionCreadoConsumer(IMediator mediator) {
    System.out.println("Entro al constructor del consumer");
  }

  @Override
  public void Consume(IntegrationEvents.TripulacionCreado object) {
    // TODO Auto-generated method stub
    System.out.println("Entro al consumido");
  }
}
