package UseCases.Command.Aeronaves.AddAsiento;

import Dto.AsientoDto;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class AddAsientoAeronaveHandler implements RequestHandler<AddAsientoAeronaveCommand, UUID> {

  private IAeronaveFactory _aeronaveFactory;
  private IAeronaveRepository _aeronaveRepository;
  private IUnitOfWork _unitOfWork;

  public AddAsientoAeronaveHandler(
    IAeronaveFactory aeronaveFactory,
    IAeronaveRepository aeronaveRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._aeronaveFactory = aeronaveFactory;
    this._aeronaveRepository = aeronaveRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(AddAsientoAeronaveCommand request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByKey(request.asiento.keyAeronave);
    if (aeronave == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave Not found");
    }

    Asiento asiento = new Asiento(
      request.asiento.keyAeronave,
      request.asiento.numero,
      request.asiento.clase
    );
    aeronave.agregarAsiento(asiento);
    _aeronaveRepository.Update(aeronave);
    _unitOfWork.commit();
    return asiento.key;
    // aeronave.matricula = request.aeronave.matricula;

    // return aeronave.key;
  }
}
