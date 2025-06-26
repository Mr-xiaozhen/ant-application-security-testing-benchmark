package com.sast.astbenchmark.common.utils;

public class CmdUtil {

    public static void run(String cmd) {
        try {
            if (isValidCommand(cmd)) {
                Runtime.getRuntime().exec(cmd);
            } else {
                throw new IllegalArgumentException("Invalid command");
            }
        } catch (Exception e) {
            return;
        }
    }

    private static boolean isValidCommand(String cmd) {
        // Define a whitelist of allowed commands
        String[] allowedCommands = {"ls", "pwd", "echo"};
        for (String allowed : allowedCommands) {
            if (cmd.equals(allowed)) {
                return true;
            }
        }
        return false;
    }

    public static String getCmdWithContextSensitive(int x, String cmd) {
        String res;
        if (x > 0) {
            res = cmd;
        }
        else {
            res = "ls";
        }
        return res;
    }
}
