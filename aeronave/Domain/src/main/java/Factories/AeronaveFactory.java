package Factories;

import Model.Aeronaves.Aeronave;

public class AeronaveFactory implements IAeronaveFactory {

  public AeronaveFactory() {}

  @Override
  public Aeronave Create(String matricula, String keyModelo) {
    return new Aeronave(matricula, keyModelo);
  }
}
