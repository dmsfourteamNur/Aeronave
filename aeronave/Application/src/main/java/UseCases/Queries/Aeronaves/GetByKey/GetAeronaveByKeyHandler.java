package UseCases.Queries.Aeronaves.GetByKey;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

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
    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.key = aeronave.key;
    aeronaveDto.matricula = aeronave.matricula;
    aeronave.asientos
      .iterator()
      .forEachRemaining(obj -> {
        aeronaveDto.asientos.add(new AsientoDto(obj.key, obj.numero, obj.clase));
      });
    return aeronaveDto;
  }
}
