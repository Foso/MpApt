<h1 align="center">MpApt - Kotlin (Native/JS/JVM) Annotation Processor library</h1>

[![jCenter](https://img.shields.io/badge/Kotlin-1.5.10-green.svg
)](https://github.com/Foso/MpApt/blob/master/LICENSE)[![jCenter](https://img.shields.io/badge/Apache-2.0-green.svg)](https://github.com/Foso/MpApt/blob/master/LICENSE)
[![All Contribtors](https://img.shields.io/badge/Maven-Central-download.svg?style=flat-square)](https://mvnrepository.com/artifact/de.jensklingenberg/mpapt-runtime)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![All Contributors](https://img.shields.io/badge/all_contributors-2-range.svg?style=flat-square)](#contributors)
  <a href="https://twitter.com/intent/tweet?text=Hey, check out MpApt https://github.com/Foso/MpApt via @jklingenberg_ #Kotlin 
"><img src="https://img.shields.io/twitter/url/https/github.com/angular-medellin/meetup.svg?style=social" alt="Tweet"></a>
[![Kotlinlang slack](https://img.shields.io/static/v1?label=kotlinlang&message=MpApt&color=brightgreen&logo=slack&style=flat-square)](https://app.slack.com/client/T09229ZC6/CNDF01UPR)


## Introduction 🙋‍♂️ 🙋‍
I wrote an annotation processing libary that can detect annotations in Kotlin Native/JS and Jvm projects, because Kapt is only working with KotlinJvm. The library can be used in Kotlin Compiler plugins. Tested with Kotlin 1.4.0,1.5.10

It can detect annotations with following targets: 
```groovy
(CLASS,FUNCTION,PROPERTY,VALUE_PARAMETER,PROPERTY_GETTER,PROPERTY_GETTER,CONSTRUCTOR)
(ANNOTATION_CLASS,TYPE_PARAMETER,FIELD,FILE,LocalVariable)
```

<p align="left">
  Example output of my example plugin on Kotlin Native:
  <img src ="https://raw.githubusercontent.com/Foso/MpApt/master/docs/images/logNative.png"  />
</p>


### Show some :heart: and star the repo to support the project

[![GitHub stars](https://img.shields.io/github/stars/Foso/MpApt.svg?style=social&label=Star)](https://github.com/Foso/MpApt) [![GitHub forks](https://img.shields.io/github/forks/Foso/MpApt.svg?style=social&label=Fork)](https://github.com/Foso/MpApt/fork) [![GitHub watchers](https://img.shields.io/github/watchers/Foso/MpApt.svg?style=social&label=Watch)](https://github.com/Foso/MpApt) [![Twitter Follow](https://img.shields.io/twitter/follow/jklingenberg_.svg?style=social)](https://twitter.com/jklingenberg_)

## Projects that use MpApt:
* [Native Suspended Functions](https://github.com/feilfeilundfeil/kotlin-native-suspend-function-callback)
* [Kvision](https://github.com/rjaros/kvision)
* [Godot Kotlin](https://github.com/utopia-rise/godot-kotlin)
* [fritz2-optics](https://github.com/jwstegemann/fritz2-optics)

* Your project?

## Usage
These are the instructions for v0.8.7, check [Changelog](https://github.com/Foso/MpApt/blob/master/docs/CHANGELOG.md) for changes on the active development branch

Inside your compiler plugin, add the dependency from MavenCentral 

```groovy
repositories {
    mavenCentral()
}

dependencies {
   compile 'de.jensklingenberg:mpapt-runtime:0.8.7'
}
```
1) Create a class that extends de.jensklingenberg.mpapt.model.AbstractProcessor

```kotlin
class MpAptTestProcessor() : AbstractProcessor() {

```
2) Add the names of your annotations that you want to detect:
```kotlin
override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestClass::class.java.name, TestFunction::class.java.name)
```
3) Do something with detected annotations:
```kotlin
override fun process(roundEnvironment: RoundEnvironment) {
roundEnvironment.getElementsAnnotatedWith(TestClass::class.java.name).forEach {
            when (it) {
                is Element.ClassElement -> {
                    log("Found Class: " + it.classDescriptor.name + " Module: " + it.classDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(TestFunction::class.java.name).forEach {
            when (it) {
                is Element.FunctionElement -> {
                    log("Found Function: " + it.func.name + " Module: " + it.func.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }
}
```
4)  Init MpApt inside your ComponentRegistrar:
* Pass an instance of your processor and the CompilerConfiguration into MpAptProject
* Then add an instance of MpAptProject to the following extension classes:

Inside a Kotlin Native Compiler Plugin:
```kotlin
override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val processor = MpAptTestProcessor()
        val mpapt = MpAptProject(processor,configuration)

        StorageComponentContainerContributor.registerExtension(project,mpapt)
        IrGenerationExtension.registerExtension(project,mpapt)
    }
```

Inside a Kotlin JVM/JS Compiler Plugin:
```kotlin
 override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = MpAptTestProcessor()
        val mpapt = MpAptProject(processor,configuration)
        StorageComponentContainerContributor.registerExtension(project,mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)
    }
```
5) That's it

### Choose supported target platforms 
By default your processor is enabled for every target. 
You can override 

```kotlin
isTargetPlatformSupported(platform: TargetPlatform): Boolean
```
and return "true" if you want to support the target or "false" you don't.

```kotlin
   override fun isTargetPlatformSupported(platform: TargetPlatform): Boolean {
         val targetName = platform.first().platformName
 
         return when (targetName) {
             KotlinPlatformValues.JS -> true
             KotlinPlatformValues.JVM -> true
             KotlinPlatformValues.NATIVE -> {
                 return when (configuration.nativeTargetPlatformName()) {
                     KonanTargetValues.LINUX_X64, KonanTargetValues.MACOS_X64 -> {
                         true
                     }
                     else -> {
                         true
                     }
                 }
             }
             else -> {
                 log(targetName)
                 true
             }
         }
 
     }
```
You can distinguish between the native target platforms you want to support.

configuration.nativeTargetPlatformName() will get you the names of the Native Targets(macos_x64,linux_x64,etc). The values are defined in KonanTargetValues.
It needs to be used only on Kotlin Native otherwise it will return an empty string


## ✍️ Feedback

Feel free to send feedback on [Twitter](https://twitter.com/jklingenberg_) or [file an issue](https://github.com/foso/MpApt/issues/new) or join the [Kotlin Slack](https://slack.kotlinlang.org) and the [![Kotlinlang slack](https://img.shields.io/static/v1?label=kotlinlang&message=MpApt&color=brightgreen&logo=slack&style=flat-square)](https://app.slack.com/client/T09229ZC6/CNDF01UPR) channel. Feature requests are always welcome. If you wish to contribute, please take a quick look at [How to develop?](https://github.com/Foso/MpApt/wiki/How-to-develop%3F)

## 👷 Development Project Structure
 	
* <kbd>demoProject</kbd> - An example project that is using MpApt+KotlinPoet to generate code on KotlinJS
* <kbd>annotations</kbd> - A Kotlin Multiplatform project which contains test annotations 
* <kbd>example</kbd> - A Kotlin Multiplatform project which applies a gradle plugin(de.jensklingenberg.mpapt) whichs triggers the compiler plugin.
* <kbd>buildSrc</kbd> - This module contains the gradle plugin which trigger the compiler plugin
* <kbd>kotlin-plugin</kbd> - This module contains the Kotlin Compiler Plugin for JVM/JS targets, it implements the <kbd>kotlin-plugin-shared</kbd>-module
* <kbd>kotlin-compiler-native-plugin</kbd> - This module contains the Kotlin Compiler Plugin for Native targets, it implements the <kbd>kotlin-plugin-shared</kbd>-module
* <kbd>kotlin-plugin-shared</kbd> Contains an implementation of MpApt

## Testing 
The [CompileTest](https://github.com/Foso/MpApt/blob/master/kotlin-plugin-shared/src/test/kotlin/de/jensklingenberg/CompileTest.kt) shows you, how you can use [Kotlin Compile Testing](https://github.com/tschuchortdev/kotlin-compile-testing) to test your Processor/Compiler Plugin


# See also
* [How to use a Kotlin Compiler Plugin from Gradle Plugin](https://github.com/Foso/MpApt/wiki/How-to-use-a-Kotlin-Compiler-Plugin-from-Gradle-Plugin)
* [How to write a Kotlin Compiler Plugin](https://github.com/Foso/MpApt/wiki/How-to-write-a-Kotlin-Compiler-Plugin)
* [How to debug Kotlin Compiler Plugin](https://github.com/Foso/MpApt/wiki/How-to-debug-Kotlin-Compiler-Plugin)
* [How to develop?](https://github.com/Foso/MpApt/wiki/How-to-develop%3F)

## 📜 License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE.md](https://github.com/Foso/MpApt/blob/master/LICENSE) file for details

-------

    Copyright 2019 Jens Klingenberg

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


