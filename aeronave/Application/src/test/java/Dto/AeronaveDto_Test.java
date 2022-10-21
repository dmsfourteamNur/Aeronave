package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveDto_Test {

  @Test
  public void CheckPropertiesValid() {
    UUID key = UUID.randomUUID();
    String matricula = "A12345";
    List<AsientoDto> asientos = getAsientos();
    AeronaveDto aeronave = new AeronaveDto();

    Assert.assertEquals(null, aeronave.key);
    Assert.assertNull(aeronave.matricula);
    Assert.assertNotNull(aeronave.asientos);
    Assert.assertEquals(0, aeronave.asientos.size());
    aeronave.setKey(key);
    aeronave.setMatricula(matricula);
    aeronave.setAsientos(asientos);
    Assert.assertEquals(key, aeronave.getKey());
    Assert.assertEquals(matricula, aeronave.getMatricula());
    Assert.assertEquals(asientos, aeronave.getAsientos());
  }

  private List<AsientoDto> getAsientos() {
    return new ArrayList();
  }
}
