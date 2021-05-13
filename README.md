# iOs test automation with Appium

This is a sample project that runs multiple tests over an existing Appium instance. The Appium instance must run on a mac, as it requires iOs simulations.

## Getting Started

Clone the project and build it with Gradle (wrapper)

```
> ./gradlew clean build
```

### Prerequisites

* Install [Appium](https://appium.io/)
```
> brew install node
> npm install -g appium
> npm install wd
```
* rum Appium (If you are running Appium on an external server you must set up the `APPIUM_URL` environment variable)
```
> appium
```
* create an iOS simulator using xcrum in the machine that runs appium:
```
> xcrun simctl create temp_device com.apple.CoreSimulator.SimDeviceType.iPhone-8 com.apple.CoreSimulator.SimRuntime.iOS-14-4
```
* Create the environment variable `IOS_UDID` with the simulator UDID


## Running the tests

Simple run

```
> ./gradlew test
```

Or if you want to run specific test run the respective Gradle task

```
> ./gradlew loginTest
```

```
> ./gradlew logoutTest
```


## Built With

* [Appium](https://appium.io/) - Test automation framework
* [Gradle](https://gradle.org/) - Build tool
* [Java](https://www.java.com/es/) - Programming language
## Authors

* **Andres Perez** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

