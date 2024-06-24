package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;
import java.util.Objects;

public class MyLogger {

    private static final Logger logger = LogManager.getLogger();

    public static synchronized void startTestCase(String sTestCaseName) {
        sTestCaseName = sTestCaseName.replaceAll("[^a-zA-Z0-9]", "_").replaceAll("_+", "_");
        startLog(System.getProperty("user.dir"), sTestCaseName);
        info("\n\n*************** Execution Started : " + sTestCaseName + " ***************\n");
    }

    public static void endTestCase(String sTestCaseName) {
        info("\n\n*************** Execution End : " + sTestCaseName + "***************\n");
    }

    private static void startLog(String dirPath, String testCaseName) {
        int noOfFiles = 0;
        File dir = new File(dirPath);
        if (dir.exists()) {
            int count = 0;
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                if (file.isFile() && file.getName().endsWith(".log") && file.getName().contains(testCaseName)) {
                    count++;
                }
            }
            noOfFiles = count;
        }
        noOfFiles++;
        String logFileName = testCaseName + "_" + noOfFiles;
        ThreadContext.put("logFilename", logFileName);
    }

    private static Logger getCurrentLog() {
        return logger;
    }

    private static String getCallInfo() {
        String callInfo;
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        callInfo = className + ":" + methodName + " " + lineNumber + "==>  ";
        return callInfo;
    }

    public static void error(Object message) {
        getCurrentLog().error("{}{}", getCallInfo(), message);
    }

    public static void info(Object message) {
        getCurrentLog().info("{}{}", getCallInfo(), message);
    }

    public static void warn(Object message) {
        getCurrentLog().warn("{}{}", getCallInfo(), message);
    }
}
