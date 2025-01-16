# Elith Symmetric XOR Encryption (EE)
A simple tool for low-security applications (**NOT** to be used in any sort of password database!!)

### How to use?
```java
import site.abc.ee.ElithEncryption;

public class Test {
    public static void main(String[] args) {
        ElithEncryption e = new ElithEncryption("test");
        String key = e.getKey(); // random generated key
        String encryptedText = e.crypt();
        String symKey = e.getKey("test", encryptedText);
        
        ElithEncryption e1 = new ElithEncryption("test", "securekey"); // uses key "securekey"
    }
}
```
^ These are all methods available