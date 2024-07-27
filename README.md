# ARGUS C# Dotnet Client

This is the official Java library for the [ARGUS Engine](https://github.com/Khelechy/argus), this library helps Java
developers and applications seamlessly integrate to the ARGUS Engine, authentication and event listening.

## Install the package

### Install via Maven

```pom
    
```

### Install via Gradle

```gradle
    
```

### Usage -

```java
import com.github.ogaemma.argus.ArgusClient;
import com.github.ogaemma.argus.core.ArgusTCPServer;
import com.github.ogaemma.argus.exception.ArgusException;
import com.github.ogaemma.argus.model.ArgusConfig;
import com.github.ogaemma.argus.model.ArgusEvent;
import com.github.ogaemma.argus.core.ArgusEventListener;
```

### Using the package

```java
ArgusConfig argusConfig = new ArgusConfig()
        .setHost("127.0.0.1")
        .setPort("1337")
        .setUsername("testuser")
        .setPassword("testpassword");

ArgusTCPServer argusServer = new ArgusTCPServer();

ArgusClient client = new ArgusClient(argusServer, argusConfig);

client.listen(new ArgusEventListener() {
    @Override
    public void onEvent (ArgusEvent argusEvent){
        System.out.println("Received event " + argusEvent.toString());
    }

    @Override
    public void onException (ArgusException exception){
        System.out.println(exception.getMessage());
    }
});

//To close the connection call
// client.close();
```

To stop Argus client from listening, and dispose resources call `client.close()`.

```java
client.close();
```

Note: Argus listens in the background, so it doesnt block the current running thread.