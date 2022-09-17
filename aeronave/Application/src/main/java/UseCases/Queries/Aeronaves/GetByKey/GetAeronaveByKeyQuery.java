package UseCases.Queries.Aeronaves.GetByKey;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {

  public GetAeronaveByKeyQuery(UUID key) {
    this.key = key;
  }

  public UUID key;
}
