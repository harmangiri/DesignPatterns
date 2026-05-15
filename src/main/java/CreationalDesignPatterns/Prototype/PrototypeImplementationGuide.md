# 🐑 Prototype Pattern: Context for Other Microservices

Agar aap koi aisi microservice build kar rahe hain jahan ek complex object ko baar-baar banana (from scratch) expensive hai, ya aapko existing state ki copies chahiye, toh Prototype Pattern aapke liye best hai.

### 💡 Use Case Example in Microservices (Game NPC Spawner / Config Cache)
Imagine karein ke aap ek **Game Server Service** bana rahe hain jahan aapko hazaro enemies (NPCs) spawn karne hain. Har enemy ka base stats, textures, aur AI logic database se load hota hai.

**Kyun use karein Prototype Pattern?**
Agar aap har naye enemy ke liye `new Enemy()` likhenge aur DB se uska data fetch karenge, toh server crash ho jayega. 

### 🛠️ How to Implement in Your Service

1. **The Prototype:** Ek `Enemy` class banayein jo `Cloneable` interface (ya apna custom `Prototype` interface) implement kare. Usme ek `clone()` method banayein.
2. **The Cache/Registry:** Ek baar game start hone par DB se "Goblin", "Orc", aur "Dragon" ka data fetch karein aur memory mein rakh lein (Prototype Registry).
3. **The Cloning:** Jab bhi naya enemy spawn karna ho, registry se existing enemy nikalein aur `enemy.clone()` call karein. Phir uski specific properties (jaise X,Y coordinates) change kar dein.

### 🚀 Benefit for Your Service
Is approach ke baad aapki service ko baar-baar mehngi database queries nahi karni padengi. Ek "Template" object already memory mein hoga, aur aap sirf uski photo-copies nikal rahe honge. 

*Cloning is extremely fast and keeps your microservice lightweight and decoupled from concrete classes!*