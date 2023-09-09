import fetch from 'node-fetch';

export default class MarcaService {
  constructor(endpoint) {
    this.endpoint = endpoint;
  }

  registro({ matricula, keyModelo }) {
    return fetch(this.endpoint + '/api/aeronave/registro', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        matricula: matricula,
        keyModelo: keyModelo,
      }),
    }).then((resp) => resp.json());
  }
  edit({ key, matricula }) {
    return fetch(this.endpoint + '/api/aeronave/' + key, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        matricula: matricula,
      }),
    }).then((resp) => resp.json());
  }

  delete({ key }) {
    return fetch(this.endpoint + '/api/aeronave/' + key, {
      method: 'DELETE',
    }).then((resp) => resp.json());
  }
}
