cat << 'PATCH' > update.patch
--- generativeai/src/main/java/com/google/ai/client/generativeai/GenerativeModel.kt
+++ generativeai/src/main/java/com/google/ai/client/generativeai/GenerativeModel.kt
@@ -211,7 +211,7 @@
     }
     promptFeedback?.blockReason?.let { throw PromptBlockedException(this) }
     candidates
-      .mapNotNull { it.finishReason }
-      .firstOrNull { it != FinishReason.STOP }
+      // ⚡ Bolt: Avoid intermediate list allocation from mapNotNull
+      .firstOrNull { it.finishReason != null && it.finishReason != FinishReason.STOP }
       ?.let { throw ResponseStoppedException(this) }
   }
 }
PATCH
patch generativeai/src/main/java/com/google/ai/client/generativeai/GenerativeModel.kt update.patch
