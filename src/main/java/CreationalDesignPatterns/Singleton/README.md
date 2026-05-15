# 🏢 Singleton Pattern

Singleton pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Maan lijiye aapke paas ek `DatabaseConnection` class hai. Har baar jab kisi class ko database se baat karni hoti hai, toh woh `new DatabaseConnection()` call karke ek naya connection bana leti hai. 

**Yeh approach galat kyun hai?** 
1. **Resource Wastage:** Database connections bohot heavy hote hain. Agar 100 users app use kar rahe hain aur 100 naye connections ban gaye, toh database server crash ho sakta hai.
2. **Inconsistent State:** Agar ek class configuration ko update karti hai, toh doosri class ko woh update nahi milega kyunki dono ke paas apne-apne alag instances hain.
3. **No Global Control:** Aapke paas is baat ka koi control nahi hota ke ek specific object ki kitni copies system mein ghoom rahi hain.

---

### 🦸‍♂️ The Solution (Singleton Pattern)
Ab `GOOD` package check karein. 

Singleton pattern ensure karta hai ke poore application ki life cycle mein us class ka **sirf ek hi instance (object)** bane, aur poori application usi ek instance ko share kare.

**Yeh kaise kaam karta hai?**
1. **Private Constructor:** Constructor ko `private` kar dein taake koi bhi bahar se `new` keyword use karke object na bana sake.
2. **Private Static Field:** Class ke andar hi apna ek private static instance hold karein.
3. **Public Static Method (`getInstance()`):** Ek global access point banayein. Yeh method check karta hai: "Agar instance already bana hua hai toh wahi return kar do, varna naya bana kar save kar lo aur phir return karo."

**Iska Fayda?** 
* **Strict Control:** Guaranteed sirf ek hi instance banega, memory aur resources bachenge.
* **Global Access:** Application mein kahin se bhi is ek instance ko access kiya ja sakta hai (like a global variable but safer).
* **Shared State:** Ek jagah change karenge toh poori app mein update reflect hoga.

---

### 📝 TL;DR (Short Summary)
**Singleton Pattern = "Class ka sirf ek object banne do, aur sabko usi ka access do."**

Simple words mein: Jaise ek desh ka ek hi Prime Minister hota hai, sab usko hi approach karte hain, koi naya Prime Minister instantiate nahi kar sakta!