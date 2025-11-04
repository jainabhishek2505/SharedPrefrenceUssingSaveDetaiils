# 🧑‍💻 Android Login & Signup App (Kotlin)

A simple **Android app** built using **Kotlin**, demonstrating user **Signup, Login, Validation**, and **Session Management** using **SharedPreferences**.

## 🚀 Features

✅ **User Registration (Signup)**

* Stores user details like *Name, Email, and Password* in SharedPreferences.
* Validates all inputs before saving.

✅ **User Login**

* Checks user credentials against saved data.
* Prevents login if email or password is incorrect.
* Redirects to **Welcome Screen** on successful login.

✅ **Session Management**

* If the user is already logged in, the app directly opens the **WelcomeActivity** (skipping login screen).
* Session persists until the user logs out.

✅ **Logout Functionality**

* Clears all saved session data.
* Redirects user back to login screen.

✅ **Input Validation**

* Ensures name, email, and password are properly entered.
* Validates email format and password length.
* Displays user-friendly Toast messages for errors.

-----

## 🧩 Tech Stack

* **Language:** Kotlin
* **IDE:** Android Studio
* **Storage:** SharedPreferences
* **Architecture:** Simple Activity-based navigation
* **UI Layouts:** XML using LinearLayout

-----

## 🧠 App Flow

1. **MainActivity (Signup)**
   → User enters name, email, and password
   → Data validated and saved in SharedPreferences

2. **LoginActivity**
   → User enters credentials
   → Validates and compares with SharedPreferences
   → If valid → navigates to **WelcomeActivity**

3. **WelcomeActivity**
   → Displays saved user details (Name & Email)
   → Provides “Logout” button to clear the session

4. **CommonUtils.kt**
   → Contains reusable functions like `showToast()` and `checkValidation()`

-----

## ⚙️ How to Run

1. Clone the repository:

   ```bash
   
   git clone https://github.com/jainabhishek2505/SharedPrefrenceUssingSaveDetaiils.git
   ```
2. Open the project in **Android Studio**
3. Sync Gradle and run the app on an emulator or a real device

-----
## 📦 Apk Url 
1. Install  the app on your phone using this URL:
https://drive.google.com/file/d/1Hl5sJHsmP2cnhCvgS6G5Mf18E9QKI0hs/view?usp=sharing
------

## 💡 Author

**Abhishek Jain**
💬 Android Developer | Kotlin | Java
