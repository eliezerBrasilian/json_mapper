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

Here's a practical example of how to use the JsonMapper:

```java
import brasilean.json_mapper.App.JsonMapper;

// Example 1: Basic JSON to Java object mapping
String jsonString = """
{
    "name": "John Doe",
    "age": 30,
    "address": {
        "street": "123 Main St",
        "city": "New York"
    }
}
""";

JsonMapper mapper = new JsonMapper();
Person person = mapper.fromJson(jsonString, Person.class);

// Access the mapped data
System.out.println(person.getName()); // Output: John Doe
System.out.println(person.getAge()); // Output: 30
System.out.println(person.getAddress().getStreet()); // Output: 123 Main St

// Example 2: Java object to JSON
User user = new User();
user.setName("Jane Smith");
user.setEmail("jane@example.com");

Preferences preferences = new Preferences();
preferences.setTheme("dark");
preferences.setNotifications(true);
user.setPreferences(preferences);

String jsonOutput = mapper.toJson(user);
System.out.println(jsonOutput);
```

### Required Model Classes

```java
// Person.java
public class Person {
    private String name;
    private int age;
    private Address address;

    // Getters and setters
}

// Address.java
public class Address {
    private String street;
    private String city;

    // Getters and setters
}

// User.java
public class User {
    private String name;
    private String email;
    private Preferences preferences;

    // Getters and setters
}

// Preferences.java
public class Preferences {
    private String theme;
    private boolean notifications;

    // Getters and setters
}
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
