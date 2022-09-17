package UseCases.Command.Marcas.Eliminar;

import Dto.MarcaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarMarcaCommand implements Request<UUID> {

  MarcaDto marca;

  public EliminarMarcaCommand(UUID key) {
    marca = new MarcaDto();
    this.marca.key = key;
  }
}
