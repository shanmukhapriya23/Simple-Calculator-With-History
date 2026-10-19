# Simple Calculator with History

## 👤 Track Info
* **Name**: Shanmukhapriya[cite: 1]
* **Track**: Android Development Track[cite: 1]

---

## 📌 Description
Extend a calculator by displaying previous calculations during the current session[cite: 1].

## 🎯 Objective
Practice lists and dynamic UI updates[cite: 1].

## 🛠️ Tools
* Android Studio[cite: 1]
* Kotlin[cite: 1]

## 📦 Deliverables
* Calculator[cite: 1]
* Calculation history[cite: 1]

## 💡 Hints / Mini Guide
* Store calculation strings in a mutable list[cite: 1].

---

## 🚀 How to Run the Project

1. **Clone or Open Project**:
   * Open Android Studio and choose **Open**, then select your project folder.

2. **Sync Project with Gradle**:
   * Go to **File > Sync Project with Gradle Files** (or click the Sync/Elephant icon in the top toolbar) and wait for the sync to complete.

3. **Set Up a Device**:
   * **Virtual Device (Emulator)**: Go to **Tools > Device Manager**, click **Create Device**, select a phone profile (e.g., Pixel 5), select a system image, and click **Finish**.
   * **Physical Device**: Enable **Developer Options** and **USB Debugging** on your Android phone, then connect it via USB.

4. **Run the App**:
   * Select `app` in the top drop-down menu and choose your connected device or emulator.
   * Click the green **Play ▶️** button (or press `Shift + F10` / `Ctrl + R`) to build and launch the application.

---

## ❓ Interview Questions

### 1. What is MutableList in Kotlin?
A `MutableList` is a generic ordered collection of elements that supports both read and write operations. Unlike read-only lists, it allows items to be added, removed, or updated dynamically at runtime (e.g., storing and updating calculation history strings during the app session)[cite: 1].

### 2. How can a list be displayed on the screen?
In Android development, lists can be displayed on the screen using:
* **`RecyclerView`**: The standard and most efficient way to display large or dynamic lists by recycling view holders as the user scrolls[cite: 1].
* **`ListView`**: A simpler component used with adapters for basic lists[cite: 1].
* **Jetpack Compose (`LazyColumn`)**: A modern declarative UI approach for rendering scrollable lists efficiently[cite: 1].
