# Keep WebView JS-bridge interface accessible
-keepclassmembers class com.aura.ai.JsBridge {
    public *;
}
-keepattributes *Annotation*
-keepattributes JavascriptInterface
