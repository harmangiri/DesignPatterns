# 🐑 Prototype Pattern

Prototype pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Maan lijiye aapke paas ek base class hai `Shape` aur uski subclasses hain `Circle` aur `Rectangle`. Agar aapke paas ek `Shape` ka object hai aur aap chahte hain ke uska exact duplicate (copy) banayein, toh kya karenge?
Aapko ek naya object banana padega aur purane wale ki saari properties ek-ek karke copy karni padengi.

**Yeh approach galat kyun hai?** 
1. **Private Fields:** Ho sakta hai purane object ki kuch properties private hon, jo bahar se access hi na ho sakein. Toh unhe copy kaise karenge?
2. **Concrete Class Dependency:** Agar aapke paas `List<Shape>` hai, toh loop chalate waqt aapko pata hi nahi hoga ke current object `Circle` hai ya `Rectangle`. Aapko `instanceof` lagakar check karna padega, jo ki bohot tight coupling hai.
3. **Complex Creation:** Kabhi kabhi ek object banana bohot heavy operation hota hai (jaise database se configuration fetch karna). Har baar `new` use karna slow ho sakta hai.

---

### 🦸‍♂️ The Solution (Prototype Pattern)
Ab `GOOD` package check karein. 

Prototype pattern object creation ki responsibility usi object ko de deta hai jisko clone hona hai. Hum ek common interface banate hain jisme `clone()` method hota hai.

**Yeh kaise kaam karta hai?**
1. **Prototype Interface:** Ek interface ya abstract class banayein (jaise `Shape`) aur usme `clone()` method define karein.
2. **Concrete Prototypes:** `Circle` aur `Rectangle` is method ko implement karte hain aur `this` ka ek naya instance return karte hain (apni saari properties copy karke).

**Iska Fayda?** 
* **No `instanceof`:** Main code ko yeh janne ki zaroorat nahi ke object `Circle` hai ya `Rectangle`. Woh seedha `shape.clone()` call karta hai.
* **Access to Private Fields:** Kyunki `clone()` usi class ke andar hota hai, woh aaram se apni private fields ko copy kar sakta hai.
* **Performance:** Heavy objects (jaise API responses ya DB configs) ko baar-baar create karne ke bajaye, unka ek prototype memory mein rakh kar usey clone kiya ja sakta hai.

---

### 📝 TL;DR (Short Summary)
**Prototype Pattern = "Ek existing object ki exact copy (clone) banana, bina uski concrete class par depend hue."**

Simple words mein: Agar aapko ek sheep chahiye, toh nayi sheep paida karne se behtar hai, existing sheep ko "Dolly" ki tarah clone kar lo!