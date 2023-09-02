import { Verifier } from '@pact-foundation/pact';
import { before, describe, it } from 'mocha';
import path from 'path';
const pactFile = path.resolve(`pacts/react-client-aeronave-service.json`);
let port;
let opts;
describe('Pact Verification', () => {
  before(async () => {
    port = 80;
  });
  it('Valida lo que espera el API del Cliente', () => {
    return new Verifier({
      provider: 'restaurant-service',
      providerBaseUrl: `http://localhost:${port}`,
      logLevel: 'info',
      pactUrls: [pactFile],
    })
      .verifyProvider()
      .then((output) => {
        console.log('Pact Verification Complete!');
        console.log(output);
      })
      .catch((e) => {
        console.error('Pact verification failed :(', e);
      });
  });
});
