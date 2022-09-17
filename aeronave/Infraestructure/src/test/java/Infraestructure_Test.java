import org.junit.Assert;
import org.junit.Test;

public class Infraestructure_Test {

  @Test
  public void constructor_accept() {
    Infraestructure infraestructure = new Infraestructure();
    Assert.assertNotNull(infraestructure);
  }

  @Test
  public void AddInfraestructure_accept() {
    Infraestructure infraestructure = new Infraestructure();
    infraestructure.AddInfraestructure();
    Assert.assertTrue(true);
  }
}
