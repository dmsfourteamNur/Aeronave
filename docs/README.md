# DMSNUR - Aeronave

## Ricardo Paz demiquel

#

Creamos el proyecto base

```bash
mvn archetype:generate -DgroupId=dmsnur -DartifactId=aeronave
```

Creamos los modulos

```bash
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Domain
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Application
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Infraestructure
mvn archetype:generate -DgroupId=dmsnur -DartifactId=SharedKernel
mvn archetype:generate -DgroupId=dmsnur -DartifactId=WebApi
```
