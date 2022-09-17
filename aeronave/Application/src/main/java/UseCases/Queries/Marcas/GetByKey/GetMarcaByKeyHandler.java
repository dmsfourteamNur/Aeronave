package UseCases.Queries.Marcas.GetByKey;

import Dto.MarcaDto;
import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class GetMarcaByKeyHandler implements RequestHandler<GetMarcaByKeyQuery, MarcaDto> {

  private IMarcaRepository _marcaRepository;

  public GetMarcaByKeyHandler(IMarcaRepository marcaRepository) {
    this._marcaRepository = marcaRepository;
  }

  @Override
  public MarcaDto handle(GetMarcaByKeyQuery request) throws Exception {
    Marca marca = _marcaRepository.FindByKey(request.key);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
    }
    MarcaDto marcaDto = new MarcaDto();
    marcaDto.key = marca.key;
    marcaDto.nombre = marca.nombre;
    return marcaDto;
  }
}
