package UseCases.Command.Marcas.AddModelo;

import Dto.AsientoDto;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Marcas.Marca;
import Model.Marcas.Modelo;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class AddModeloMarcaHandler implements RequestHandler<AddModeloMarcaCommand, UUID> {

  private IMarcaRepository _marcaRepository;
  private IUnitOfWork _unitOfWork;

  public AddModeloMarcaHandler(IMarcaRepository marcaRepository, IUnitOfWork _unitOfWork) {
    this._marcaRepository = marcaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(AddModeloMarcaCommand request) throws Exception {
    Marca marca = _marcaRepository.FindByKey(request.modelo.keyMarca);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "marca Not found");
    }

    Modelo modelo = new Modelo(request.modelo.keyMarca, request.modelo.nombre);
    marca.agregarModelo(modelo);
    _marcaRepository.Update(marca);
    _unitOfWork.commit();
    return modelo.key;
  }
}
