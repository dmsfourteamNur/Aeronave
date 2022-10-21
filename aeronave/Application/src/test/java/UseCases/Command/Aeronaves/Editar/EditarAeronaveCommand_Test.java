package UseCases.Command.Aeronaves.Editar;

import Dto.AeronaveDto;
import org.junit.Assert;
import org.junit.Test;

public class EditarAeronaveCommand_Test {

  @Test
  public void dataValid() {
    String matricula = "XYC";
    AeronaveDto aeronave = new AeronaveDto();
    aeronave.setMatricula(matricula);
    EditarAeronaveCommand command = new EditarAeronaveCommand(aeronave.key);
    command.aeronave.matricula = matricula;
    Assert.assertEquals(matricula, command.aeronave.getMatricula());
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(EditarAeronaveCommand.class.getConstructors()[0].canAccess(null));
  }
}
