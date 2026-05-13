# 🏭 Factory Method Pattern

Factory Method pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Hamari ek logistics application hai jo sirf `Truck` aur `Ship` ko janti hai. 
`LogisticsApp.java` mein directly `if-else` statements use hue hain:

```java
if (type.equals("road")) { 
    new Truck().deliver(); 
} else if (type.equals("sea")) { 
    new Ship().deliver(); 
}
```

**Yeh approach galat kyun hai?** 
1. **Updates mein problem:** Agar kal ko humein `Airplane` ya `Drone` add karna pada, toh poori class open karke naye `if-else` lagane padenge aur fir se testing karni padegi. (Yeh Open/Closed Principle ke khilaf hai - code extension ke liye open hona chahiye, aur modification ke liye close).
2. **Tightly Coupled Code:** Main class par zyada dependency hai, aur woh khud hi sab objects create kar rahi hai.

---

### 🦸‍♂️ The Solution (Factory Method Pattern)
Ab `GOOD` package check karein. 

Isme hum direct `new Truck()` ya `new Ship()` khud create nahi karte. Hum object create karne ki responsibility ek "Factory" (method) ko de dete hain.

**Yeh kaise kaam karta hai?**
1. **Common Interface:** Sabhi objects (Truck, Ship) ko ek `Transport` interface de diya gaya hai taaki sabke paas `.deliver()` function zaroor ho.
2. **Creator Class:** Ek base class banai gayi hai `Logistics`. Iska kaam delivery plan karna hai, magar isme ek abstract method hai `createTransport()`. Isko nahi pata ke exactly kaunsa object banega.
3. **Subclasses decide karengi:** Phir `RoadLogistics` jaisi child classes banai gayi hain. Inka sirf ek hi kaam hai ke `createTransport()` ko override karein aur specific object (`Truck` ya `Ship`) return karein.

**Iska Fayda?** 
* **Easily Extensible:** Agar naya transport (e.g. `AirLogistics`) add karna hai, toh bas subclass aur transport interface classes bana lein. Purane code ko modify karne ki zaroorat nahi padegi.
* **Loose Coupling:** Main application ko is baat se koi farq nahi padta ke object truck hai ya ship, usko sirf ek `Transport` chahiye jo `.deliver()` kar sake.

---

### ✈️ Advanced Hierarchies (Sub-categorization)
Agar aapke paas ek category ke andar aur variations hain (jaise *Air Transport* ke andar `Airplane` aur `HotAirBalloon`), toh hum usko ek level aur abstract kar sakte hain bina `if-else` use kiye.

**Yeh kaise hoga?**
1. Ek nayi abstract class banayein `AirLogistics` jo main `Logistics` ko extend karegi. Yeh ek category define karti hai.
2. Phir us `AirLogistics` category se hum aur concrete classes banayenge:
   - `AirplaneLogistics extends AirLogistics` (Return karega `Airplane`)
   - `HotAirBalloonLogistics extends AirLogistics` (Return karega `HotAirBalloon`)

Iska sabse bada faida yeh hai ke hum Open/Closed Principle ko completely follow kar rahe hain. Naya Helicopter add karna ho toh sirf `HelicopterLogistics` banayein, aur kisi existing code ya `if-else` ko touch karne ki zaroorat nahi padegi!

---

### 📝 TL;DR (Short Summary)
**Factory Method = "Object create karne ke liye interface define karein, aur subclasses ko decide karne dein ke kaunsa class instantiate hoga."**

Simple words mein: Main application ko sirf transport chahiye, woh create kaise hoga yeh details factory (subclasses) handle karengi.