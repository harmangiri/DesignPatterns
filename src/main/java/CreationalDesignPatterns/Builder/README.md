# 🏗️ Builder Pattern

Builder pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Jab ek class (jaise `House`) mein bohot saari properties hoti hain (walls, doors, windows, roof, garage, swimming pool), toh humein object banate waqt ek bohot bada constructor call karna padta hai. Isey **Telescoping Constructor Anti-Pattern** kehte hain.

```java
// Yeh kitna confusing hai! Kya true/false kiske liye hai?
House house = new House(4, 2, 4, true, false, true); 
```

**Yeh approach galat kyun hai?** 
1. **Confusing Parameters:** Constructor mein itne saare arguments pass karte waqt developer bhool sakta hai ke kaunsi value kis property ke liye hai.
2. **Useless Nulls/Booleans:** Agar mujhe sirf ek simple ghar chahiye jisme pool ya garage na ho, toh bhi mujhe zabardasti `false` ya `null` pass karna padega.
3. **Rigid:** Agar kal ko `garden` add karna pada, toh naya constructor likhna padega ya purane ko modify karna padega.

---

### 🦸‍♂️ The Solution (Builder Pattern)
Ab `GOOD` package check karein. 

Builder pattern complex objects ko step-by-step banata hai. Humein ek sath 10 parameters pass karne ki zaroorat nahi hai.

**Yeh kaise kaam karta hai?**
1. **Builder Interface:** Ek interface `HouseBuilder` banayein jisme step-by-step methods hon (`buildWalls()`, `buildDoors()`, `buildPool()`).
2. **Concrete Builders:** Specific builders banayein (jaise `MansionBuilder` ya `CabinBuilder`) jo in steps ko apne hisaab se implement karein.
3. **Director (Optional):** Ek `CivilEngineer` (Director) class banayein jo steps ki sequence define kare. Director decide karta hai "kaise banega", aur Builder decide karta hai "kya banega".

**Iska Fayda?** 
* **Clean Code:** `new MansionBuilder().buildWalls(4).buildDoors(2).getResult()` padhne mein kitna clean lagta hai!
* **Different Representations:** Ek hi construction process alag-alag objects bana sakta hai (jaise ek hi process se aap Mansion bhi bana sakte hain aur Cabin bhi).
* **Immutability:** Object tab tak access nahi hota jab tak woh poori tarah bankar ready na ho jaye.

---

### 📝 TL;DR (Short Summary)
**Builder Pattern = "Ek complex object ko step-by-step construct karne ka tarika, jisse ek hi construction code alag-alag representations produce kar sake."**

Simple words mein: Sandwich order karte waqt aap seedha "Sandwich" nahi maangte. Aap step-by-step batate hain: "Bread do", "Chicken dalo", "Cheese mat dalo". Yahi Builder pattern hai!