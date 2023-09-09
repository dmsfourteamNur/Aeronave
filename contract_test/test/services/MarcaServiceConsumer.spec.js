import { describe } from 'mocha';
import { expect } from 'chai';
import MarcaService from '../../src/services/MarcaService.js';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';
// var pact = require("@pact-foundation/pact-core");
const { like } = MatchersV3;

const ResponseExpet = '52cf456a-ebc2-4339-8f5e-d9d6a8dbdc1f';
const RequestExpet = {
  nombre: 'Boegin',
};

const CrearMarca = (provider) => {
  describe('crear marca', () => {
    it('retorna un id de marca ya creada', () => {
      provider
        .given('crear marca')
        .uponReceiving('un nombre para crear una marca')
        .withRequest({
          method: 'POST',
          path: '/api/marca/registro',
          headers: {
            'Content-Type': 'application/json',
          },
          body: RequestExpet,
        })
        .willRespondWith({
          status: 200,
          body: like(ResponseExpet),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const transaccionService = new MarcaService(mockServer.url);
        return transaccionService.registro(RequestExpet).then((response) => {
          expect(response).to.be.not.null;
          expect(response).to.be.a.string;
          expect(response).equal(ResponseExpet);
        });
      });
    });
  });
};

describe('El API de marcas', () => {
  const provider = new PactV3({
    consumer: 'react-client',
    provider: 'marca-service',
  });
  CrearMarca(provider);
});
