package UseCases.Queries.Aeronaves.GetByKey;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class GetAeronaveByKeyHandler implements RequestHandler<GetAeronaveByKeyQuery, AeronaveDto> {

  private IAeronaveRepository _aeronaveRepository;

  public GetAeronaveByKeyHandler(IAeronaveRepository aeronaveRepository) {
    this._aeronaveRepository = aeronaveRepository;
  }

  @Override
  public AeronaveDto handle(GetAeronaveByKeyQuery request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByKey(request.key);
    if (aeronave == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
    }
    AeronaveDto aeronaveDto = new AeronaveDto(aeronave);
    return aeronaveDto;
  }
}
