<h1 align="center">
    🔎 Reflection Deep Object Comparator 🔎
</h1>

<h3 align="center">
    (in case you can't extend a class to change it's compareTo and hashCode methods or any other issues)
</h3>


## 📚 About 📚

During studies, I came up with a problem while trying to check if a list contained some custom objects, but without the ability to change those objects
compareTo and hashCode implementation in their classes. That lead me to a deeper problem, deep object comparison, especially between objects involved in multiple inheritance and/or with private fields.


After googling a for some time, I found out some libs that offer that, like [Apache's reflectionEquals](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/EqualsBuilder.html#reflectionEquals-java.lang.Object-java.lang.Object-boolean-), but since I was eager to learn more about
reflections, I decided to come up with my own implementation to solve my problem.

In this repository you'll find:

- **ObjectComparator class:** Class containing utility methods for objects deep comparison using reflection.
- **Tests class:** Class containing some tests proving that in some situations, like checking if a list contains an object, can be difficult if you don't have too much freedom to change every class.
- **sampleclasses package:** Some sample classes used in Tests.

### ⚙️ Requirements⚙️ 
- Java 8+ Preferably (Though it may run in much older versions)
- Junit (any recent version)

### 🚀 Running it 🚀
- Just open the code and run Test class. You can study (and play with!) the test cases to understand more about the problem
with List.contains when you can't override object compareTo and hashCode.

## 🚧 Contributing 🚧
If you see a potential improvement in coding, structure or best practices, please, let me know. I'm here to learn!
If you want to contribute, don't be shy! Open a pull request and let's create something better together!
---

## Show your support

Give a ⭐️ if this repository helped you!

