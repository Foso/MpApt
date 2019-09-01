<h1 align="center">MpApt - Kotlin (Native/JS/JVM) Annotation Processor library</h1>

[![jCenter](https://img.shields.io/badge/Apache-2.0-green.svg)](https://github.com/Foso/MpApt/blob/master/LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![All Contributors](https://img.shields.io/badge/all_contributors-1-range.svg?style=flat-square)](#contributors)
  <a href="https://twitter.com/intent/tweet?text=Hey, check out MpApt https://github.com/Foso/MpApt via @jklingenberg_ #Android 
"><img src="https://img.shields.io/twitter/url/https/github.com/angular-medellin/meetup.svg?style=social" alt="Tweet"></a>



## Introduction 🙋‍♂️ 🙋‍
I wrote an annotation processing libary that can detect annotations in Kotlin Native/JS and Jvm projects, because Kapt is only working with KotlinJvm,. The library can used in Kotlin Compiler plugins. 

It can detect annotations with following targets: (CLASS,FUNCTION,PROPERTY,VALUE_PARAMETER,PROPERTY_GETTER,PROPERTY_GETTER,CONSTRUCTOR)


## Usage

Inside your compiler plugin, add the dependency from MavenCentral 

```groovy
repositories {
    mavenCentral()
}

dependencies {
   compile 'de.jensklingenberg:mpapt-runtime:0.8.0'
}
```
1) Create a class that extends de.jensklingenberg.mpapt.model.AbstractProcessor

```java
class MpAptTestProcessor(configuration: CompilerConfiguration) : AbstractProcessor(configuration) {

```
2) Add the names of your annoations that you want to detect:
```java
override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestClass::class.java.name, TestFunction::class.java.name)
```
3) Do something with detected annotations:
```java
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
4) Init MpApt inside your ComponentRegistrar:
Pass a instance of your processor into MpAptProject
Then add a instace of MpAptProject to the following extension classes:

Inside a Kotlin Native Compiler Plugin:
```java
override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val generator = MpAptTestProcessor(configuration)
        val mpapt = MpAptProject(generator)

        StorageComponentContainerContributor.registerExtension(project,mpapt)
        SyntheticResolveExtension.registerExtension(project, mpapt)
        IrGenerationExtension.registerExtension(project,mpapt)
    }
```

Inside a Kotlin JVM/JS Compiler Plugin:
```java
 override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = MpAptTestProcessor(configuration)
        val mpapt = MpAptProject(processor)
        StorageComponentContainerContributor.registerExtension(project,mpapt)
        SyntheticResolveExtension.registerExtension(project, mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)
    }
```


### Show some :heart: and star the repo to support the project

[![GitHub stars](https://img.shields.io/github/stars/Foso/MpApt.svg?style=social&label=Star)](https://github.com/Foso/MpApt) [![GitHub forks](https://img.shields.io/github/forks/Foso/MpApt.svg?style=social&label=Fork)](https://github.com/Foso/MpApt/fork) [![GitHub watchers](https://img.shields.io/github/watchers/Foso/MpApt.svg?style=social&label=Watch)](https://github.com/Foso/MpApt) [![Twitter Follow](https://img.shields.io/twitter/follow/jklingenberg_.svg?style=social)](https://twitter.com/jklingenberg_)

## 📜 License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE.md](https://github.com/Foso/MpApt/blob/master/LICENSE) file for details

### Find this project useful ? :heart:
* Support it by clicking the :star: button on the upper right of this page. :v:

License
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


