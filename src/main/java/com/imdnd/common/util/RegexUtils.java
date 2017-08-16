package com.imdnd.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Common Regex Utils include password, email, ID card validation and so on
 */
public class RegexUtils {

    // Strong password pattern
    private static final String STRONG_PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";


    /**
     * 正则表达式：验证用户名
     */
    private static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证密码
     */
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号
     */
    private static final String REGEX_MOBILE = "^(1)\\d{10}$";

    /**
     * 正则表达式：验证邮箱
     */
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证中文
     */
    private static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{1,20}$";

    /**
     * 正则表达式：验证身份证
     */
    private static final String REGEX_ID_CARD = "(^\\d{17}([0-9]|X)$)";

    /**
     * 正则表达式：验证银行卡
     */
    private static final String REGEX_ID_BANK = "(^(\\d{16}|\\d{19})$)";

    /**
     * 正则表达式：验证URL
     */
    private static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    private static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 正则表达式：验证是否为数字
     */
    private static final String REGEX_NUMERIC = "([0-9]*)";

    /**
     * Verify the input whether is a strong password
     *
     * @param input null is accepted
     */
    public static boolean isStrongPassword(String input) {
        Optional<String> password = Optional.ofNullable(input);
        return password.isPresent() && password.get().matches(STRONG_PASSWORD_PATTERN);
    }


    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Optional.ofNullable(username).isPresent() && Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Optional.ofNullable(password).isPresent() && Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Optional.ofNullable(mobile).isPresent() && Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Optional.ofNullable(email).isPresent() && Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Optional.ofNullable(chinese).isPresent() && Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验银行卡
     *
     * @param idBank
     * @return
     */
    public static boolean isIdBank(String idBank) {
        return Optional.ofNullable(idBank).isPresent() && Pattern.matches(REGEX_ID_BANK, idBank);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Optional.ofNullable(url).isPresent() && Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Optional.ofNullable(ipAddr).isPresent() && Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    public static boolean isNumeric(String str) {
        return Optional.ofNullable(str).isPresent() && Pattern.matches(REGEX_NUMERIC, str);
    }

    /**
     * 校验身份证号码
     *
     * @param idStr
     * @return
     */
    public static boolean isIdCard(String idStr) {
        String[] ValCodeArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4",
                "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2"};

        // 号码的长度 15位或18位
        if (idStr == null || (idStr.length() != 18) || !Pattern.matches(REGEX_ID_CARD, idStr)) {
            return false;
        }
        String Ai = idStr.substring(0, 17);

        // 出生年月是否有效
        String strYear = idStr.substring(6, 10);// 年份
        String strMonth = idStr.substring(10, 12);// 月份
        String strDay = idStr.substring(12, 14);// 月份
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                //身份证生日不在有效范围。
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            //身份证月份无效
            return false;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            //身份证日期无效
            return false;
        }

        // 地区码时候有效
        HashMap<String, String> h = getAreaCode();
        if (!h.containsKey(idStr.substring(0, 2))) {
            //身份证地区编码错误。
            return false;
        }

        //判断最后一位的值
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;
        if (Ai.equals(idStr)) {
            //身份证无效，不是合法的身份证号码
            return true;
        }
        return false;
    }

    private static HashMap<String, String> getAreaCode() {
        HashMap<String, String> map = new HashMap<>();
        map.put("11", "北京");
        map.put("12", "天津");
        map.put("13", "河北");
        map.put("14", "山西");
        map.put("15", "内蒙古");
        map.put("21", "辽宁");
        map.put("22", "吉林");
        map.put("23", "黑龙江");
        map.put("31", "上海");
        map.put("32", "江苏");
        map.put("33", "浙江");
        map.put("34", "安徽");
        map.put("35", "福建");
        map.put("36", "江西");
        map.put("37", "山东");
        map.put("41", "河南");
        map.put("42", "湖北");
        map.put("43", "湖南");
        map.put("44", "广东");
        map.put("45", "广西");
        map.put("46", "海南");
        map.put("50", "重庆");
        map.put("51", "四川");
        map.put("52", "贵州");
        map.put("53", "云南");
        map.put("54", "西藏");
        map.put("61", "陕西");
        map.put("62", "甘肃");
        map.put("63", "青海");
        map.put("64", "宁夏");
        map.put("65", "新疆");
        map.put("71", "台湾");
        map.put("81", "香港");
        map.put("82", "澳门");
        map.put("91", "国外");
        return map;
    }


}
