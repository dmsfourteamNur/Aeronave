package UseCases.DomainEventHandler.Aeronave;

import Event.AeronaveChange;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import core.ConfirmedDomainEvent;
import core.IntegrationEvent;
import java.util.ArrayList;
import java.util.List;

public class PublishIntegrationEventWhenAeronaveChangeHandler
  implements NotificationHandler<ConfirmedDomainEvent<AeronaveChange>> {

  private IPublishEndpoint publishEndpoint;
  private IAeronaveRepository _aeronaveRepository;

  public PublishIntegrationEventWhenAeronaveChangeHandler(
    IPublishEndpoint publishEndpoint,
    IAeronaveRepository aeronaveRepository
  ) {
    this.publishEndpoint = publishEndpoint;
    this._aeronaveRepository = aeronaveRepository;
  }

  @Override
  public void handle(ConfirmedDomainEvent<AeronaveChange> notification) {
    AeronaveChange aeronaveChage = (AeronaveChange) notification.DomainEvent;
    try {
      Aeronave aeronave = _aeronaveRepository.FindByKey(aeronaveChage.keyAeronave);
      IntegrationEvents.AeronaveChange evento = new IntegrationEvents.AeronaveChange();
      evento.Key = aeronave.key;
      evento.matricula = aeronave.matricula;
      evento.keyModelo = aeronave.keyModelo;
      evento.OcurredOn = aeronaveChage.OcurredOn;
      List<IntegrationEvents.dto.AsientoDto> arrAsientos = new ArrayList<>();
      aeronave.asientos
        .iterator()
        .forEachRemaining(asiento -> {
          IntegrationEvents.dto.AsientoDto asientoDto = new IntegrationEvents.dto.AsientoDto();
          asientoDto.key = asiento.key;
          asientoDto.keyAeronave = asiento.keyAeronave;
          asientoDto.numero = asiento.numero;
          asientoDto.clase = asiento.clase;
          arrAsientos.add(asientoDto);
        });
      evento.asientos = arrAsientos;
      this.publishEndpoint.Publish(evento);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
