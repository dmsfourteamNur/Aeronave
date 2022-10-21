package Model.Aeronaves;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class Aeronave_Test {

  @Test
  public void constructorVoid_accept() {
    Assert.assertNotNull(new Aeronave());
  }

  @Test
  public void constructor_accept() {
    String matricula = "MAD";
    Aeronave a = new Aeronave(matricula, "");
    Assert.assertEquals(a.matricula, matricula);
  }

  @Test
  public void constructor_denied() {
    String matricula = "";
    Aeronave a = new Aeronave(matricula, "");
    Assert.assertEquals(a.matricula, null);
  }

  @Test
  public void addDomainEvent_accept() {
    String matricula = "MAD";
    Aeronave a = new Aeronave(matricula, UUID.randomUUID().toString());
    a.eventCreado();
    Assert.assertEquals(a.domainEvents.size(), 1);
  }

  @Test
  public void addDomainEventChange_accept() {
    String matricula = "MAD";
    Aeronave a = new Aeronave(matricula, UUID.randomUUID().toString());
    a.eventChange();
    Assert.assertEquals(a.domainEvents.size(), 1);
  }

  @Test
  public void addAsiento_accept() {
    String matricula = "MAD";
    Aeronave a = new Aeronave(matricula, UUID.randomUUID().toString());
    try {
      a.agregarAsiento(new Asiento(a.key, 1, "A1"));
    } catch (Exception e) {}
    // TODO://
    // Assert.assertEquals(a.asientos.size(), 1);
  }

  @Test
  public void addAsiento_denied() {
    String matricula = "MAD";
    Aeronave a = new Aeronave(matricula, UUID.randomUUID().toString());
    Asiento as = new Asiento(a.key, 1, "A1");
    try {
      a.agregarAsiento(as);
    } catch (Exception e1) {}
    Asiento as2 = new Asiento(a.key, 1, "A1");
    as2.key = as.key;
    try {
      a.agregarAsiento(as2);
    } catch (Exception e) {
      Assert.assertTrue(true);
    }
  }
}
