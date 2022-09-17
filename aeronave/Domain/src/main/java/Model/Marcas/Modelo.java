package Model.Marcas;

import core.Entity;
import java.util.UUID;

public class Modelo extends Entity<UUID> {

  public UUID keyMarca;
  public String nombre;

  public Modelo(UUID keyMarca, String nombre) {
    key = UUID.randomUUID();
    this.keyMarca = keyMarca;
    this.nombre = nombre;
  }
}
