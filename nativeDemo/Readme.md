This is a (POC) demo project.
It shows how to use MpApt with Kotlin Native.
You can find the processor code [HERE](https://github.com/Foso/MpApt/blob/master/nativeDemo/native-plugin/src/main/java/de/jensklingenberg/MpAptTestProcessor.kt)

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

Now your annotated classes should be printed to the terminal

Please note: 
- I haven't added the MacOS targets for the annotations module. You need to add the target in build.gradle if you want to build them.
- When you run the build command a second time without changing any code, the plugin is not executed again. You need to make a change to see the log again.
