package UseCases.Queries.Marcas.GetByKey;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class GetMarcaByKeyQuery_Test {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    GetMarcaByKeyQuery command = new GetMarcaByKeyQuery(key);
    Assert.assertNotNull(command);
  }
}
