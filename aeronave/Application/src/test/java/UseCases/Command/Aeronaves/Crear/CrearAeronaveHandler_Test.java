package UseCases.Command.Aeronaves.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

// @RunWith(PowerMockRunner.class)
public class CrearAeronaveHandler_Test {

  IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
  IMarcaRepository marcaRepository = Mockito.mock(IMarcaRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    String matricula = "ASD";
    String keyModelo = UUID.randomUUID().toString();
    Aeronave a = new Aeronave(matricula, keyModelo);
    when(aeronaveFactory.Create(any(), any())).thenReturn(a);
    Marca m = new Marca("BOEING");

    when(marcaRepository.FindByKeyModelo(any())).thenReturn(m);

    CrearAeronaveHandler handler = new CrearAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      marcaRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = matricula;
    aeronaveDto.keyModelo = matricula;

    CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);
    UUID resp = handler.handle(command);

    // verify(aeronaveRepository).Create(resp);
    verify(_unitOfWork).commit();

    Assert.assertNotNull(resp);
    // Assert.assertEquals(AeronaveCreado.class,
    // resp.domainEvents.get(0).getClass());
  }

  @Test(expected = HttpException.class)
  public void handle_error_existe_matricula() throws Exception {
    when(aeronaveRepository.FindByMatricula(any())).thenReturn(new Aeronave("1A", "1abc"));

    CrearAeronaveHandler handler = new CrearAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      marcaRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = "1A";
    aeronaveDto.keyModelo = "1abc";
    UUID resp = handler.handle(new CrearAeronaveCommand(aeronaveDto));
  }

  @Test(expected = HttpException.class)
  public void handle_error_no_existe_marca() throws Exception {
    CrearAeronaveHandler handler = new CrearAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      marcaRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = "1A";
    aeronaveDto.keyModelo = "1abc";
    UUID resp = handler.handle(new CrearAeronaveCommand(aeronaveDto));
  }
}
