package UseCases.Command.Aeronaves.Eliminar;

import Dto.AeronaveDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarAeronaveCommand_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    AeronaveDto aeronave = new AeronaveDto();
    aeronave.setKey(key);
    EliminarAeronaveCommand command = new EliminarAeronaveCommand(aeronave.getKey());
    Assert.assertEquals(key, command.aeronave.getKey());
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(EliminarAeronaveCommand.class.getConstructors()[0].canAccess(null));
  }
}
