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
  describe('editar marca', () => {
    it('retorna un objeto marca', () => {
      provider
        .given('editar marca')
        .uponReceiving('Los datos de una marca, y su key por la url')
        .withRequest({
          method: 'PUT',
          path: '/api/marca/' + Data.Marca.key,
          headers: { 'Content-Type': 'application/json' },
          body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Marca),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new MarcaService(mockServer.url);
        return service.edit(Data.Marca).then((response) => {
          // expect(response).to.be.not.null;
          console.log(response);
          // expect(response).to.be.a.string;
          expect(response.key).equal(Data.Marca.key);
        });
      });
    });
  });
};
