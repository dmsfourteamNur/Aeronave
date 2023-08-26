package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class ModeloDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    UUID keyMarca = UUID.randomUUID();
    String nombre = "747";

    ModeloDto modelo = new ModeloDto();
    Assert.assertEquals(null, modelo.key);
    Assert.assertEquals(null, modelo.nombre);
    Assert.assertEquals(null, modelo.keyMarca);

    modelo.key = key;
    modelo.keyMarca = keyMarca;
    modelo.nombre = nombre;

    Assert.assertEquals(key, modelo.key);
    Assert.assertEquals(nombre, modelo.nombre);
    Assert.assertEquals(keyMarca, modelo.keyMarca);
  }

  @Test
  public void CheckConstructor() {
    UUID key = UUID.randomUUID();
    UUID keyMarca = UUID.randomUUID();
    String nombre = "747";

    ModeloDto modelo = new ModeloDto(key, keyMarca, nombre);

    Assert.assertEquals(key, modelo.key);
    Assert.assertEquals(nombre, modelo.nombre);
    Assert.assertEquals(keyMarca, modelo.keyMarca);
  }
}
