import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class Domain_Test {

  SharedKernel domain = Mockito.mock(SharedKernel.class);

  @Test
  public void constructor() {
    Assert.assertNotNull(new Domain());
  }
  // @Test
  // public void addDomain() {
  //   Domain.addDomain();
  //   Assert.assertTrue(true);
  // }

}
