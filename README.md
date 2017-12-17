# RabbitMQ Message Queue Example

A basic demonstration of using RabbitMQ as a Producer-Consumer messaging queue.

## Setup

1. Install via Homebrew

```
brew install rabbitmq
```

2. Start using Brew Services

```
brew services start rabbitmq
```

3. Clone this Repository

```
git clone https://github.com/damiannolan/rabbitmq-producer-consumer.git
```

4. Run Maven Install

```
mvn install
```

5. Run the Producer and Consumer side by side

```
java -cp target/rabbitmq-producer-consumer-0.0.1-SNAPSHOT-jar-with-dependencies.jar main/Recieve
```

```
java -cp target/rabbitmq-producer-consumer-0.0.1-SNAPSHOT-jar-with-dependencies.jar main/Send
```