package UseCases.Command.Aeronaves.Crear;

import Dto.AeronaveDto;
import org.junit.Assert;
import org.junit.Test;

public class CrearAeronaveCommand_Test {

  @Test
  public void dataValid() {
    String matricula = "XYC";
    AeronaveDto aeronave = new AeronaveDto();
    aeronave.setMatricula(matricula);
    CrearAeronaveCommand command = new CrearAeronaveCommand(aeronave);
    Assert.assertEquals(matricula, command.data.matricula);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(CrearAeronaveCommand.class.getConstructors()[0].canAccess(null));
  }
}
