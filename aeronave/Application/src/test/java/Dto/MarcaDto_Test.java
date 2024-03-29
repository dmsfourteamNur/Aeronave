package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class MarcaDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    MarcaDto marca = new MarcaDto();

    Assert.assertEquals(null, marca.key);
    Assert.assertEquals(null, marca.nombre);

    marca.key = key;
    marca.nombre = nombre;

    Assert.assertEquals(key, marca.key);
    Assert.assertEquals(nombre, marca.nombre);
  }

  @Test
  public void CheckGetAndSet() {
    UUID key = UUID.randomUUID();
    String nombre = "Ejecutiva";
    MarcaDto marca = new MarcaDto();
    Assert.assertEquals(null, marca.key);
    Assert.assertEquals(null, marca.nombre);

    marca.setKey(key);
    marca.setNombre(nombre);

    Assert.assertNull(marca.getModelos());
    Assert.assertEquals(key, marca.getKey());
    Assert.assertEquals(nombre, marca.getNombre());
  }
}
