# socket-messenger

A simple Java project demonstrating communication between distributed systems via TCP sockets.

---

## Project Structure

```
socket-messenger/
├── src/
│ └── messenger/
│ ├── Main.java
│ ├── client/
│ │ └── Client.java
│ └── server/
│ └── Server.java
```

## How to Compile

From the root folder of the project, run:

```bash
asdf install &&
javac -d out src/messenger/**/*.java &&
jar cfm socket-messenger.jar manifest.txt -C out . 
```
This compiles the Java sources into the out directory.

## How to Run

Run the program and choose mode via terminal input:
```bash
java -jar socket-messenger.jar
```

You will be prompted to select:
- Type 1 to run the Server.
- Type 2 to run the Client

## Example Usage
1. Open a terminal and start the server:
    ```bash
    java -cp out messenger.Main
    # then input: 1
    ```

2. Open another terminal and start the client:
    ```bash
    java -cp out messenger.Main
    # then input: 2
    ```

3. Chat by typing messages on the client side. The server replies with random predefined messages.

4. To exit the client, type:
    ```bash
    sair
    ```