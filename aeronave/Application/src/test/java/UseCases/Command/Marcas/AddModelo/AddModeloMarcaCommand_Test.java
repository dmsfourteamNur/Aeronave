package UseCases.Command.Marcas.AddModelo;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Dto.MarcaDto;
import Dto.ModeloDto;
import Fourteam.mediator.Request;
import UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AddModeloMarcaCommand_Test {

  @Test
  public void constructor() {
    new AddModeloMarcaCommand(UUID.randomUUID());
  }

  @Test
  public void setModeloSucces() {
    new AddModeloMarcaCommand(UUID.randomUUID())
      .setModelo(new ModeloDto(UUID.randomUUID(), UUID.randomUUID(), "Nombre del modelo"));
  }
}
