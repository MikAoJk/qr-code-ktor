# qr-code-ktor

This project was created using the [Ktor Project Generator](https://start.ktor.io).

## Features

Here's a list of features included in this project:

| Name                                       | Description                       |
|--------------------------------------------|-----------------------------------|
| [Routing](https://start.ktor.io/p/routing) | Provides a structured routing DSL |

## Building & Running

To build or run the project, use one of the following tasks:

| Task                          | Description                                                          |
|-------------------------------|----------------------------------------------------------------------|
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build everything                                                     |
| `buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `buildImage`                  | Build the docker image to use with the fat JAR                       |
| `publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `run`                         | Run the server                                                       |
| `runDocker`                   | Run using the local docker image                                     |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

## Example curl requests
```bash script
curl -X POST http://0.0.0.0:8080/generate-qr \
-H "Content-Type: application/json" \
-d '{"text": "www.google.com"}' \
-o qr-code.png
```

### Upgrading the gradle wrapper
Find the newest version of gradle here: https://gradle.org/releases/ Then run this command:
(Remember to replace $gradleVersjon with the newest version, example: 8.12)
```shell script
./gradlew wrapper --gradle-version $gradleVersjon
```