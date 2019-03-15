# ABC

This is a simple app that allows you to search and save items into a local DB

# Tech Stack and Architecture

The app was structured following **MVVM** desing pattern and was built using `ViewModel` and `LiveData` to hold and update the UI state, which consists on two Fragments that use **Contraint Layout** to arrange the components

The data layer is using the respository pattern, to persist the data the app is using `Room` and to fetch it from the remote is using **Retrofit**

To manage the dependencies between components we used Dagger and to comunicate the layers **RxJava2**

App theme and some UI componentes are using **Material Components**
 
