## 2024-06-25 - KSerializer Enum Caching
**Learning:** `enumClass.enumValues()` inside a `KSerializer` executes Java reflection (`java.enumConstants`) on every single deserialization/serialization call if not cached, turning an O(1) property lookup into an expensive O(N) reflection overhead.
**Action:** Always cache `enumClass.enumValues()` and mapped properties (`serialName`) into thread-safe properties (`val nameToValue = ...`) upon instantiation when writing custom `KSerializer`s for enums to ensure fast O(1) performance.
