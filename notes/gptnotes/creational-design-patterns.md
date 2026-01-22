# ✅ Creational Design Patterns (Java) — Notes + Examples

Creational Design Patterns focus on **how objects are created** in a clean, reusable, and flexible way.

✅ Problems they solve:
- Avoid tight coupling with `new`
- Control object creation
- Improve reusability + maintainability
- Hide complex construction logic

---

## 1) ✅ Singleton Pattern

### 📌 Intent
Ensure **only one instance** of a class exists and provide a **global access point**.

### ✅ When to use
- Logging
- Configuration Manager
- DB Connection Manager
- Cache objects

### ✅ Example 1: Eager Initialization
```java
public class BasicSingleton {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private BasicSingleton() {}
    public static BasicSingleton getInstance() { return INSTANCE; }
}
```
✅ Thread-safe  
❌ Object created even if not used

### ✅ Example 2: Bill Pugh Singleton (Best)
```java
public class Database {
    private Database(){}
    private static class Holder {
        private static final Database INSTANCE = new Database();
    }
    public static Database getInstance() { return Holder.INSTANCE; }
}
```
✅ Thread-safe ✅ Lazy ✅ No synchronized ✅ Clean

### ✅ Example 3: Double Checked Locking
```java
public class DCLSingleton {
    private static volatile DCLSingleton instance;
    private DCLSingleton(){}
    public static DCLSingleton getInstance() {
        if(instance == null) {
            synchronized (DCLSingleton.class) {
                if(instance == null) instance = new DCLSingleton();
            }
        }
        return instance;
    }
}
```
✅ Thread-safe ✅ Lazy ✅ Fast (after init)  
⚠️ Needs `volatile`

---

## 2) ✅ Factory Method Pattern

### 📌 Intent
Create objects without exposing instantiation logic. Subclasses decide what to create.

### ✅ Use case
Different payment methods / notification systems / document generation.

### ✅ Example
```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {
    public void pay() { System.out.println("Paid using UPI"); }
}

class CardPayment implements Payment {
    public void pay() { System.out.println("Paid using Card"); }
}

class PaymentFactory {
    public static Payment getPayment(String type) {
        return switch (type) {
            case "UPI" -> new UpiPayment();
            case "CARD" -> new CardPayment();
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p = PaymentFactory.getPayment("UPI");
        p.pay();
    }
}
```

✅ New payment types can be added easily  
✅ Removes tight coupling from client code

---

## 3) ✅ Abstract Factory Pattern

### 📌 Intent
Create **families of related objects** without specifying their concrete classes.

### ✅ Use case
UI theme factories: `LightButton + LightCheckbox` OR `DarkButton + DarkCheckbox`

### ✅ Example
```java
interface Button { void paint(); }
interface Checkbox { void paint(); }

class LightButton implements Button {
    public void paint(){ System.out.println("Light Button"); }
}
class DarkButton implements Button {
    public void paint(){ System.out.println("Dark Button"); }
}

class LightCheckbox implements Checkbox {
    public void paint(){ System.out.println("Light Checkbox"); }
}
class DarkCheckbox implements Checkbox {
    public void paint(){ System.out.println("Dark Checkbox"); }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class LightUIFactory implements UIFactory {
    public Button createButton(){ return new LightButton(); }
    public Checkbox createCheckbox(){ return new LightCheckbox(); }
}

class DarkUIFactory implements UIFactory {
    public Button createButton(){ return new DarkButton(); }
    public Checkbox createCheckbox(){ return new DarkCheckbox(); }
}

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new DarkUIFactory();
        factory.createButton().paint();
        factory.createCheckbox().paint();
    }
}
```

✅ Ensures related objects match (Dark-Dark / Light-Light)

---

## 4) ✅ Builder Pattern

### 📌 Intent
Build complex objects step-by-step (especially when many optional params exist).

### ✅ Use case
Creating `User`, `Car`, `House`, `HttpRequest`

### ✅ Problem with constructor
```java
new User("Vivek", 25, "India", "Java", "Salesforce", true, false);
```
Hard to understand and maintain ❌

### ✅ Example (Builder)
```java
class User {
    private String name;
    private int age;
    private String city;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    static class UserBuilder {
        private String name;
        private int age;
        private String city;

        public UserBuilder setName(String name){ this.name = name; return this; }
        public UserBuilder setAge(int age){ this.age = age; return this; }
        public UserBuilder setCity(String city){ this.city = city; return this; }

        public User build(){ return new User(this); }
    }
}

public class Main {
    public static void main(String[] args) {
        User u = new User.UserBuilder()
                .setName("Vivek")
                .setAge(25)
                .setCity("Hyderabad")
                .build();
    }
}
```

✅ Clean  
✅ Easy to add optional fields  
✅ Readable code

---

## 5) ✅ Prototype Pattern

### 📌 Intent
Create new objects by **cloning** an existing object instead of creating from scratch.

### ✅ When to use
- Object creation is costly
- You need many similar objects

### ✅ Example
```java
class Employee implements Cloneable {
    String name;
    String role;

    Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vivek", "Developer");
        Employee e2 = e1.clone();

        System.out.println(e1.name + " " + e1.role);
        System.out.println(e2.name + " " + e2.role);
    }
}
```

✅ Fast object creation  
✅ Copies existing state

---

# ✅ Quick Interview Cheat Sheet

✅ Singleton → Only one instance  
✅ Factory → Create one type from many choices  
✅ Abstract Factory → Create families of related objects  
✅ Builder → Complex objects with many optional params  
✅ Prototype → Clone objects quickly  

---

# ✅ Mini Practice Questions

1. Build a `NotificationFactory` for SMS / EMAIL / WHATSAPP
2. Build a `UIFactory` for Light theme and Dark theme
3. Use Builder for creating `Car` object with 6 optional fields
4. Create a Prototype clone for `GameCharacter` with same powers

✅ End of Creational Design Patterns Notes
