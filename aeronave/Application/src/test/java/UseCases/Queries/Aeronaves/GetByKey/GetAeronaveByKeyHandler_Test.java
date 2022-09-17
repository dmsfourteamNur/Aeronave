package UseCases.Queries.Aeronaves.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;
import fourteam.http.Exception.HttpException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAeronaveByKeyHandler_Test {

  // IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);

  // IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Test
  public void HandleCorrectly() throws Exception {
    Aeronave a = new Aeronave("ASD", "");
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

  @Test
  public void HandleFail() throws Exception {
    Aeronave a = new Aeronave("ASD", "");
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
    Assert.assertThrows(
      HttpException.class,
      () -> {
        handler.handle(query);
      }
    );
  }
}
