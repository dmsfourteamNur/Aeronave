import { describe } from 'mocha';
import { expect } from 'chai';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';

import AeronaveService from '../../../src/services/AeronaveService.js';
import * as Data from '../data.js';
// var pact = require("@pact-foundation/pact-core");

const REQUEST = {
  matricula: Data.Aeronave.matricula,
};
export default ({ provider }) => {
  describe('editar aeronave', () => {
    it('retorna un objeto aeronave', () => {
      provider
        .given('editar aeronave')
        .uponReceiving('Los datos de una aeronave, y su key por la url')
        .withRequest({
          method: 'PUT',
          path: '/api/aeronave/' + Data.Aeronave.key,
          headers: { 'Content-Type': 'application/json' },
          body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Aeronave),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new AeronaveService(mockServer.url);
        return service.edit(Data.Aeronave).then((response) => {
          // expect(response).to.be.not.null;

          // expect(response).to.be.a.string;
          expect(response.key).equal(Data.Aeronave.key);
        });
      });
    });
  });
};
