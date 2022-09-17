package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AeronaveDto {

  public UUID key;
  public String matricula;
  public String keyModelo;
  public List<AsientoDto> asientos;

  public AeronaveDto() {
    asientos = new ArrayList<>();
  }

  public void setKey(UUID key) {
    this.key = key;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public UUID getKey() {
    return key;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setAsientos(List<AsientoDto> asientos) {
    this.asientos = asientos;
  }

  public List<AsientoDto> getAsientos() {
    return asientos;
  }

  public String getKeyModelo() {
    return keyModelo;
  }

  public void setKeyModelo(String keyModelo) {
    this.keyModelo = keyModelo;
  }
}
