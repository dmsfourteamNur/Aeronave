package Model.Marcas;

import Event.MarcaCreado;
import core.AggregateRoot;
import core.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Marca extends AggregateRoot<UUID> {

  public String nombre;
  public List<Modelo> modelos;

  public Marca(String nombre) {
    key = UUID.randomUUID();
    this.nombre = nombre;
    modelos = new ArrayList<Modelo>();
  }

  public void eventCreado() {
    addDomainEvent(new MarcaCreado(key, nombre));
  }

  public void agregarModelo(Modelo modelo) {
    // modelos
    // .parallelStream()
    // .filter(p -> p.getKey() == asiento.getKey())
    // .findFirst()
    // .ifPresent(p -> {
    // throw new RuntimeException("El asiento ya existe");
    // });
    modelos.add(modelo);
  }
}
