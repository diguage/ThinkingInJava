package com.diguage.books.thinking.util;

/**
 * 身份证工具类
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-16 18:50
 */
public class IdCardUtils {
    /**
     * 性别：0表示女；1表行男。
     */
    public static final int FEMALE = 0;

    /**
     * 性别：0表示女；1表行男。
     */
    public static final int MALE = 1;

    private static final int[] DAYS_OF_MONTH_IN_NORMAL_YEAR = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_OF_MONTH_IN_LEAP_YEAR = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static int[] FACTOR_OF_MULTIPLY = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    /**
     * 身份证号结尾字符。
     */
    private static char[] END_CHAR_OF_ID_CARD = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 验证一个身份证号是否合法。
     *
     * @param idCardNo 身份证号
     * @return 合法则返还true，不合法则返还false。
     */
    public static boolean isLegal(String idCardNo) {
        int sum = 0;
        for (int i = 0; i < FACTOR_OF_MULTIPLY.length; i++) {
            sum += Character.digit(idCardNo.charAt(i), 10) * FACTOR_OF_MULTIPLY[i];
        }
        int mod = sum % 11;
        if (END_CHAR_OF_ID_CARD[mod] == String.valueOf(idCardNo.charAt(17)).toUpperCase().charAt(0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLegal("34052419800101001X"));
        System.out.println(isLegal(generateIdCardNo(340524, 1980, IdCardUtils.MALE)));
    }

    /**
     * 根据行政区域代号、年份和性别生成身份证。
     *
     * @param areaCode 行政区域代号，请查看国家统计局网站：http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html
     * @param year     四位数表示的年份。
     * @param sex      性别，请使用本类定义的常量FEMAIL和MAIL。
     * @return 合法的身份证号。
     */
    public static String generateIdCardNo(int areaCode, int year, int sex) {
        return null;
    }

    /**
     * 根据行政区域代号、年份和性别生成身份证。
     *
     * @param areaCode 行政区域代号，请查看国家统计局网站：http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html
     * @param year     四位数表示的年份。
     * @param month    月份
     * @param sex      性别，请使用本类定义的常量FEMAIL和MAIL。
     * @return 合法的身份证号。
     */
    public static String generateIdCardNo(int areaCode, int year, int month, int sex) {
        return null;
    }

    /**
     * 根据行政区域代号、年份和性别生成身份证。
     *
     * @param areaCode 行政区域代号，请查看国家统计局网站：http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html
     * @param year     四位数表示的年份。
     * @param month    月份
     * @param day      月份中的日期
     * @param sex      性别，请使用本类定义的常量FEMAIL和MAIL。
     * @return 合法的身份证号。
     */
    public static String generateIdCardNo(int areaCode, int year, int month, int day, int sex) {
        int[] dayOfMonth = null;
        if (isLeapYear(year)) {
            dayOfMonth = DAYS_OF_MONTH_IN_LEAP_YEAR;
        } else {
            dayOfMonth = DAYS_OF_MONTH_IN_NORMAL_YEAR;
        }
        if (day < 0 || day > dayOfMonth[month - 1]) {
            throw new IllegalParametersException("非法参数：日期有误。");
        }
        return null;
    }

    /**
     * 根据年份返还当年每月的天数。
     *
     * @param year 给点年份
     * @return 每月的天数
     */
    private static int[] daysOfMonth(int year) {
        if (isLeapYear(year)) {
            return DAYS_OF_MONTH_IN_LEAP_YEAR;
        }
        return DAYS_OF_MONTH_IN_NORMAL_YEAR;
    }

    /**
     * 判断给定年份是否为闰年。
     *
     * @param year 给定年份
     * @return 是闰年则为true，否则为false。
     */
    private static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
