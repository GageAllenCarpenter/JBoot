package io.github.gageallencarpenter;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * A utility class for scheduling and executing system reboots with optional tasks using PowerShell.
 */
public class RebootScheduler {
    private final Powershell powershell = new Powershell();

    /**
     * Schedules an immediate system reboot.
     */
    public void scheduleImmediateReboot(){
        executeShutdown(0);
    }

    /**
     * Schedules a system reboot at a specific date and time.
     *
     * @param rebootDate The date and time to schedule the reboot.
     */
    public void scheduleRebootAt(Date rebootDate){
        long secondsUntilReboot = calculateSecondsUntilReboot(rebootDate);
        executeShutdown(secondsUntilReboot);
    }

    /**
     * Schedules a system reboot at a specific date and time with a program to run on startup.
     *
     * @param rebootDate The date and time to schedule the reboot.
     * @param program The program to run on startup.
     */
    public void scheduleProgrammedReboot(Date rebootDate, String program) {
        scheduleTask(program);
        scheduleRebootAt(rebootDate);
    }

    private void scheduleTask(String program) {
        String script = generateScheduleScript(program);
        powershell.execute(script);
    }

    private String generateScheduleScript(String program) {
        return "$Action = New-ScheduledTaskAction -Execute "+ "\"" + program + "\"" +"\n" +
                "$Trigger = New-ScheduledTaskTrigger -AtLogon\n" +
                "Register-ScheduledTask " + "\"" + program + " reboot" + "\"" + " -Action $Action -Trigger $Trigger -RunLevel Highest";
    }

    private long calculateSecondsUntilReboot(Date rebootDate) {
        Instant now = Instant.now();
        Instant targetInstant = rebootDate.toInstant();
        Duration duration = Duration.between(now, targetInstant);
        return duration.getSeconds();
    }

    private void executeShutdown(long secondsUntilReboot) {
        try {
            powershell.execute("shutdown -r -t " + secondsUntilReboot);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        // Log the error or perform appropriate error handling
        System.err.println("An error occurred: " + e.getMessage());
    }
}
