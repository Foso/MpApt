v0.8.2
========================================
fixed that processingOver was called to often
You can now detect annotation with Target (ANNOTATION_CLASS,TYPE_PARAMETER,FIELD,FILE,LocalVariable)

v0.8.1

========================================

You can now distinguish between which  native target platforms you want to support.
Before processing the isTargetPlatformSupported(platform: TargetPlatform) will be called and you can return true if you want to enable your processor for this target or false if you don't. By default this methods returns true

configuration.nativeTargetPlatformName() will get you the names of the Native Targets(macos_x64,linux_x64,etc) the values are defined in KonanTargetValues.
It needs to be used only on Kotlin Native otherwise it will return an empty string

Example:
```kotlin
override fun isTargetPlatformSupported(platform: TargetPlatform): Boolean {
         val targetName = platform.first().platformName
 
         return when (targetName) {
             KotlinPlatformValues.JS -> false
             KotlinPlatformValues.JVM -> true
             KotlinPlatformValues.NATIVE -> {
                 return when (configuration.nativeTargetPlatformName()) {
                     KonanTargetValues.LINUX_X64,KonanTargetValues.MACOS_X64 -> {
                         false
                     }
                     else->{
                         false
                     }
                 }
             }
             else -> {
                 log(targetName)
                 false
             }
         }
 
     }
     
```



  ========================================   

Changed the initialization of the library.

Now you need to add the compiler configuration to the MpAptProject

```kotlin
val processor = MpAptTestProcessor()
val mpapt = MpAptProject(processor,configuration)
```
