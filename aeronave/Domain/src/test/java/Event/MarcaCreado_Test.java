package Event;

import Model.Marcas.Marca;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class MarcaCreado_Test {

  @Test
  public void ConstructorVoid() {
    Assert.assertNotNull(new MarcaCreado());
  }

  @Test
  public void get_set() {
    String nombre = "BOEING";
    MarcaCreado mc = new MarcaCreado();
    UUID keyMarca = UUID.randomUUID();
    mc.setKeyMarca(keyMarca);
    mc.setNombre(nombre);
    Assert.assertNotNull(mc);
    Assert.assertEquals(mc.getNombre(), nombre);
    Assert.assertEquals(mc.getKeyMarca(), keyMarca);
  }

  @Test
  public void Constructor() {
    Marca a = new Marca("BOEGIN");
    Assert.assertNotNull(a);
  }
}
