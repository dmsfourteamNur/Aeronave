package UseCases.Command.Marcas.Crear;

import Dto.MarcaDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearMarcaCommand_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Marca Test";
    MarcaDto dto = new MarcaDto();
    dto.key = key;
    dto.nombre = nombre;

    CrearMarcaCommand command = new CrearMarcaCommand(dto);
    Assert.assertEquals(nombre, command.nombre);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(CrearMarcaCommand.class.getConstructors()[0].canAccess(null));
  }
}
