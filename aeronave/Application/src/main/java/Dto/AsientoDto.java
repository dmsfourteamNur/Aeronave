package Dto;

import java.util.UUID;

import Model.Aeronaves.Asiento;

public class AsientoDto {

  public UUID key;
  public UUID keyAeronave;
  public int numero;
  public String clase;

  public AsientoDto() {}

  public AsientoDto(Asiento asiento) {
    this.key = asiento.key;
    this.numero = asiento.numero;
    this.clase = asiento.clase;
  }
  public AsientoDto(UUID key, int numero, String clase) {
    this.key = key;
    this.numero = numero;
    this.clase = clase;
  }

  public UUID getKey() {
      return key;
  }
  public void setKey(UUID key) {
      this.key = key;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getClase() {
    return this.clase;
  }

  public void setClase(String clase) {
    this.clase = clase;
  }
}
