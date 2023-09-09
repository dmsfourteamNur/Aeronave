import fetch from 'node-fetch';

export default class MarcaService {
  constructor(endpoint) {
    this.endpoint = endpoint;
  }

  registro({ nombre }) {
    return fetch(this.endpoint + '/api/marca/registro', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        nombre: nombre,
      }),
    }).then((resp) => resp.json());
  }
  edit({ key, nombre }) {
    return fetch(this.endpoint + '/api/marca/' + key, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        nombre: nombre,
      }),
    }).then((resp) => resp.json());
  }
  addModelo({ keyMarca, nombre }) {
    return fetch(this.endpoint + '/api/marca/AddModelo/' + keyMarca, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        nombre: nombre,
      }),
    }).then((resp) => resp.json());
  }
  delete({ key }) {
    return fetch(this.endpoint + '/api/marca/' + key, {
      method: 'DELETE',
    }).then((resp) => resp.json());
  }
}
