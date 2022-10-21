package UseCases.Queries.Aeronaves.GetByKey;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class GetAeronaveByKeyQuery_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    GetAeronaveByKeyQuery command = new GetAeronaveByKeyQuery(key);
    Assert.assertNotNull(command);
  }
}
