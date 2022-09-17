package UseCases.Queries.Aeronaves.GetAll;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;
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
    List<Aeronave> lista = _aeronaveRepository.GetAll();
    List<AeronaveDto> resp = new ArrayList<>();
    for (Aeronave aeronave : lista) {
      AeronaveDto aeronave_dto = new AeronaveDto();
      aeronave_dto.setKey(aeronave.getKey());
      aeronave_dto.setMatricula(aeronave.matricula);
      aeronave_dto.setKeyModelo(aeronave.keyModelo);
      resp.add(aeronave_dto);
      List<AsientoDto> asientosDto = new ArrayList<>();

      for (Asiento asiento : aeronave.asientos) {
        asientosDto.add(new AsientoDto(asiento.keyAeronave, asiento.numero, asiento.clase));
      }
      aeronave_dto.setAsientos(asientosDto);
    }
    return resp;
  }
}
