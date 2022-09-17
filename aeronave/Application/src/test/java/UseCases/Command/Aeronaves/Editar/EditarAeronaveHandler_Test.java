package UseCases.Command.Aeronaves.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.AeronaveDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditarAeronaveHandler_Test {

  IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    String matricula = "ASD";
    Aeronave a = new Aeronave(matricula, "");
    when(aeronaveRepository.FindByKey(any())).thenReturn(a);

    EditarAeronaveHandler handler = new EditarAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = matricula;
    aeronaveDto.key = a.key;

    EditarAeronaveCommand command = new EditarAeronaveCommand(aeronaveDto.key);
    command.aeronave.matricula = matricula;
    Aeronave resp = handler.handle(command);
    Assert.assertEquals(matricula, resp.matricula);
  }

  @Test
  public void HandleFailed() throws Exception {
    when(aeronaveRepository.FindByKey(any())).thenReturn(null);

    EditarAeronaveHandler handler = new EditarAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = "ABC";
    aeronaveDto.key = UUID.randomUUID();

    EditarAeronaveCommand command = new EditarAeronaveCommand(aeronaveDto.key);
    try {
      Aeronave resp = handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
