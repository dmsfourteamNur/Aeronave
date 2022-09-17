package UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;

import Event.AeronaveCreado;
import Repositories.IAsientoRepository;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;

public class UpdateAsientosWhenAeronaveCreadoHandler
  implements NotificationHandler<AeronaveCreado> {

  private IAsientoRepository _asientoRepository;

  // private
  public UpdateAsientosWhenAeronaveCreadoHandler(IAsientoRepository asientoRepository) {
    this._asientoRepository = asientoRepository;
  }

  @Override
  public void handle(Notification notification) {
    System.out.println(notification);
  }
}
