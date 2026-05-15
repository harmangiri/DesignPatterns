# 🔌 Adapter Pattern: Context for Other Microservices

Agar aap aisi microservice build kar rahe hain jo kisi legacy system, external third-party API, ya aisi service se baat karti hai jiska data format ya method signatures aapki service ke standard se bilkul alag hain, toh Adapter Pattern aapka sabse bada hathyaar hai.

### 💡 Use Case Example in Microservices (Payment Gateway Integration)
Imagine karein ke aapki **Checkout Service** ko pehle sirf ek purana bank payment gateway support karna tha jiska function tha `doPayment(String accNo, float amount)`. Ab company ne decide kiya hai ke hum ek modern "Stripe API" use karenge jiska method hai `makeCharge(StripeRequest request)`.

**Kyun use karein Adapter Pattern?**
Agar aap apni `CheckoutService` mein har jagah if-else lagakar `makeCharge` ko handle karenge, toh poora business logic tightly couple ho jayega nayi Stripe API se. Kal ko Stripe chhod kar Razorpay lagana pada toh fir se code phat jayega.

### 🛠️ How to Implement in Your Service

1. **Target Interface:** Aapki app pehle se kya samajhti hai? Ek interface banayein `PaymentProcessor` jisme purana method ho `process(double amount)`.
2. **Adaptee (The Incompatible Class):** Yeh external library hai, e.g., `StripeAPI` jiska method alag hai. Isey aap change nahi kar sakte.
3. **The Adapter:** Ek nayi class banayein `StripeAdapter` jo `PaymentProcessor` ko implement kare. Iske constructor mein `StripeAPI` inject karein. Jab app `process()` call kare, toh Adapter andar hi andar us value ko `StripeRequest` object mein convert karke `StripeAPI.makeCharge()` ko bhej de.

### 🚀 Benefit for Your Service
Is approach ke baad aapki Checkout Service ko pata hi nahi hoga ke peeche Stripe chal raha hai. Aapki service ka core logic completely insulated (safe) rahega external changes se. Naya gateway aane par bas ek naya Adapter likhna hoga!