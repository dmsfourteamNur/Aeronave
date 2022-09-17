package UseCases.DomainEventHandler.Aeronave;

import Event.AeronaveCreado;
import core.ConfirmedDomainEvent;
import core.DomainEvent;
import core.IntegrationEvent;
import fourteam.massTransit.IPublishEndpoint;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenAeronaveCreadoHandler
  implements NotificationHandler<ConfirmedDomainEvent<AeronaveCreado>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenAeronaveCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    AeronaveCreado aeronave = (AeronaveCreado) event.DomainEvent;
    IntegrationEvents.AeronaveCreado evento = new IntegrationEvents.AeronaveCreado();
    evento.setKeyAeronave(aeronave.getKey());
    evento.setMatricula(aeronave.getMatricula());
    this.publishEndpoint.Publish(evento);
  }
}
