package UseCases.Command.Aeronaves.AddAsiento;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class AddAsientoAeronaveCommand implements Request<AsientoDto> {

  private UUID key;
  public AsientoDto asiento;

  public AddAsientoAeronaveCommand(UUID key) {
    this.key = key;
  }

  public void setAsiento(AsientoDto asiento) {
    this.asiento = asiento;
    this.asiento.keyAeronave = this.key;
  }
}
