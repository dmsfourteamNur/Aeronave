package Controllers;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Model.Aeronaves.Aeronave;
import UseCases.Command.Aeronaves.AddAsiento.AddAsientoAeronaveCommand;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveQuery;
import UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.DeleteMapping;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.PostMapping;
import Fourteam.http.annotation.PutMapping;
import Fourteam.http.annotation.RequestBody;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

  private Mediator _mediator;

  public AeronaveController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public List<AeronaveDto> getAll() throws HttpException {
    try {
      Response<List<AeronaveDto>> lista = _mediator.send(new GetAllAeronaveQuery());
      return lista.data;
    } catch (Exception e) {
      throw (HttpException) e.getCause();
    }
  }

  @GetMapping("/{key}")
  public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request)
    throws HttpException {
    try {
      return _mediator.send(request);
    } catch (Exception e) {
      throw (HttpException) e.getCause();
    }
  }

  @PostMapping("/registro")
  public UUID register(@RequestBody CrearAeronaveCommand aeronave) throws Exception {
    return (UUID) _mediator.send(aeronave).data;
  }

  @PutMapping("/{key}")
  public AeronaveDto edit(
    @RequestBody Aeronave aeronave,
    @PathVariable EditarAeronaveCommand request
  ) throws HttpException {
    request.aeronave.matricula = aeronave.matricula;
    try {
      return (AeronaveDto) _mediator.send(request).data;
    } catch (Exception e) {
      throw (HttpException) e.getCause();
    }
  }

  @PutMapping("/AddAsiento/{key}")
  public UUID addAsiento(
    @RequestBody AsientoDto asientoDto,
    @PathVariable AddAsientoAeronaveCommand request
  ) throws Exception {
    request.setAsiento(asientoDto);
    return (UUID) _mediator.send(request).data;
  }

  @DeleteMapping("/{key}")
  public UUID delete(@PathVariable EliminarAeronaveCommand request) throws HttpException {
    try {
      return (UUID) _mediator.send(request).data;
    } catch (Exception e) {
      throw (HttpException) e.getCause();
    }
  }
}
