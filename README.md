For more information on STAF, https://dev.azure.com/Specsavers/STAF/_wiki/wikis/STAF.wiki/4/Quick-Start
Specsavers Test Automation Framework
Serenity BDD UI Wrapper

Specsavers core gradle wrapper for UI based test automation. This introduces and applies a build logic for test automation development, ensuring standardisation across projects using best practises and conventions.
Purpose (Why):

    A Specsavers baseline toolkit for test automation development.
    To develop and execute automated tests against UI web based applications.
    To establish remote connection between the tests and targeted platforms.
    To execute concurrent automation tests for application(s) under test against defined platform and environment ranges.

What this gives your build automatically

This custom wrapper creates libraries of dependency groupings at standard version(s). It applies our commonly used plugins / libraries

    JAVA
    Gradle
    Serenity BDD
    IDE plugins (Eclipse and Intellij)
    Serenity BDD Gradle Plugin
    Serenity Cucumber Plugin
    Serenity Screenplay WebDriver
    Gradle Wrapper 
    Junit
    AssertJ
    SLFJ Logger
    WebDriver Binary Manager
    Rest Assured Libraries
    Multi-platform custom chrome driver solution with preferred arguments
    System properties, Utility and Manager
    Additional custom base page object class
    Checkstyle, reporting and screenshot(s) capture
    Maven publication

Note: You may need to execute ./gradlew --refresh-dependencies to pick up and update gradle daemon caches, then refresh/ rebuild your IDE
