package Dto;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AsientoDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    UUID keyAeronave = UUID.randomUUID();
    int numero = 1;
    String clase = "Ejecutiva";
    AsientoDto asiento = new AsientoDto();

    Assert.assertEquals(null, asiento.keyAeronave);
    Assert.assertEquals(0, asiento.numero);
    Assert.assertEquals(null, asiento.clase);

    asiento.key = key;
    asiento.setKeyAeronave(keyAeronave);
    asiento.setNumero(numero);
    asiento.setClase(clase);

    Assert.assertEquals(key, asiento.key);
    Assert.assertEquals(keyAeronave, asiento.getKeyAeronave());
    Assert.assertEquals(numero, asiento.getNumero());
    Assert.assertEquals(clase, asiento.getClase());
  }

  @Test
  public void CheckConstructor() {
    UUID key = UUID.randomUUID();
    UUID keyAeronave = UUID.randomUUID();
    int numero = 1;
    String clase = "Ejecutiva";
    AsientoDto asiento = new AsientoDto(keyAeronave, numero, clase);

    asiento.key = key;

    Assert.assertEquals(key, asiento.key);
    Assert.assertEquals(keyAeronave, asiento.getKeyAeronave());
    Assert.assertEquals(numero, asiento.getNumero());
    Assert.assertEquals(clase, asiento.getClase());
  }
}
