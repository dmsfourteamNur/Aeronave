package UseCases.Command.Aeronaves.Editar;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

  public AeronaveDto aeronave;

  public EditarAeronaveCommand(UUID key) {
    this.aeronave = new AeronaveDto();
    this.aeronave.key = key;
  }
}
