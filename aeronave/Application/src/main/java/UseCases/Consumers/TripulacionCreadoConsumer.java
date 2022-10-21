package UseCases.Consumers;

import Fourteam.massTransit.IConsumer;
import Fourteam.mediator.IMediator;
import core.IRepository;
import core.IntegrationEvent;

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
