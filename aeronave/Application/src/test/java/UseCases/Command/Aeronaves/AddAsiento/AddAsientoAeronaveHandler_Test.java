package UseCases.Command.Aeronaves.AddAsiento;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

// @RunWith(PowerMockRunner.class)
public class AddAsientoAeronaveHandler_Test {

  IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    String matricula = "ASD";
    String keyModelo = UUID.randomUUID().toString();
    Aeronave a = new Aeronave(matricula, keyModelo);
    when(aeronaveRepository.FindByKey(any())).thenReturn(a);
    Marca m = new Marca("BOEING");

    AddAsientoAeronaveHandler handler = new AddAsientoAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AsientoDto asientoDto = new AsientoDto(UUID.randomUUID(), 1, "clase");
    AddAsientoAeronaveCommand addAsientoAeronaveCommand = new AddAsientoAeronaveCommand(
      UUID.randomUUID()
    );
    addAsientoAeronaveCommand.setAsiento(asientoDto);
    UUID resp = handler.handle(addAsientoAeronaveCommand);
    verify(_unitOfWork).commit();
    Assert.assertNotNull(resp);
  }

  @Test(expected = HttpException.class)
  public void handle_error_existe_matricula() throws Exception {
    AddAsientoAeronaveHandler handler = new AddAsientoAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = "1A";
    aeronaveDto.keyModelo = "1abc";
    AsientoDto asientoDto = new AsientoDto(UUID.randomUUID(), 1, "clase");
    AddAsientoAeronaveCommand addAsientoAeronaveCommand = new AddAsientoAeronaveCommand(
      UUID.randomUUID()
    );
    addAsientoAeronaveCommand.setAsiento(asientoDto);
    UUID resp = handler.handle(addAsientoAeronaveCommand);
  }
}
