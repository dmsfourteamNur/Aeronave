package Factories;

import org.junit.Assert;
import org.junit.Test;

public class MarcaFactory_Test {

  @Test
  public void constructor_accept() {
    Assert.assertNotNull(new MarcaFactory());
  }

  @Test
  public void create_accept() {
    Assert.assertNotNull(new MarcaFactory().Create("ASD"));
  }
}
