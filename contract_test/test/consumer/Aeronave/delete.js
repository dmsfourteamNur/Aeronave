import { describe } from 'mocha';
import { expect } from 'chai';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';

import AeronaveService from '../../../src/services/AeronaveService.js';
import * as Data from '../data.js';

// var pact = require("@pact-foundation/pact-core");

const REQUEST = {
  nombre: Data.Aeronave.nombre,
};
export default ({ provider }) => {
  describe('delete aeronave', () => {
    it('retorna un objeto aeronave', () => {
      provider
        .given('delete aeronave')
        .uponReceiving('La key de una aeronave')
        .withRequest({
          method: 'DELETE',
          path: '/api/aeronave/' + Data.Aeronave.key,
          // headers: { 'Content-Type': 'application/json', },
          // body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Aeronave.key),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new AeronaveService(mockServer.url);
        return service.delete({ key: Data.Aeronave.key }).then((response) => {
          // expect(response).to.be.not.null;
          console.log(response);
          // expect(response).to.be.a.string;
          expect(response).equal(Data.Aeronave.key);
        });
      });
    });
  });
};
