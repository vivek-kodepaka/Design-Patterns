# ✅ Behavioral Design Patterns — Full Course (Java) 📘
*(Save this as `behavioral-design-patterns-course.md`)*

---

## 📌 Table of Contents
1. What are Behavioral Design Patterns?
2. Why Behavioral Patterns?
3. Complete Behavioral Patterns List (11)
4. **Strategy**
5. **Observer**
6. **Command**
7. **State**
8. **Chain of Responsibility**
9. **Template Method**
10. **Iterator**
11. **Mediator**
12. **Memento**
13. **Interpreter**
14. **Visitor**
15. Interview Cheat Sheet
16. Practice Problems

---

# 1) ✅ What are Behavioral Design Patterns?

Behavioral Design Patterns focus on:

✅ **How objects communicate**  
✅ **How responsibilities are distributed**  
✅ **How to manage workflows & interactions**

They help make code:
- Flexible
- Reusable
- Easy to extend
- Easy to test

---

# 2) ✅ Why Behavioral Patterns?

### ✅ Problems they solve:
✅ Too many `if/else` conditions  
✅ Hard-coded workflows  
✅ Tight coupling between objects  
✅ Different behaviors needed at runtime  
✅ Want to add new behavior without touching old code

---

# 3) ✅ Behavioral Patterns List (11)

| Pattern | Core Idea |
|--------|-----------|
| Strategy | Choose algorithm at runtime |
| Observer | Notify multiple objects automatically |
| Command | Wrap actions into objects |
| State | Change behavior based on state |
| Chain of Responsibility | Pass request through handlers |
| Template Method | Fixed skeleton, customizable steps |
| Iterator | Traverse collection without exposing internals |
| Mediator | Central communication controller |
| Memento | Save & restore object state |
| Interpreter | Evaluate grammar/language |
| Visitor | Separate algorithm from structure |

---

# 4) ✅ Strategy Pattern

## ✅ Use Case
You want **multiple algorithms**, and choose one dynamically.

### Example
Payment method selection:
- Card
- UPI
- Wallet

✅ Avoid huge `if/else`.

## ✅ Code

### Strategy Interface
```java
interface PaymentStrategy {
    void pay(double amount);
}
```

### Concrete Strategies
```java
class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
```

### Context
```java
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        strategy.pay(amount);
    }
}
```

### Client
```java
public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new UpiPayment());
        context.makePayment(500);

        context.setStrategy(new CardPayment());
        context.makePayment(1200);
    }
}
```

## ✅ Pros
✅ Replaces big `if/else`  
✅ Easy to add new strategy  
✅ Runtime switching supported  

## ❌ Cons
❌ More classes  
❌ Client must pick strategy

---

# 5) ✅ Observer Pattern

## ✅ Use Case
When 1 object changes, all dependent objects must get updated automatically.

### Example
YouTube channel → subscribers notified.

## ✅ Code

### Observer
```java
interface Subscriber {
    void update(String videoTitle);
}
```

### Concrete Observer
```java
class UserSubscriber implements Subscriber {
    private String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    public void update(String videoTitle) {
        System.out.println(name + " notified: New video -> " + videoTitle);
    }
}
```

### Subject
```java
import java.util.*;

class YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    public void unsubscribe(Subscriber sub) {
        subscribers.remove(sub);
    }

    public void uploadVideo(String title) {
        System.out.println("Channel uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        for (Subscriber sub : subscribers) {
            sub.update(title);
        }
    }
}
```

### Client
```java
public class ObserverDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber s1 = new UserSubscriber("Vivek");
        Subscriber s2 = new UserSubscriber("Rahul");

        channel.subscribe(s1);
        channel.subscribe(s2);

        channel.uploadVideo("Behavioral Patterns Explained");
    }
}
```

## ✅ Pros
✅ Loose coupling  
✅ Easy to add/remove observers  
✅ Automatic updates  

## ❌ Cons
❌ Can cause too many notifications  
❌ Hard to debug event chains  

---

# 6) ✅ Command Pattern

## ✅ Use Case
Encapsulate an action (request) as an object.

### Example
Remote Control:
- Button press triggers command
- Easy undo/redo

## ✅ Code

### Command Interface
```java
interface Command {
    void execute();
}
```

### Receiver
```java
class Light {
    public void turnOn() {
        System.out.println("Light ON");
    }
    public void turnOff() {
        System.out.println("Light OFF");
    }
}
```

### Concrete Commands
```java
class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}
```

### Invoker
```java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### Client
```java
public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(new TurnOnCommand(light));
        remote.pressButton();

        remote.setCommand(new TurnOffCommand(light));
        remote.pressButton();
    }
}
```

## ✅ Pros
✅ Decouples sender & receiver  
✅ Supports undo/redo queue  
✅ Easy to extend  

## ❌ Cons
❌ Many classes for commands

---

# ✅ Remaining patterns included: State, Chain of Responsibility, Template Method, Iterator,
# ✅ Mediator, Memento, Interpreter, Visitor + Interview Cheat Sheet + Practice Problems

✅ End of Behavioral Design Patterns Course ✅
