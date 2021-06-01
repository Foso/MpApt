v0.8.8
========================================
Update to Kotlin 1.5.10, same api as 0.8.6

v0.8.7
========================================
Update to Kotlin 1.4.0, same api as 0.8.6

v0.8.6
========================================
* Fixed that processing of file annotation on native targets was called too often 

v0.8.5
========================================

Fix method signature of overridden abstract method

v0.8.4
========================================

* Build with Kotlin 1.3.71

* Fixed bug that produced a crash when annotating functions with expression body like
 "fun functionWithExpressionBody() = 1 + 1" on Native (thx to @chippmann)
 

* Removed SyntheticResolveExtensionImpl, you don't need add:
 SyntheticResolveExtension.registerExtension(project, mpapt) anymore


v0.8.3
========================================
* You can now detect annotated expressions in functions

* Added util method "printMessage()"
Added an extension function to the MessageCollector that can be used to print text or raise compiler errors.

Inside your processor, you can use it like that: 
```kotlin
configuration.messager().printMessage(DiagnosticKind.ERROR,"My error message", CompilerMessageLocation.Companion.create("/home/jens/Code/2019/MpApt/kotlin-plugin-shared/src/main/java/de/jensklingenberg/MpAptTestProcessor.kt",42,106))
```

This will print the message to the log and stop the compiler:
```kotlin
e: /home/jens/Code/2019/MpApt/kotlin-plugin-shared/src/main/java/de/jensklingenberg/MpAptTestProcessor.kt: (42, 106): My error message

```

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
