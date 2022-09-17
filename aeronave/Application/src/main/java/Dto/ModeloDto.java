package Dto;

import java.util.UUID;

public class ModeloDto {

  public UUID key;
  public String nombre;
  public UUID keyMarca;

  public ModeloDto() {}

  public ModeloDto(UUID key, UUID keyMarca, String nombre) {
    this.key = key;
    this.nombre = nombre;
    this.keyMarca = keyMarca;
  }
}
