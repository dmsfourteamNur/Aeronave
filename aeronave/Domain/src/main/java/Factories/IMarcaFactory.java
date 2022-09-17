package Factories;

import Model.Marcas.Marca;

public interface IMarcaFactory {
  public Marca Create(String nombre);
}
