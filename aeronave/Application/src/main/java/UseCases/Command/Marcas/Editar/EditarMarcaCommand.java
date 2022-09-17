package UseCases.Command.Marcas.Editar;

import Dto.MarcaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditarMarcaCommand implements Request<MarcaDto> {

  public MarcaDto marca;

  public EditarMarcaCommand(UUID key) {
    this.marca = new MarcaDto();
    this.marca.key = key;
  }
}
