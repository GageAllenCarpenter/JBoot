# JBoot
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)]()
[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![Coverage](https://img.shields.io/badge/coverage-90%25-green.svg)]()

JBoot is a utility for scheduling and executing system reboots with optional tasks using custom logic. JBoot allows you to schedule reboots for computers, customize actions to perform on reboot, and handle various use cases that involve system restarts.
## Table of Contents
- [Introduction](#introduction)
- [Maven](#maven)
- [Features](#features)
- [Usage](#usage)
- [Overview](#overview)
- [Examples](#examples)
- [Contributions](#contributions)
- [License](#license)
## Introduction
JBoot is designed to provide a simple and flexible way to schedule system reboots. It allows you to specify the desired reboot time, and optional tasks to run on reboot. JBoot also offers enhanced control over system restarts.

Traditional reboot methods are often limited in their capabilities. JBoot aims to address these limitations by providing an intuitive interface to manage and execute reboots while allowing you to define custom behavior based on your requirements.

## Maven

To use JBoot in your Maven project add this dependency to the dependencies section of the pom.xml file within your project.
```mvn 
Currently working with SonaType(Maven Host) on deployment 8/27/2023
```

## Features
- Schedule system reboots at specific dates and times.
- Define custom actions or tasks to execute on reboot.
- Flexible and customizable reboot management.
- Enhanced control over system restarts.
## Usage
1. Clone or download the JBoot repository to your local machine.
2. Include the JBoot library in your project and import the necessary classes.
3. Utilize the available methods to schedule and manage system reboots based on your requirements.
## Overview

|Method|Use Case  |
|--|--|
| scheduleImmediateReboot() | Schedule an immediate system reboot. |
| scheduleRebootAt(Date rebootDate) | Schedule a system reboot at a specific date and time. |
| scheduleProgrammedReboot(Date rebootDate, String program) | Schedule a system reboot at a specific date and time with a program to run on startup. |
| private void scheduleTask(String program) | Generate and execute a PowerShell script to schedule a task on reboot. |
| private String generateScheduleScript(String program) | Generate a PowerShell script for scheduling a task on reboot. |
| private long calculateSecondsUntilReboot(Date rebootDate) | Calculate the number of seconds until a scheduled reboot. |
| private void executeShutdown(long secondsUntilReboot) | Execute the system shutdown command to initiate the reboot. |
| private void handleException(Exception e) | Handle exceptions that might occur during the reboot scheduling process. |

## Examples
Here are a few examples demonstrating how to use JBoot to schedule and manage system reboots.

### Immediate Reboot
This section demonstrates how to use the `scheduleImmediateReboot()` method to initiate an immediate system reboot.
```java
public static void main(String[] args) {
    RebootScheduler scheduler = new RebootScheduler();
    scheduler.scheduleImmediateReboot();
}
```

### Scheduled Reboot
This section provides an example of scheduling system reboots for a particular time using the RebootScheduler classes `scheduleRebootAt(rebootDate)` method.  
```java
public static void main(String[] args) {
    RebootScheduler scheduler = new RebootScheduler();
    Date rebootDate = /* Specify a desired reboot date and time */;
    scheduler.scheduleRebootAt(rebootDate);
}
```

### Scheduled Reboot With Restart Customization
This section illustrates how to use the scheduleProgrammedReboot() method to schedule a system reboot at a specific date and time, along with a custom task to run on reboot.
```java
public static void main(String[] args) {
    RebootScheduler scheduler = new RebootScheduler();
    Date rebootDate = /* Specify a desired reboot date and time */;
    String customTask = /* Define a custom task to run on reboot (e.g. path/to/App.exe)*/;
    scheduler.scheduleProgrammedReboot(rebootDate, customTask);
}
```
### Contributions
Contributions to JBoot are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Make your changes and submit a pull request.
3. Provide a clear description of your changes and their purpose.

## License
JBoot is licensed under the MIT License.
