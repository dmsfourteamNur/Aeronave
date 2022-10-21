package UseCases.Command.Marcas.Eliminar;

import Dto.MarcaDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarMarcaCommand_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Marca Test";
    MarcaDto dto = new MarcaDto();
    dto.key = key;
    dto.nombre = nombre;

    EliminarMarcaCommand command = new EliminarMarcaCommand(dto.key);
    Assert.assertEquals(dto.key, command.marca.key);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(EliminarMarcaCommand.class.getConstructors()[0].canAccess(null));
  }
}
