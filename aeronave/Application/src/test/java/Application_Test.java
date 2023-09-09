import org.junit.Assert;
import org.junit.Test;

public class Application_Test {

  @Test
  public void constructor() {
    Assert.assertNotNull(new Application());
  }

  @Test
  public void add_application() {
    Application.AddApplication();
  }
}
