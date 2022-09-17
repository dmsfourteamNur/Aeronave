package Model.Aeronaves;

import Event.AeronaveCreado;
import Model.Aeronaves.ValueObjects.MatriculaAeronave;
import Model.Aeronaves.ValueObjects.ModeloAeronave;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Aeronave extends AggregateRoot<UUID> {

  public String matricula;
  public String keyModelo;
  public List<Asiento> asientos;

  public Aeronave() {}

  public Aeronave(String matricula, String keyModelo) {
    key = UUID.randomUUID();
    try {
      this.matricula = new MatriculaAeronave(matricula).toString();
      this.keyModelo = new ModeloAeronave(keyModelo).toString();
    } catch (BussinessRuleValidateExeption e) {
      e.printStackTrace();
      return;
    }
    asientos = new ArrayList<Asiento>();
  }

  public void eventCreado() {
    addDomainEvent(new AeronaveCreado(key, matricula));
  }

  public void agregarAsiento(Asiento asiento) {
    asientos
      .parallelStream()
      .filter(p -> p.getKey() == asiento.getKey())
      .findFirst()
      .ifPresent(p -> {
        throw new RuntimeException("El asiento ya existe");
      });
    asientos.add(asiento);
  }
}
