export const Marca = {
  key: 'b5be9df1-94d0-4591-97e6-8efb16b1f8dc',
  nombre: 'Boeing',
};
export const Modelo = {
  key: 'a9be9df1-94d0-4591-97e6-8efb16b1f77f',
  keyMarca: Marca.key,
  nombre: '747',
};

export const Aeronave = {
  key: '3e581995-b22a-464e-8ee1-128ee01e843c',
  matricula: 'ABCDEF-1',
  keyModelo: Modelo.key,
  asientos: [],
};
