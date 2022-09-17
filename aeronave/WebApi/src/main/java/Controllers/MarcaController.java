package Controllers;

import Dto.MarcaDto;
import Dto.ModeloDto;
import Model.Marcas.*;
import Model.Marcas.Marca;
import UseCases.Command.Marcas.AddModelo.AddModeloMarcaCommand;
import UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import UseCases.Command.Marcas.Editar.EditarMarcaCommand;
import UseCases.Command.Marcas.Eliminar.EliminarMarcaCommand;
import UseCases.Queries.Marcas.GetAll.GetAllMarcaQuery;
import UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyQuery;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/marca")
public class MarcaController {

  private Mediator _mediator;

  public MarcaController(Mediator mediator) {
    this._mediator = mediator;
  }

  @GetMapping("/")
  public List<MarcaDto> getAll() throws Exception {
    return (List<MarcaDto>) _mediator.send(new GetAllMarcaQuery()).data;
  }

  @GetMapping("/{key}")
  public MarcaDto getByKey(@PathVariable GetMarcaByKeyQuery request) throws Exception {
    return (MarcaDto) _mediator.send(request).data;
  }

  @PostMapping("/registro")
  public UUID register(@RequestBody CrearMarcaCommand Marca) throws Exception {
    return (UUID) _mediator.send(Marca).data;
  }

  @PutMapping("/{key}")
  public MarcaDto edit(@PathVariable EditarMarcaCommand request, @RequestBody MarcaDto Marca)
    throws Exception {
    request.marca.nombre = Marca.nombre;
    return (MarcaDto) _mediator.send(request).data;
  }

  @PutMapping("/AddModelo/{key}")
  public UUID addModelo(@RequestBody ModeloDto dto, @PathVariable AddModeloMarcaCommand request)
    throws Exception {
    request.setModelo(dto);
    return (UUID) _mediator.send(request).data;
  }

  @DeleteMapping("/{key}")
  public UUID delete(@PathVariable EliminarMarcaCommand request) throws Exception {
    return (UUID) _mediator.send(request).data;
  }
}
