package Model.Marcas;

import org.junit.Assert;
import org.junit.Test;

public class Marca_Test {

  @Test
  public void constructor() {
    Assert.assertNotNull(new Marca("BOEING"));
  }

  @Test
  public void eventoCreado() {
    Marca m = new Marca("BOEING");
    m.eventCreado();
    Assert.assertEquals(m.domainEvents.size(), 1);
  }

  @Test
  public void agregarModelo() {
    Marca m = new Marca("BOEING");
    m.agregarModelo(new Modelo(m.key, "747"));
    Assert.assertEquals(m.modelos.size(), 1);
  }
}
