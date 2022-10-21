package UseCases.Queries.Aeronaves.GetAll;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllAeronaveHandler_Test {

  // IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
  IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);

  // IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

  @Test
  public void HandleCorrectly() throws Exception {
    Aeronave a = new Aeronave("ASD", UUID.randomUUID().toString());
    List<Aeronave> list = new ArrayList<Aeronave>();
    list.add(a);
    when(aeronaveRepository.GetAll()).thenReturn(list);
    GetAllAeronaveHandler handler = new GetAllAeronaveHandler(aeronaveRepository);
    GetAllAeronaveQuery query = new GetAllAeronaveQuery();
    Assert.assertEquals(list.size(), handler.handle(query).size());
    verify(aeronaveRepository).GetAll();
  }
}
