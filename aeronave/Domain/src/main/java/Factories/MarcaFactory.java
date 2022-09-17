package Factories;

import Model.Marcas.Marca;

public class MarcaFactory implements IMarcaFactory {

  public MarcaFactory() {}

  @Override
  public Marca Create(String nombre) {
    return new Marca(nombre);
  }
}
