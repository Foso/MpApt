This is a (POC) demo project.
It shows how to use MpApt with Kotlin Native.

Annotate a class with @PrintName("myvalue") and it will print at build phase: 

<p>
    <img src ="https://raw.githubusercontent.com/Foso/MpApt/master/nativeDemo/nativedemo.png" />
</p>

How to build:
Inside the project folder run:

First build the annotations module: 
* <kbd> ./gradlew :nativedemo-annotations:publishToMavenLocal</kbd>

Then build the native compiler plugin:
* <kbd>./gradlew :native-plugin:build</kbd>

Build the example module:
* <kbd>./gradlew :example:build</kbd>

I haven't added the MacOS targets for the annotations module. You need to add the target in build.gradle if you want to build them.
