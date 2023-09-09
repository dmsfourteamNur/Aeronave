import { describe } from 'mocha';
import { expect } from 'chai';
import { PactV3, MatchersV3, Interaction, Verifier } from '@pact-foundation/pact';

import MarcaService from '../../../src/services/MarcaService.js';
import * as Data from '../data.js';

const REQUEST = {
  nombre: Data.Modelo.nombre,
};
export default ({ provider }) => {
  describe('agregar modelo', () => {
    it('retorna un uuid', () => {
      provider
        .given('agregar marca')
        .uponReceiving('Los datos de un modelo y la key de una marca')
        .withRequest({
          method: 'PUT',
          path: '/api/marca/AddModelo/' + Data.Marca.key,
          headers: { 'Content-Type': 'application/json' },
          body: REQUEST,
        })
        .willRespondWith({
          status: 200,
          body: MatchersV3.like(Data.Modelo.key),
        });
      return provider.executeTest(async (mockServer) => {
        // Act
        const service = new MarcaService(mockServer.url);
        return service
          .addModelo({
            keyMarca: Data.Marca.key,
            nombre: REQUEST.nombre,
          })
          .then((response) => {
            expect(response).to.be.not.null;
            expect(response).to.be.a.string;
            expect(response).equal(Data.Modelo.key);
          });
      });
    });
  });
};
