package UseCases.Command.Aeronaves.Crear;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
    Aeronave a = new Aeronave(matricula, "");
    when(aeronaveFactory.Create(matricula, "")).thenReturn(a);

    CrearAeronaveHandler handler = new CrearAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      marcaRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = matricula;

    CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);
    UUID resp = handler.handle(command);

    // verify(aeronaveRepository).Create(resp);
    verify(_unitOfWork).commit();

    Assert.assertNotNull(resp);
    // Assert.assertEquals(AeronaveCreado.class, resp.domainEvents.get(0).getClass());
  }
}
