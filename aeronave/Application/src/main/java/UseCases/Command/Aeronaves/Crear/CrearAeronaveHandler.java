package UseCases.Command.Aeronaves.Crear;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Model.Marcas.Modelo;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, UUID> {

  private IAeronaveFactory _aeronaveFactory;
  private IAeronaveRepository _aeronaveRepository;
  private IMarcaRepository _MarcaRepository;
  private IUnitOfWork _unitOfWork;

  public CrearAeronaveHandler(
    IAeronaveFactory aeronaveFactory,
    IAeronaveRepository aeronaveRepository,
    IMarcaRepository marcaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._aeronaveFactory = aeronaveFactory;
    this._aeronaveRepository = aeronaveRepository;
    this._MarcaRepository = marcaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(CrearAeronaveCommand request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByMatricula(request.data.matricula);
    if (aeronave != null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Ya existe una aeronave con esta matricula.");
    }
    Marca marca = _MarcaRepository.FindByKeyModelo(request.data.keyModelo);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "No se encontro el modelo");
    }
    aeronave = _aeronaveFactory.Create(request.data.matricula, request.data.keyModelo);
    aeronave.eventCreado();
    _aeronaveRepository.Create(aeronave);
    _unitOfWork.commit();
    return aeronave.key;
  }
}
