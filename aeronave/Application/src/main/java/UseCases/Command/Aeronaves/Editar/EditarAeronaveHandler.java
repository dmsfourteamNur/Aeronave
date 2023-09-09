package UseCases.Command.Aeronaves.Editar;

import Dto.AeronaveDto;
import Factories.IAeronaveFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;

public class EditarAeronaveHandler implements RequestHandler<EditarAeronaveCommand, AeronaveDto> {

  private IAeronaveFactory _aeronaveFactory;
  private IAeronaveRepository _aeronaveRepository;
  private IUnitOfWork _unitOfWork;

  public EditarAeronaveHandler(
    IAeronaveFactory aeronaveFactory,
    IAeronaveRepository aeronaveRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._aeronaveFactory = aeronaveFactory;
    this._aeronaveRepository = aeronaveRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public AeronaveDto handle(EditarAeronaveCommand request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByKey(request.aeronave.key);
    if (aeronave == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
    }
    aeronave.matricula = request.aeronave.matricula;
    _aeronaveRepository.Update(aeronave);
    return new AeronaveDto(aeronave);
  }
}
