### Histoire d'envoi de message
Middleware pour gérer/tester les messages


# Middleware
Projet Java implémentant Apache Camel
Initialisation du projet avec Spring initializer.

```
cd middleware
mvn spring-boot:run
```
## Walkthrough
### Timer
Le composant [timer](https://camel.apache.org/components/latest/timer-component.html) Permet de lancer camel par tranche de temps

```java
    from("timer:my-first?period=3s")
        ...
        .log(LoggingLevel.INFO, "middle-logger", "${body}")
```

### REST Consumer
Le composant [http](https://camel.apache.org/components/latest/http-component.html) permet de faire celà. Faire un appel API à chaque minute
```java
     from("timer:launcher?period=60s")
        .to("http://jsonplaceholder.typicode.com/users/1")
        .log(LoggingLevel.INFO, "my-logger", "${body}");
```

### REST Provider

### File