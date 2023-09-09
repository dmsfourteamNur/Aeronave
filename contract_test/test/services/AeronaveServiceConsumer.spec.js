import { describe } from 'mocha';
import { expect } from 'chai';
import AeronaveService from '../../src/services/AeronaveService.js';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';
// var pact = require("@pact-foundation/pact-core");
const { like } = MatchersV3;

const ResponseExpet = 'b6a5e05b-e208-4b43-b02f-783563d2ff18';
const RequestExpet = {
  matricula: 'ABCD',
  keyModelo: 'de4b96bb-2409-4fcd-9e42-beb5f79e20a7',
};

describe('El API de aeronaves', () => {
  const provider = new PactV3({
    consumer: 'react-client',
    provider: 'aeronave-service',
  });

  describe('crear aeronave', () => {
    it('retorna un uuid de la aeronave ya creada', () => {
      //Arrange
      provider
        .given('crear aeronave')
        .uponReceiving('una matricula y un keyModelo para crear una aeronave')
        .withRequest({
          method: 'POST',
          path: '/api/aeronave/registro',
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
        const service = new AeronaveService(mockServer.url);
        return service.registro(RequestExpet).then((response) => {
          expect(response).to.be.not.null;
          expect(response).to.be.a.string;
          expect(response).equal(ResponseExpet);
        });
      });
    });
  });
});
