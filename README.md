# KlarnaAssignmentByParisa
## Country Details App
This is an Android app that shows weather using modern Android development technologies.

## Features
- Display weather in different hours related to location.
- Uses MVI architecture for clean separation of concerns.
- Utilizes Jetpack Compose for building UI components.
- Dagger Hilt which provides a smooth dependency injection way in android.
- Integrates Data Binding for efficient UI updates.
- Fetches weather data using Retrofit and displays it.
- Uses gms:google Location Services for getting current location.

## Prerequisites
Android Studio (latest version)
Kotlin programming language

## Getting Started
1. Clone the repository to your local machine:

```
git clone https://github.com/parisa-mohamadi/RebtelAssignment.git
```

1. Open the project in Android Studio.

1. Build and run the app on an emulator or a physical device.

## Architecture
The app follows the MVI architecture which is basically MVVM but with added features, which promotes the separation of concerns and maintainability.

**App for the di:** can see all layers.

**Data:** for the internal and external storage — can see domain layer.

**Domain:** for the repository and use-case — no access to any layer.

**Presentation:** for the UI logic — can see domain.

## Dependencies
- Retrofit: For making API requests and handling responses.
- Jetpack Compose: For building modern and responsive UI.
- Dagger Hilt: which provides a smooth dependency injection way in android.
- Data Binding: For binding UI components to data sources.
- LiveData: For observing data changes and updating the UI.
- ViewModel: For managing UI-related data in a lifecycle-conscious way.
- Coroutines: for asynchronous programming.
- gms:google Location Services

## Usage
1. Launch the app on your emulator or device.
1. You will see a permision for location.
1. Allow to use current location.
1. Explore the detailed about today weather in different hours.

## Contributing
Contributions are welcome! If you find any issues or want to add new features, feel free to reach out to me at 
mohamadiparisa312@gmail.com.

