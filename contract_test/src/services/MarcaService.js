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
}
