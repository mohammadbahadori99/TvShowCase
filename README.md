### Technologies and Libraries which i used in this project:

* Clean MVVM Architecture
* Entirely written in Kotlin
* Uses Kotlin Coroutines throughout
* Uses Hilt for dependency injection
* Uses some of the Architecture Components like: Room, Lifecycle, Navigation.

### The basic data flow looks like this :

<p align="center">
 <img src='https://user-images.githubusercontent.com/59642165/193519976-32656cb0-3fff-4398-b9d3-03709e28dec1.png' width='500'>
</p>

The Repository layer handles data operations. Right now the app's data comes from just two different
sources; Json File or a data base, and the repository modules are responsible for abstracting the data sources from the rest of the app.

A lightweight domain layer sits between the data layer and the presentation layer and handles
discrete pieces of business logic off the UI thread.

### Improvements and Suggested features which needed more time to be implemented:

* Add Bookmarking feature
* Add Showing other Episode of a season in episode detail screen
* Sectioned List for better UI/UX for showing seasons
* Write Unit Test for testing data base

### Sum up

For the purpose of providing an overview of my solution, I have only included general information in
this document


