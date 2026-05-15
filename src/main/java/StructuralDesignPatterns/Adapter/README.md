# 🔌 Adapter Pattern

Adapter pattern ko asani se samajhne ka tarika.

### 🤦‍♂️ The Problem (Problem kya hai)
`BAD` package check karein. Maan lijiye aapki application ek purani Analytics library use karti hai jo sirf **XML** data samajhti hai. Ab aapne ek nayi modern API integrate ki hai jo data **JSON** format mein deti hai. 

**Yeh approach galat kyun hai?** 
1. **Incompatible Interfaces:** Aap direct JSON data Analytics library ko nahi de sakte kyunki woh sirf XML expect karti hai.
2. **Modifying Existing Code:** Agar aap Analytics library ka code change karke usko JSON support karne ko kahenge, toh yeh Open/Closed principle ke khilaf hoga. Aur agar woh kisi third-party ki library hai (jo aap change nahi kar sakte), toh aap phas jayenge!
3. **Messy Main Class:** Aapko apni main app mein har jagah JSON ko XML mein convert karne ka logic likhna padega.

---

### 🦸‍♂️ The Solution (Adapter Pattern)
Ab `GOOD` package check karein. 

Adapter pattern do incompatible interfaces ke beech ek "bridge" ya "bicholiya" ka kaam karta hai. Jaise aap American plug ko Indian socket mein lagane ke liye ek travel adapter use karte hain.

**Yeh kaise kaam karta hai?**
1. **Client Interface:** Jo interface aapki purani app expect karti hai (e.g., `XmlAnalytics`).
2. **Adaptee:** Nayi ya third-party class jiska interface alag hai (e.g., `JsonDataAPI`).
3. **Adapter Class:** Ek nayi class jo `XmlAnalytics` ko implement karti hai, lekin andar hi andar `JsonDataAPI` ko call karti hai aur JSON data ko XML mein convert karke aage bhejti hai.

**Iska Fayda?** 
* **Zero Code Modification:** Purani Analytics library ko pata hi nahi chalta ke data JSON se aaya hai, aur nayi API ko pata nahi chalta ke data XML mein use ho raha hai.
* **Loose Coupling:** Conversion ka saara logic sirf Adapter class mein rehta hai, main class clean rehti hai.

---

### 📝 TL;DR (Short Summary)
**Adapter Pattern = "Do classes jo aapas mein baat nahi kar sakti unki incompatible interfaces ki wajah se, unke beech ek translator (adapter) banana."**

Simple words mein: Aapke paas Type-C charger hai, aur phone ka port Micro-USB hai. Aap ek dongle (Adapter) lagate hain aur dono aapas mein easily connect ho jate hain!