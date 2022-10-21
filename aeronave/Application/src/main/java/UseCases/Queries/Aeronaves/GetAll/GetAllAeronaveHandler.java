package UseCases.Queries.Aeronaves.GetAll;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import java.util.ArrayList;
import java.util.List;

public class GetAllAeronaveHandler
  implements RequestHandler<GetAllAeronaveQuery, List<AeronaveDto>> {

  private IAeronaveRepository _aeronaveRepository;

  public GetAllAeronaveHandler(IAeronaveRepository aeronaveRepository) {
    this._aeronaveRepository = aeronaveRepository;
  }

  @Override
  public List<AeronaveDto> handle(GetAllAeronaveQuery request) throws Exception {
    List<AeronaveDto> resp = new ArrayList<>();
    for (Aeronave aeronave : _aeronaveRepository.GetAll()) {
      resp.add(new AeronaveDto(aeronave));
    }
    return resp;
  }
}
