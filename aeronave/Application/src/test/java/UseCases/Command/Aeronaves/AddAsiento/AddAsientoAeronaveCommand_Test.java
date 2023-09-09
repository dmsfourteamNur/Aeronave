package UseCases.Command.Aeronaves.AddAsiento;

import Dto.AsientoDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AddAsientoAeronaveCommand_Test {

  @Test
  public void contructor_valid() {
    Assert.assertNotNull(new AddAsientoAeronaveCommand(UUID.randomUUID()));
  }

  @Test
  public void setAsiento_valid() {
    AsientoDto asientoDto = new AsientoDto(UUID.randomUUID(), 1, "clase");
    AddAsientoAeronaveCommand addAsientoAeronaveCommand = new AddAsientoAeronaveCommand(
      UUID.randomUUID()
    );
    addAsientoAeronaveCommand.setAsiento(asientoDto);
    Assert.assertNotNull(addAsientoAeronaveCommand.asiento);
  }
}
