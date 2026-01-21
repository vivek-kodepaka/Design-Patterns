# ✅ Structural Design Patterns — Full Course (Java) 📘
*(Save this as `structural-design-patterns-course.md`)*

---

## 📌 Table of Contents
1. What are Structural Design Patterns?
2. Why Structural Patterns?
3. Pattern List (7 Patterns)
4. Adapter Pattern
5. Bridge Pattern
6. Composite Pattern
7. Decorator Pattern
8. Facade Pattern
9. Flyweight Pattern
10. Proxy Pattern
11. Interview Cheat Sheet
12. Practice Questions

---

# 1) ✅ What are Structural Design Patterns?

Structural Design Patterns focus on:

✅ **How classes and objects are composed**  
✅ **How to build larger structures from smaller ones**  
✅ **How to make systems flexible and reusable**

They solve problems like:
- Integrating incompatible classes
- Simplifying complex systems
- Adding features without modifying code
- Building hierarchical structures
- Memory optimization for repeated objects
- Controlling access to objects

---

# 2) ✅ Why Structural Patterns?

### Real-world problems:
✅ You have a system already running  
✅ You can’t modify legacy code  
✅ You want to add new features  
✅ You want to hide complexity  
✅ You want performance improvement  
✅ You want to organize code properly

---

# 3) ✅ Structural Patterns List (7)

| Pattern | Purpose |
|--------|---------|
| Adapter | Convert one interface into another |
| Bridge | Separate abstraction from implementation |
| Composite | Tree structure for objects |
| Decorator | Add functionality dynamically |
| Facade | Simple interface for complex subsystem |
| Flyweight | Reduce memory using shared objects |
| Proxy | Control access to object |

---

# 4) ✅ Adapter Design Pattern

## ✅ Problem it solves
You have **two incompatible interfaces**, but want them to work together.

### Example problem:
Your app expects `PaymentProcessor`, but you got a 3rd-party API `PaytmGateway`.

## ✅ Solution
Create an **Adapter** that converts calls.

## ✅ Java Code Example

### Target Interface (what client expects)
```java
interface PaymentProcessor {
    void processPayment(double amount);
}
```

### Adaptee (incompatible service)
```java
class PaytmGateway {
    public void makePaytmPayment(double rupees) {
        System.out.println("Payment done via Paytm: ₹" + rupees);
    }
}
```

### Adapter
```java
class PaytmAdapter implements PaymentProcessor {
    private PaytmGateway paytmGateway;

    public PaytmAdapter(PaytmGateway paytmGateway) {
        this.paytmGateway = paytmGateway;
    }

    @Override
    public void processPayment(double amount) {
        paytmGateway.makePaytmPayment(amount);
    }
}
```

### Client
```java
public class AdapterDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaytmAdapter(new PaytmGateway());
        processor.processPayment(500.0);
    }
}
```

✅ Output:
```
Payment done via Paytm: ₹500.0
```

### ✅ When to use
✅ Integrating legacy class  
✅ Using third-party libraries  
✅ Interface mismatch  

### ❌ When not to use
❌ When you can directly modify the original interface

---

# 5) ✅ Bridge Design Pattern

## ✅ Problem it solves
Avoid **class explosion** when combining multiple dimensions.

### Example problem:
- Shapes: Circle, Square
- Colors: Red, Blue

Without bridge:
- RedCircle, BlueCircle
- RedSquare, BlueSquare  
💥 Too many classes

## ✅ Solution
Separate:
- **Abstraction** (Shape)
- **Implementation** (Color)

## ✅ Java Code Example

### Implementor Interface
```java
interface Color {
    void applyColor();
}
```

### Concrete Implementations
```java
class Red implements Color {
    public void applyColor() {
        System.out.println("Applying Red color");
    }
}

class Blue implements Color {
    public void applyColor() {
        System.out.println("Applying Blue color");
    }
}
```

### Abstraction
```java
abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}
```

### Refined Abstraction
```java
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing Circle -> ");
        color.applyColor();
    }
}
```

### Client
```java
public class BridgeDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape blueCircle = new Circle(new Blue());

        redCircle.draw();
        blueCircle.draw();
    }
}
```

---

# 6) ✅ Composite Design Pattern

## ✅ Problem it solves
You want to treat:
✅ Single objects  
✅ Group of objects  
in the same way.

