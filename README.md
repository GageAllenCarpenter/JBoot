# JBoot
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

To use JCache in your Maven project add this dependency to the dependencies section of the pom.xml file within your project.
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

### Scheduling an Immediate Reboot

```java
public static void main(String[] args) {
    JBootScheduler scheduler = new JBootScheduler(/* Initialize necessary dependencies */);
    scheduler.scheduleImmediateReboot();
}
```

### Scheduling a Custom Reboot
```java
public static void main(String[] args) {
    JBootScheduler scheduler = new JBootScheduler(/* Initialize necessary dependencies */);
    Date rebootDate = /* Specify a desired reboot date and time */;
    String customTask = /* Define a custom task to run on reboot */;
    scheduler.scheduleCustomReboot(rebootDate, customTask);
}
```
###Managing System Reboots
```java
public static void main(String[] args) {
    JBootScheduler scheduler = new JBootScheduler(/* Initialize necessary dependencies */);
    
    // Check if a scheduled reboot is pending
    boolean isRebootPending = scheduler.isRebootPending();
    
    // Get the time until the next scheduled reboot
    Duration timeUntilReboot = scheduler.getTimeUntilReboot();
    
    // Cancel a pending reboot
    scheduler.cancelPendingReboot();
}
```
###Contributions
Contributions to JBoot are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Make your changes and submit a pull request.
3. Provide a clear description of your changes and their purpose.

## License
JBoot is licensed under the MIT License.
