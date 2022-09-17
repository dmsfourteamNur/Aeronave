package UseCases.Command.Aeronaves.Eliminar;

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

public class EliminarAeronaveHandler_Test {

  IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Before
  public void setUp() {}

  @Test
  public void HandleCorrectly() throws Exception {
    UUID key = UUID.randomUUID();
    String matricula = "ASD";
    Aeronave a = new Aeronave(matricula, "");
    a.key = key;

    when(aeronaveRepository.FindByKey(any())).thenReturn(a);
    when(aeronaveRepository.Delete(any())).thenReturn(a);

    EliminarAeronaveHandler handler = new EliminarAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = matricula;
    aeronaveDto.setKey(key);
    EliminarAeronaveCommand command = new EliminarAeronaveCommand(aeronaveDto.getKey());
    UUID resp = handler.handle(command);
    Assert.assertEquals(a.key, resp);
  }

  @Test
  public void HandleFailed() throws Exception {
    when(aeronaveRepository.FindByKey(any())).thenReturn(null);

    EliminarAeronaveHandler handler = new EliminarAeronaveHandler(
      aeronaveFactory,
      aeronaveRepository,
      _unitOfWork
    );

    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.matricula = "ABC";

    EliminarAeronaveCommand command = new EliminarAeronaveCommand(aeronaveDto.key);
    try {
      UUID resp = handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }
}
