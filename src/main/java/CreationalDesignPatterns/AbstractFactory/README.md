# 🏭 Abstract Factory Pattern

Abstract Factory pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Hamari ek UI application hai jo different operating systems ke liye UI elements (Button, Checkbox) banati hai. 
`Application.java` mein directly `if-else` statements use hue hain:

```java
if (osType.equals("Windows")) {
    button = new WindowsButton();
    checkbox = new WindowsCheckbox();
} else if (osType.equals("Mac")) {
    button = new MacButton();
    checkbox = new MacCheckbox();
}
```

**Yeh approach galat kyun hai?**
1. **Related objects ka group nahi ban pata:** Windows Button aur Mac Checkbox ko galti se mix kar sakte hain, jo inconsistent UI create karega.
2. **Updates mein problem:** Agar kal ko humein Linux support add karna pada, toh har jagah `if-else` add karna padega aur code bahut bada ho jayega.
3. **Tightly Coupled Code:** Application class khud sab objects create kar rahi hai, aur har concrete class ko janti hai.
4. **Open/Closed Principle violation:** Naya OS add karne ke liye existing code modify karna padta hai.

---

### 🦸‍♂️ The Solution (Abstract Factory Pattern)
Ab `GOOD` package check karein.

Isme hum ek "Factory of Factories" banate hain. Matlab ek factory jo related products ka pura family/group create karti hai.

**Yeh kaise kaam karta hai?**
1. **Abstract Product Interfaces:** Har product type (Button, Checkbox) ka ek interface banana (`Button`, `Checkbox`).
2. **Concrete Products:** Har OS ke liye specific implementations (`WindowsButton`, `MacButton`, `WindowsCheckbox`, `MacCheckbox`).
3. **Abstract Factory Interface:** Ek factory interface banaya (`GUIFactory`) jo sabhi related products create karne ke methods define karta hai.
4. **Concrete Factories:** Har OS ke liye ek specific factory (`WindowsFactory`, `MacFactory`) jo us OS ke saare UI elements create karegi.
5. **Client Code:** `Application` class ab factory ko use karke objects create karti hai, concrete classes ko directly nahi janti.

**Iska Fayda?**
* **Consistency Guaranteed:** Ek factory se sabhi related objects milenge (Windows Button + Windows Checkbox), mixing nahi hoga.
* **Easily Extensible:** Naya OS (Linux) add karna hai? Bas `LinuxFactory`, `LinuxButton`, `LinuxCheckbox` banao. Existing code touch nahi karna padega.
* **Loose Coupling:** Client code ko concrete classes ki koi jankari nahi hai, sirf interfaces ke saath kaam karta hai.
* **Single Responsibility:** Har factory apne family ke objects create karne ki responsibility leta hai.

---

### 🔄 Factory Method vs Abstract Factory

**Factory Method:**
- Ek object create karne ke liye use hota hai
- Example: `createTransport()` sirf ek `Transport` object banata hai

**Abstract Factory:**
- Related objects ka pura family/group create karne ke liye use hota hai
- Example: `GUIFactory` Button + Checkbox + TextBox (pura UI family) bana sakta hai
- Factory Method ka extension hai jahan multiple related products create karne hote hain

---

### 📝 TL;DR (Short Summary)
**Abstract Factory = "Related objects ka family banane ke liye ek interface provide karta hai, bina unki concrete classes specify kiye."**

Simple words mein: Ek factory jo related products ka set banati hai (jaise Windows ke saare UI elements ek saath), taaki consistent aur compatible objects mil sakein.
