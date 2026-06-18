
# Drone Telemetry Viewer Application

Android application developed using **Kotlin**, **Jetpack Compose**, and **MVVM Architecture** to receive and display drone telemetry data in real time. 
The application connects to a telemetry source using an IP address and port number and continuously updates important flight information on the dashboard.

---

# Features

* Connect to a telemetry source using IP Address and Port Number.
* Display live telemetry information.
* Automatic UI updates using StateFlow.
* Clean and scalable MVVM architecture.
* Background processing using Kotlin Coroutines.
* Repository Pattern for centralized data management.
* Material 3 based modern UI.

---

# Setup Steps

## 1. Clone the Repository

```bash
git clone <https://github.com/ASBsameer1919/DroneTelemetryViewer.git>
```

or download the project and open it in Android Studio.

---

## 2. Open the Project

Open the project using:

* Android Studio (Latest Stable Version)

---

## 3. Sync Gradle

Allow Android Studio to download all required dependencies.

---

## 4. Run the Application

Select an Android Emulator or physical device and click:

```text
Run ▶
```

---

## 5. Connect to Telemetry Stream

From the Connection Screen:

1. Enter the IP Address.
2. Enter the Port Number.
3. Press **Connect**.
4. The Dashboard Screen will start displaying telemetry values in real time.

---

# Libraries Used

| Library                          | Purpose                                   |
| -------------------------------- | ----------------------------------------- |
| Jetpack Compose                  | Declarative UI development                |
| Material 3                       | UI Components and Theming                 |
| Lifecycle ViewModel              | State and business logic management       |
| Kotlin Coroutines                | Asynchronous and background operations    |
| StateFlow                        | Reactive UI updates                       |
| Navigation Compose               | Screen navigation                         |
| Repository Pattern               | Data abstraction layer                    |
| DatagramSocket (Java Networking) | UDP communication                         |
| Compose Runtime                  | State management                          |
| Activity Compose                 | Compose integration with Android Activity |

---

# Architecture Explanation

The project follows the **MVVM (Model-View-ViewModel)** architecture to maintain a clean separation between UI and business logic.


UI Layer
(Connection Screen / Dashboard Screen)
                ↓
ViewModel
(TelemetryViewModel)
                ↓
Repository Layer
(TelemetryRepository)
                ↓
Network Layer
(SocketManager)
                ↓
Telemetry Stream


## UI Layer

* Built using Jetpack Compose.
* Displays telemetry information.
* Observes StateFlow from the ViewModel.

## ViewModel Layer

Responsible for:

* Managing UI state.
* Handling connection requests.
* Exposing telemetry data to the screens.

## Repository Layer

Responsible for:

* Acting as the central data source.
* Communicating with the network layer.
* Providing telemetry updates to the ViewModel.

## Network Layer

`SocketManager` handles:

* UDP socket creation.
* Receiving telemetry packets.
* Managing connection lifecycle.



# Project Structure

com.drone.telemetry

data
│
├── model
│     TelemetryData.kt
│
├── network
│     SocketManager.kt
│
└── repository
      TelemetryRepository.kt

ui
│
├── connection
│     ConnectionScreen.kt
│
└── dashboard
      DashboardScreen.kt

viewmodel
      TelemetryViewModel.kt

MainActivity.kt

# Telemetry Parameters Displayed

The dashboard displays:

* Latitude
* Longitude
* Altitude
* Battery Percentage
* Flight Mode
* Armed Status
* Connection Status

Updates are reflected automatically through StateFlow without requiring manual refresh.

---

# Assumptions

* A telemetry source is available and actively transmitting data.
* The user provides a valid IP address and port number.
* Telemetry packets follow the expected message format.
* Network connectivity is available between the mobile device and the telemetry source.
* Only one drone connection is maintained at a time.

---

# Limitations

* Supports only a single telemetry stream.
* No telemetry data recording or persistence.
* No map visualization.
* No flight history tracking.
* Limited error handling for malformed packets.
* Does not support advanced MAVLink message decoding.
* No cloud synchronization.
* No multi-drone monitoring support.

---

# Future Enhancements

* MAVLink protocol integration.
* Google Maps based drone tracking.
* Flight history and telemetry logging.
* Battery health analytics.
* Emergency alerts and notifications.
* Multiple drone support.
* Route visualization.
* Cloud dashboard integration.

---

# Conclusion

Drone Telemetry Viewer is a real-time Android application
developed using **Kotlin**, **Jetpack Compose**, and **MVVM Architecture**. The application demonstrates the implementation of modern Android development practices, 
including **StateFlow**, **Coroutines**, and the **Repository Pattern**, to efficiently receive and display telemetry information. Its modular architecture ensures
maintainability, scalability, and ease of extending the application with advanced drone functionalities in the future.
