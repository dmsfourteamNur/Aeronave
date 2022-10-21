package UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;

import Event.AeronaveCreado;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;
import Repositories.IAsientoRepository;

public class UpdateAsientosWhenAeronaveCreadoHandler
  implements NotificationHandler<AeronaveCreado> {

  private IAsientoRepository _asientoRepository;

  // private
  public UpdateAsientosWhenAeronaveCreadoHandler(IAsientoRepository asientoRepository) {
    this._asientoRepository = asientoRepository;
  }

  @Override
  public void handle(AeronaveCreado notification) {
    System.out.println(notification);
  }
}
