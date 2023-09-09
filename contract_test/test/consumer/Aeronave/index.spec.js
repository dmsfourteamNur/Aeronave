import { describe } from 'mocha';
import crear from './crear.js';
import { PactV3 } from '@pact-foundation/pact';
import editar from './editar.js';
import _delete from './delete.js';

describe('Aeronave API', () => {
  const provider = new PactV3({
    consumer: 'fourteam',
    provider: 'aeronave',
  });
  crear({ provider: provider });
  editar({ provider: provider });
  _delete({ provider: provider });
});
