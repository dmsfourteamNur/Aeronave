package UseCases.Command.Marcas.Editar;

import Dto.MarcaDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarMarcaCommand_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Marca Test";
    MarcaDto dto = new MarcaDto();
    dto.key = key;
    dto.nombre = nombre;

    EditarMarcaCommand command = new EditarMarcaCommand(dto.key);
    Assert.assertEquals(dto.key, command.marca.key);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(EditarMarcaCommand.class.getConstructors()[0].canAccess(null));
  }
}
