import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest( SharedKernel.class )
public class Domain_Test {

  // SharedKernel domain = Mockito.mock(SharedKernel.class);

  @Test
  public void constructor() {
    Assert.assertNotNull(new Domain());
  }

  @Test
  public void adddomain() {
    // PowerMockito.mockStatic(SharedKernel.class);
    // PowerMockito.mockStatic(SharedKernel.class);
    Domain.addDomain();
    Assert.assertTrue(true);
  }
}
