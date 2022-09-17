package UseCases.Command.Marcas.Editar;

import Dto.MarcaDto;
import Factories.IAeronaveFactory;
import Factories.IMarcaFactory;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarMarcaHandler implements RequestHandler<EditarMarcaCommand, MarcaDto> {

  private IMarcaFactory _marcaFactory;
  private IMarcaRepository _marcaRepository;
  private IUnitOfWork _unitOfWork;

  public EditarMarcaHandler(
    IMarcaFactory marcaFactory,
    IMarcaRepository marcaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._marcaFactory = marcaFactory;
    this._marcaRepository = marcaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public MarcaDto handle(EditarMarcaCommand request) throws Exception {
    Marca marca = _marcaRepository.FindByKey(request.marca.key);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
    }
    marca.nombre = request.marca.nombre;
    _marcaRepository.Update(marca);

    return new MarcaDto(marca.key, marca.nombre);
  }
}
