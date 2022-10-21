package UseCases.Queries.Marcas.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllMarcaQuery_Test {

  @Test
  public void dataValid() {
    GetAllMarcaQuery command = new GetAllMarcaQuery();
    Assert.assertNotNull(command);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(GetAllMarcaQuery.class.getConstructors()[0].canAccess(null));
  }
}
