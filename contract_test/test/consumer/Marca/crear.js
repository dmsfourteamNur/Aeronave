import { describe } from 'mocha';
import { expect } from 'chai';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';

import MarcaService from '../../../src/services/MarcaService.js';
import * as Data from '../data.js';

// var pact = require("@pact-foundation/pact-core");

const REQUEST = {
  nombre: Data.Marca.nombre,
};
export default ({ provider }) => {
  describe('crear marca', () => {
    it('retorna un uuid', () => {
      provider
        .given('crear marca')
        .uponReceiving('Los datos de una marca')
        .withRequest({
          method: 'POST',
          path: '/api/marca/registro',
          headers: { 'Content-Type': 'application/json' },
          body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Marca.key),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new MarcaService(mockServer.url);
        return service.registro(REQUEST).then((response) => {
          expect(response).to.be.not.null;
          expect(response).to.be.a.string;
          expect(response).equal(Data.Marca.key);
        });
      });
    });
  });
};
