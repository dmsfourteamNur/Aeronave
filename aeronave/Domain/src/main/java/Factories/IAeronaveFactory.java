package Factories;

import Model.Aeronaves.Aeronave;

public interface IAeronaveFactory {
  public Aeronave Create(String matricula, String keyModelo);
}
