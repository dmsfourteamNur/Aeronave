package Dto;

import java.util.List;
import java.util.UUID;

public class MarcaDto {

  public UUID key;
  public String nombre;
  public List<ModeloDto> modelos;

  public MarcaDto() {}

  public MarcaDto(UUID key, String nombre) {
    this.key = key;
    this.nombre = nombre;
  }

  public UUID getKey() {
    return this.key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<ModeloDto> getModelos() {
    return modelos;
  }

  public void setModelos(List<ModeloDto> modelos) {
    this.modelos = modelos;
  }
}
