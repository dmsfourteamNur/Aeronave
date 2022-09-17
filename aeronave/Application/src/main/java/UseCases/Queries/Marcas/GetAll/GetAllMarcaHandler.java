package UseCases.Queries.Marcas.GetAll;

import Dto.MarcaDto;
import Dto.ModeloDto;
import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import fourteam.mediator.RequestHandler;
import java.util.ArrayList;
import java.util.List;

public class GetAllMarcaHandler implements RequestHandler<GetAllMarcaQuery, List<MarcaDto>> {

  private IMarcaRepository _marcaRepository;

  public GetAllMarcaHandler(IMarcaRepository marcaRepository) {
    this._marcaRepository = marcaRepository;
  }

  @Override
  public List<MarcaDto> handle(GetAllMarcaQuery request) throws Exception {
    List<MarcaDto> marcas = new ArrayList<>();
    _marcaRepository
      .GetAll()
      .iterator()
      .forEachRemaining(marca -> {
        MarcaDto dto = new MarcaDto(marca.key, marca.nombre);
        List<ModeloDto> modelos = new ArrayList<>();
        marca.modelos
          .iterator()
          .forEachRemaining(modelo -> {
            modelos.add(new ModeloDto(modelo.key, modelo.keyMarca, modelo.nombre));
          });
        dto.setModelos(modelos);
        marcas.add(dto);
      });
    return marcas;
  }
}
