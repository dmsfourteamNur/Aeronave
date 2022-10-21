import org.junit.Assert;
import org.junit.Test;

public class Domain_Test {

  @Test
  public void addDomain_accept() {
    Assert.assertNotNull(new Domain());
  }
  @Test
  public void denied() {
    Assert.assertNotNull(null);
  }
}