### Example
File system:
- File
- Folder (contains files/folders)

## ✅ Java Code Example

### Component
```java
interface FileSystemItem {
    void showDetails();
}
```

### Leaf
```java
class FileItem implements FileSystemItem {
    private String name;

    public FileItem(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
```

### Composite
```java
import java.util.*;

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemItem item : items) {
            item.showDetails();
        }
    }
}
```

### Client
```java
public class CompositeDemo {
    public static void main(String[] args) {
        FileSystemItem file1 = new FileItem("resume.pdf");
        FileSystemItem file2 = new FileItem("photo.png");

        Folder folder = new Folder("MyDocs");
        folder.addItem(file1);
        folder.addItem(file2);

        folder.showDetails();
    }
}
```

---

# 7) ✅ Decorator Design Pattern

## ✅ Problem it solves
Add features **dynamically** without modifying original class.

### Example
Coffee + Add-ons:
- coffee
- milk
- sugar

## ✅ Java Code Example

### Component
```java
interface Coffee {
    String getDescription();
    double getCost();
}
```

### Concrete Component
```java
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double getCost() {
        return 50;
    }
}
```

### Decorator
```java
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
```

### Concrete Decorators
```java
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 10;
    }
}
```

### Client
```java
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("Total Cost: ₹" + coffee.getCost());
    }
}
```

---

# 8) ✅ Facade Design Pattern

## ✅ Problem it solves
Provide **one simple interface** to a complex subsystem.

### Example
"Start Computer" internally does:
- CPU start
- RAM load
- HDD read boot

## ✅ Java Code Example

```java
class CPU {
    public void start() {
        System.out.println("CPU started");
    }
}

class RAM {
    public void load() {
        System.out.println("RAM loaded");
    }
}

class HardDisk {
    public void readBoot() {
        System.out.println("Boot sector read");
    }
}

class ComputerFacade {
    private CPU cpu = new CPU();
    private RAM ram = new RAM();
    private HardDisk disk = new HardDisk();

    public void startComputer() {
        cpu.start();
        ram.load();
        disk.readBoot();
        System.out.println("Computer started successfully!");
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}
```

---

# 9) ✅ Flyweight Design Pattern

## ✅ Problem it solves
Reduce memory usage by sharing common objects.

### Example
Game has 1 million trees 🌳  
Instead of 1 million objects, share tree type and store position separately.

## ✅ Java Code Example

```java
import java.util.*;

class TreeType {
    private String name;

    public TreeType(String name) {
        this.name = name;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + "," + y + ")");
    }
}

class TreeFactory {
    private static Map<String, TreeType> cache = new HashMap<>();

    public static TreeType getTreeType(String name) {
        if (!cache.containsKey(name)) {
            cache.put(name, new TreeType(name));
        }
        return cache.get(name);
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        TreeType mango = TreeFactory.getTreeType("Mango");
        mango.draw(10, 20);

        TreeType mango2 = TreeFactory.getTreeType("Mango");
        mango2.draw(50, 100);

        System.out.println("Same object? " + (mango == mango2));
    }
}
```

---

# 10) ✅ Proxy Design Pattern

## ✅ Problem it solves
Control access to an object.

### Example
- Lazy loading
- Security checks
- Caching

## ✅ Java Code Example

```java
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.png");

        img.display(); // loads + displays
        img.display(); // only displays
    }
}
```

---

# 11) ✅ Interview Cheat Sheet

| Pattern | Key Idea | Example |
|--------|----------|---------|
| Adapter | Convert interface | Power plug adapter |
| Bridge | Separate abstraction and implementation | Remote + TV |
| Composite | Tree structure | Folder + File |
| Decorator | Add behavior at runtime | Coffee with toppings |
| Facade | Simplify system | One button "Start PC" |
| Flyweight | Share objects | Tree objects in games |
| Proxy | Control access | Lazy image loading |

---

# 12) ✅ Practice Questions

✅ 1. Build an Adapter for converting `MP4Player` to `MediaPlayer`  
✅ 2. Use Decorator for Pizza toppings  
✅ 3. Create Composite for company employee hierarchy  
✅ 4. Use Proxy for role-based access  
✅ 5. Use Facade for booking system (Flight + Hotel + Cab)

---

✅ End of Course ✅
