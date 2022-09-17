package UseCases.Command.Aeronaves.Eliminar;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class EliminarAeronaveHandler implements RequestHandler<EliminarAeronaveCommand, UUID> {

  private IAeronaveFactory _aeronaveFactory;
  private IAeronaveRepository _aeronaveRepository;
  private IUnitOfWork _unitOfWork;

  public EliminarAeronaveHandler(
    IAeronaveFactory aeronaveFactory,
    IAeronaveRepository aeronaveRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._aeronaveFactory = aeronaveFactory;
    this._aeronaveRepository = aeronaveRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(EliminarAeronaveCommand request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByKey(request.aeronave.key);
    if (aeronave == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
    }

    return _aeronaveRepository.Delete(aeronave).key;
  }
}
