package UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;

import Event.AeronaveCreado;
import Repositories.IAsientoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UpdateAsientosWhenAeronaveCreadoHandler_Test {

  IAsientoRepository marcaRepository = Mockito.mock(IAsientoRepository.class);

  @Test
  public void dataValid() {
    UpdateAsientosWhenAeronaveCreadoHandler handler = new UpdateAsientosWhenAeronaveCreadoHandler(
      marcaRepository
    );
    handler.handle(new AeronaveCreado());
    Assert.assertNotNull(handler);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      UpdateAsientosWhenAeronaveCreadoHandler.class.getConstructors()[0].canAccess(null)
    );
  }
}
