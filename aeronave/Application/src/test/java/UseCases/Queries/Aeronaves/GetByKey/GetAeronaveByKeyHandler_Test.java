package UseCases.Queries.Aeronaves.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAeronaveByKeyHandler_Test {

  // IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);

  // IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Test
  public void HandleCorrectly() throws Exception {
    Aeronave a = new Aeronave("ASD", UUID.randomUUID().toString());
    a.agregarAsiento(new Asiento(a.key, 1, "A1"));

    when(aeronaveRepository.FindByKey(any())).thenReturn(a);
    GetAeronaveByKeyHandler handler = new GetAeronaveByKeyHandler(aeronaveRepository);
    GetAeronaveByKeyQuery query = new GetAeronaveByKeyQuery(a.key);
    try {
      Assert.assertEquals(a.key, handler.handle(query).key);
    } catch (Exception e) {
      Assert.fail();
    }
    verify(aeronaveRepository).FindByKey(a.key);
  }

  @Test(expected = HttpException.class)
  public void HandleFail() throws Exception {
    Aeronave a = new Aeronave("ASD", UUID.randomUUID().toString());
    when(aeronaveRepository.FindByKey(any())).thenReturn(null);
    GetAeronaveByKeyHandler handler = new GetAeronaveByKeyHandler(aeronaveRepository);
    GetAeronaveByKeyQuery query = new GetAeronaveByKeyQuery(a.key);
    // try {
    // handler.handle(query);
    // Assert.fail();
    // } catch (HttpException e) {
    // Assert.assertEquals(404, e.getCode());
    // }

    // assert throws exception
    handler.handle(query);
    // Assert.assertThrows(
    // HttpException.class,
    // () -> {
    // }
    // );
  }
}
