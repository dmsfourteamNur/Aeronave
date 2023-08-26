package Event;

import Model.Aeronaves.Aeronave;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveChange_Test {

  @Test
  public void ConstructorVoid_accept() {
    Assert.assertNotNull(new AeronaveChange());
  }

  @Test
  public void ConstructorKeyName_accept() {
    Aeronave a = new Aeronave();
    Assert.assertNotNull(new AeronaveChange(a.key));
  }

  @Test
  public void ConstructorGetSet_accept() {
    UUID keyAer = UUID.randomUUID();
    AeronaveChange c = new AeronaveChange(keyAer);
    Assert.assertEquals(c.keyAeronave, keyAer);
  }
}
