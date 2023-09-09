import { describe } from 'mocha';
import crear from './crear.js';
import { PactV3 } from '@pact-foundation/pact';
import editar from './editar.js';
import _delete from './delete.js';
import addModelo from './addModelo.js';

describe('Marca API', () => {
  const provider = new PactV3({
    consumer: 'fourteam',
    provider: 'marca',
  });
  crear({ provider: provider });
  editar({ provider: provider });
  _delete({ provider: provider });
  addModelo({ provider: provider });
});
