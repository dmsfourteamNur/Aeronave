package UseCases.Command.Aeronaves.Eliminar;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarAeronaveCommand implements Request<AeronaveDto> {

  AeronaveDto aeronave;

  public EliminarAeronaveCommand(UUID key) {
    this.aeronave = new AeronaveDto();
    this.aeronave.key = key;
  }
}
