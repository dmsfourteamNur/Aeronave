package UseCases.Command.Marcas.AddModelo;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Dto.ModeloDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class AddModeloMarcaCommand implements Request<ModeloDto> {

  private UUID key;
  public ModeloDto modelo;

  public AddModeloMarcaCommand(UUID key) {
    this.key = key;
  }

  public void setModelo(ModeloDto modelo) {
    this.modelo = modelo;
    this.modelo.keyMarca = this.key;
  }
}
