package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class MarcaCreado extends DomainEvent {

  public UUID keyMarca;
  public String nombre;

  public MarcaCreado() {
    super();
  }

  public MarcaCreado(UUID keyMarca, String nombre) {
    super(LocalDateTime.now());
    this.keyMarca = keyMarca;
    this.nombre = nombre;
  }

  public UUID getKeyMarca() {
    return this.keyMarca;
  }

  public void setKeyMarca(UUID keyMarca) {
    this.keyMarca = keyMarca;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
