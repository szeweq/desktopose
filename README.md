# Desktopose

[![](https://jitpack.io/v/szeweq/desktopose.svg)](https://jitpack.io/#szeweq/desktopose)

This is a set of utilities and components meant to help with developing
desktop apps that use [Compose for Desktop](https://github.com/JetBrains/compose-jb) library.

It contains the following modules:
- `core` – Basic and helpful methods that other modules use (like binding method for MutableState)
- `hover` – Adds support for pointer hover and hovering backgrounds (with fix for buttons)
- `combo-box` – A combo box component (with a dropdown list)
- `progress` – Progress state management and composition

## Using this library (using Gradle)

Add JitPack to repositories first.
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

Then add Desktopose as a dependancy (all modules will be included).
Replace `<version>` with a release version or `main-SNAPSHOT`.
```groovy
dependencies {
    implementation 'com.github.szeweq:desktopose:<version>'
}
```

You can also choose which modules you want to use
(replace `<module>` with a module name):
```groovy
dependencies {
    implementation 'com.github.szeweq.desktopose:<module>:<version>'
}
```