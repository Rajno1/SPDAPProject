package org.issi.constants;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final int EXPLICITWAIT = 10;

    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/config.properties";
    private static final String EXCELFILEPATH = TESTRESOURCESPATH +"/Test_Data/Testdata.xlsx";
    private static final String LOGGERPATH = TESTRESOURCESPATH + "/config/log4j.properties";


    private static final String POWEROFATTORNEYFILEPATH = "C:/Users/Admin/Downloads/AuthorizedRep-Web.pdf";
    private static final String CAPTCHAPATH = TESTRESOURCESPATH + "/CaptchaScreenshot/captcha.png";

    public static String getCaptchapath() {
        return CAPTCHAPATH;
    }

    public static String getLoggerPath() {
        return LOGGERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getPowerOfAttorneyFormPath() {
        return POWEROFATTORNEYFILEPATH;
    }




}
