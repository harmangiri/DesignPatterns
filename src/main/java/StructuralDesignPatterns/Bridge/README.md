# 🌉 Bridge Pattern

Bridge pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
Maan lijiye aapke paas ek class `Device` hai (TV, Radio) aur ek class `Remote` hai. Ab aap alag-alag remotes banana chahte hain: `BasicRemote` aur `AdvancedRemote`.
Agar aap inheritance use karenge toh classes aise banengi:
- `BasicTVRemote`
- `AdvancedTVRemote`
- `BasicRadioRemote`
- `AdvancedRadioRemote`

Kal ko naya device "AC" aur naya remote "SmartRemote" aaya, toh classes ki ginti exponential (bohot tezi se) badh jayegi: `BasicACRemote`, `AdvancedACRemote`, `SmartTVRemote`, `SmartRadioRemote`, `SmartACRemote`... Is problem ko **"Cartesian Product"** ya **"Class Explosion"** kehte hain.

**Yeh approach galat kyun hai?**
1. **Class Explosion:** Har naye device ya remote ke sath bohot saari nayi classes banani padti hain.
2. **Tight Coupling:** Remote aur Device tightly coupled hain.

---

### 🦸‍♂️ The Solution (Bridge Pattern)
Bridge pattern kehta hai: "Inheritance ki jagah Composition use karo."
Hum `Remote` (Abstraction) aur `Device` (Implementation) ko alag-alag hierarchies mein baant dete hain, aur unke beech ek "Bridge" bana dete hain.

**Yeh kaise kaam karta hai?**
1. **Implementation Interface (`Device`):** Ek interface banayein jisme primitive operations hon (`turnOn()`, `setVolume()`). `TV` aur `Radio` isey implement karenge.
2. **Abstraction (`Remote`):** Ek class banayein jisme `Device` ka ek reference (bridge) ho. `Remote` ke methods andar hi andar `Device` ke methods ko call karenge.
3. **Refined Abstraction (`AdvancedRemote`):** Nayi functionality add karein (`mute()`) jo base `Remote` ko extend kare, bina `Device` hierarchy ko touch kiye.

**Iska Fayda?**
* **No Class Explosion:** Agar naya device (AC) banana hai, toh sirf `Device` interface implement karein. Remote classes ko touch karne ki zaroorat nahi. Aur naya remote banana hai toh sirf `Remote` class extend karein.
* **Independent Extensions:** Abstraction (Remote) aur Implementation (Device) dono independently grow kar sakte hain.

---

### 📝 TL;DR (Short Summary)
**Bridge Pattern = "Ek badi class ya do closely related class hierarchies (e.g., Remote aur Device) ko do alag hierarchies mein divide karna (Abstraction aur Implementation), taake dono independently change ho sakein."**

Simple words mein: Remote ka kaam hai button dabana, aur Device ka kaam hai react karna. Dono ko alag rakho aur Remote ke andar Device ka reference de do (Bridge).