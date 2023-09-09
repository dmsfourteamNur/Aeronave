import { describe } from 'mocha';
import { expect } from 'chai';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';

import AeronaveService from '../../../src/services/AeronaveService.js';
import * as Data from '../data.js';
// var pact = require("@pact-foundation/pact-core");

const REQUEST = {
  matricula: Data.Aeronave.matricula,
  keyModelo: Data.Aeronave.keyModelo,
};
export default ({ provider }) => {
  describe('crear aeronave', () => {
    it('retorna un uuid', () => {
      provider
        .given('crear aeronave')
        .uponReceiving('Los datos de una aeronave')
        .withRequest({
          method: 'POST',
          path: '/api/aeronave/registro',
          headers: { 'Content-Type': 'application/json' },
          body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Aeronave.key),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new AeronaveService(mockServer.url);
        return service.registro(REQUEST).then((response) => {
          expect(response).to.be.not.null;
          expect(response).to.be.a.string;
          expect(response).equal(Data.Aeronave.key);
        });
      });
    });
  });
};
