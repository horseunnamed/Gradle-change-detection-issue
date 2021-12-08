# Incremental java compilation in Gradle 7.3.x issue reproducer

Incremental java compilation fails when class with $ character in its name is renamed

Steps to reproduce:
1. Run `./gradlew build`
2. Change name of the class `Class$Name` 
to something different (`Class$NameChanged` for example)
**and** reference to it at `Main.java`
3. Run `./gradlew build` again

Got: 
```
> Task :compileJava FAILED
Caching disabled for task ':compileJava' because:
  Build cache is disabled
Task ':compileJava' is not up-to-date because:
  Input property 'stableSources' file .../src/main/java/issue/Class$Name.java has been removed.
  Input property 'stableSources' file .../src/main/java/issue/Main.java has changed.
  Input property 'stableSources' file .../src/main/java/issue/Class$NameChanged.java has been added.
Created classpath snapshot for incremental compilation in 0.0 secs.
Compiling with toolchain '/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home'.
Compiling with JDK Java compiler API.
.../src/main/java/issue/Main.java:5: error: cannot find symbol
        new Class$NameChanged();
            ^
  symbol:   class Class$NameChanged
  location: class Main
1 error
Incremental compilation of 3 classes completed in 0.012 secs.
:compileJava (Thread[Execution worker for ':',5,main]) completed. Took 0.02 secs.

FAILURE: Build failed with an exception.
```

Expected behavior: build successful

Doesn't reproduce with Gradle 7.2 and earliest versions