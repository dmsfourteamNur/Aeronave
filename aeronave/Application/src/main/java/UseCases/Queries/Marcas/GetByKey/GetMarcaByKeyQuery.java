package UseCases.Queries.Marcas.GetByKey;

import Dto.AeronaveDto;
import Dto.MarcaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetMarcaByKeyQuery implements Request<MarcaDto> {

  public GetMarcaByKeyQuery(UUID key) {
    this.key = key;
  }

  public UUID key;
}
