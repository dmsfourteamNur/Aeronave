package Model.Aeronaves;

import Event.AeronaveChange;
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

  public void eventChange() {
    addDomainEvent(new AeronaveChange(key));
  }

  public void agregarAsiento(Asiento asiento) throws Exception {
    asientos
      .parallelStream()
      .filter(p -> p.numero == asiento.numero)
      .findFirst()
      .ifPresent(p -> {
        throw new RuntimeException("El numero asiento ya existe");
      });
    asientos.add(asiento);
    eventChange();
  }
}
