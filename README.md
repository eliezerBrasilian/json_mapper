# json_mapper

A powerful JSON mapping and manipulation library for Java. Easily convert between JSON structures and Java objects with type validation and data transformation support.

## Installation

You can install the package using Cryxie in two ways:

1. Latest version:

```bash
cryxie install json_mapper
```

2. Specific version:

```bash
cryxie install json_mapper@0.0.1
```

## Usage

First, import the JsonMapper class:

```java
import brasilian.json_mapper.JsonMapper;
```

Here's a practical example of how to use the JsonMapper:

### Basic Model Class

```java
public class MyClass {
    private String game;
    private String movie;

    // Getters and Setters
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
```

### Converting JSON to Java Object

There are two ways to convert JSON to a Java object:

1. Using Class reference:

```java
String json = "{\"game\":\"yu-gi-oh\",\"movie\":\"batman\"}";

MyClass myObj = new JsonMapper<MyClass>()
    .fromJsonToTargetClass(json, MyClass.class);

System.out.println(myObj.getGame()); // Output: yu-gi-oh
```

2. Using TypeReference:

```java
String json = "{\"game\":\"yu-gi-oh\",\"movie\":\"batman\"}";

MyClass myObj = new JsonMapper<MyClass>()
    .fromJsonToTargetClass(json, new TypeReference<>() {});

System.out.println(myObj.getGame()); // Output: yu-gi-oh
```

### Converting Java Object to JSON

```java
// Create and populate the object
MyClass myObj = new MyClass();
myObj.setGame("yu-gi-oh");
myObj.setMovie("batman");

// Convert to JSON
String json = new JsonMapper<>(myObj).toJson();
System.out.println(json);
// Output: {"game":"yu-gi-oh","movie":"batman"}
```

## Features

- Convert JSON strings to Java objects
- Convert Java objects to JSON strings
- Type validation
- Nested object support
- Array handling
- Error handling for invalid JSON
- Support for Java collections (List, Map, etc.)
- Custom type converters

## License

This project is licensed under the MIT License.
