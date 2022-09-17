package Factories;

import org.junit.Assert;
import org.junit.Test;

public class AeronaveFactory_Test {

  @Test
  public void constructor_accept() {
    Assert.assertNotNull(new AeronaveFactory());
  }

  @Test
  public void create_accept() {
    Assert.assertNotNull(new AeronaveFactory().Create("ASD", ""));
  }
}
