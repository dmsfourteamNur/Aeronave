package Event;

import Model.Aeronaves.Aeronave;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveCreado_Test {

  @Test
  public void ConstructorVoid_accept() {
    Assert.assertNotNull(new AeronaveCreado());
  }

  @Test
  public void ConstructorKeyName_accept() {
    Aeronave a = new Aeronave();
    Assert.assertNotNull(new AeronaveCreado(a.key, a.matricula));
  }

  @Test
  public void ConstructorGetSet_accept() {
    Aeronave a = new Aeronave("MAD", "");
    AeronaveCreado c = new AeronaveCreado();
    c.setKeyAeronave(a.key);
    c.setMatricula(a.matricula);
    Assert.assertEquals(a.key, c.getKeyAeronave());
    Assert.assertEquals(a.matricula, c.getMatricula());
  }
}
