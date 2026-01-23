# ✅ Creational Design Patterns (Java) — Notes + Examples + Explanations

Creational Design Patterns focus on **how objects are created** in a clean, reusable, and flexible way.

✅ Problems they solve:
- Avoid tight coupling with `new`
- Control object creation
- Improve reusability + maintainability
- Hide complex construction logic

---

# 1) ✅ Singleton Pattern

## 📌 Intent
Ensure **only one instance** of a class exists and provide a **global access point** to it.

## ✅ Real-world meaning
Think of **one shared resource**:
- 1 configuration in whole application
- 1 logger object
- 1 cache object

## ✅ When to use
- Logging
- Configuration Manager
- DB Connection Manager (not real DB connection object, but manager)
- Shared in-memory cache

## ✅ Pros
- Only one instance
- Easy global access
- Saves memory for heavy objects

## ❌ Cons
- Global state (testing becomes harder)
- Not good for dynamic configuration changes
- Reflection/Serialization can break it (if not protected)

---

## ✅ Approach 1: Eager Initialization

### ✅ Code
```java
public class BasicSingleton {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private BasicSingleton() {}
    public static BasicSingleton getInstance() { return INSTANCE; }
}
```

### ✅ Explanation
- Object is created **immediately when the class is loaded**
- JVM loads the class → initializes static fields → creates singleton

### ✅ Benefits
✅ Thread-safe by default (class loading is thread-safe)  
✅ Very simple code

### ❌ Drawbacks
❌ Instance created even if not needed (memory waste)  
❌ Bad for heavy objects at startup  
❌ Can't pass runtime/dynamic constructor values easily

---

## ✅ Approach 2: Bill Pugh Singleton (Best)

### ✅ Code
```java
public class Database {
    private Database(){}

    private static class Holder {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return Holder.INSTANCE;
    }
}
```

### ✅ Explanation
- Outer class loads normally
- Inner static class `Holder` loads only when `getInstance()` is called
- This makes it **lazy initialization**
- JVM guarantees inner class initialization is **thread-safe**

### ✅ Benefits
✅ Thread-safe  
✅ Lazy (created only when needed)  
✅ No `synchronized` (fast)  
✅ No `volatile` required  
✅ Cleanest recommended approach

### ❌ Drawbacks
❌ Still doesn’t support passing dynamic constructor arguments easily  
(need `init()` method or config injection)

---

## ✅ Approach 3: Double Checked Locking (DCL)

### ✅ Code
```java
public class DCLSingleton {
    private static volatile DCLSingleton instance;
    private DCLSingleton(){}

    public static DCLSingleton getInstance() {
        if(instance == null) {                 // First check (no lock)
            synchronized (DCLSingleton.class) {
                if(instance == null) {         // Second check (with lock)
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
```

### ✅ Explanation
Why “double check”?
- First `if(instance==null)` avoids locking after object is created
- `synchronized` ensures only one thread creates instance
- Second check ensures instance was not created by another thread while waiting

Why `volatile`?
- Prevents JVM/CPU reordering
- Ensures threads see a fully constructed object

### ✅ Benefits
✅ Lazy initialization  
✅ Thread-safe  
✅ Very fast after first initialization

### ❌ Drawbacks
❌ More complex code  
❌ Easy to implement wrongly if `volatile` is missing

---

---

# 2) ✅ Factory Method Pattern

## 📌 Intent
Provide a method to create objects, but hide **which class is actually created**.

### ✅ Problem it solves
Instead of writing `new` everywhere:

```java
Payment p = new UpiPayment();
```

You write:

```java
Payment p = PaymentFactory.getPayment("UPI");
```

Now your code is flexible and easy to change.

---

## ✅ When to use
- Multiple implementations exist
- Object type depends on input
- You want to avoid `if-else` object creation all over the app

---

## ✅ Example
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

### ✅ Explanation
- Client doesn’t know which class is created
- Factory handles object creation logic

### ✅ Benefits
✅ Cleaner code  
✅ Easy to add new types (Open/Closed Principle)  
✅ Reduces coupling

### ❌ Drawbacks
❌ Factory class becomes big if too many types  
(then use Abstract Factory or Strategy)

---

---

# 3) ✅ Abstract Factory Pattern

## 📌 Intent
Create **families of related objects** without specifying their concrete classes.

### ✅ Problem it solves
You want matching products together, like:
- Light UI → Light Button + Light Checkbox
- Dark UI → Dark Button + Dark Checkbox

You don't want to mix:
❌ Light Button + Dark Checkbox

---

## ✅ Example
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

### ✅ Explanation
- You choose a factory once (`LightUIFactory` or `DarkUIFactory`)
- That factory creates all related UI components consistently

### ✅ Benefits
✅ Ensures compatibility between related objects  
✅ Cleaner code for large systems  
✅ Supports switching entire family at once

### ❌ Drawbacks
❌ More interfaces/classes (boilerplate)  
❌ Harder if you frequently add new product types

---

---

# 4) ✅ Builder Pattern

## 📌 Intent
Construct complex objects step-by-step.

### ✅ Problem it solves
Constructor with many params becomes unreadable:

```java
new User("Vivek", 25, "India", "Java", "Salesforce", true, false);
```

Hard to maintain ❌

---

## ✅ Example (Builder)
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

### ✅ Explanation
- You build object gradually
- Only set fields you want
- Then `build()` creates final object

### ✅ Benefits
✅ Readable and clean  
✅ Great for optional fields  
✅ Avoids telescoping constructors

### ❌ Drawbacks
❌ More code to write (but Lombok helps: `@Builder`)

---

---

# 5) ✅ Prototype Pattern

## 📌 Intent
Create new objects by copying an existing object (**clone**).

### ✅ Problem it solves
When object creation is expensive and you need many similar objects.

Example:
- Copying game characters
- Copying complex configs
- Copying pre-built objects

---

## ✅ Example
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

### ✅ Explanation
- `clone()` creates a copy quickly
- Avoids repeated initialization cost

### ✅ Benefits
✅ Faster than creating from scratch  
✅ Useful for repetitive object creation

### ❌ Drawbacks
❌ Cloning can be tricky for deep copy  
❌ `Cloneable` is considered outdated by many devs  
(Alternative: copy constructor / serialization / custom copy method)

---

---

# ✅ Quick Interview Cheat Sheet

✅ Singleton → Only one instance  
✅ Factory → Create one type from many choices  
✅ Abstract Factory → Create families of related objects  
✅ Builder → Complex objects with optional params  
✅ Prototype → Clone objects quickly  

---

# ✅ Mini Practice Questions

1. Build a `NotificationFactory` for SMS / EMAIL / WHATSAPP
2. Build a `UIFactory` for Light theme and Dark theme
3. Use Builder for creating `Car` object with 6 optional fields
4. Create a Prototype clone for `GameCharacter` with same powers

✅ End of Creational Design Patterns Notes
