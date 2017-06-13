package dragode.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 不同命名方式之间的转换
 *
 * @author Dragon
 * @version 1.0
 * @date 2017/6/13 0013
 */
public class NamingStrategyConverter {

    private static final String UNDERLINE = "_";
    private static final char UNDERLINE_CHAR = '_';

    /**
     * 转换驼峰命名名称成下划线命名名称,不校验是否符合驼峰命名法
     * <p>
     * eg: camelName -> camel_name
     *
     * @param camelName 驼峰命名名称
     * @return 下划线命名名称
     */
    public static String fromCamelToUnderline(String camelName) {
        String underline = "";
        if (StringUtils.isNotBlank(camelName)) {
            StringBuilder underlineBuilder = new StringBuilder();
            int length = camelName.length();
            for (int i = 0; i < length; i++) {
                char character = camelName.charAt(i);
                if (Character.isUpperCase(character)) {
                    underlineBuilder.append(UNDERLINE);
                    underlineBuilder.append(Character.toLowerCase(character));
                } else {
                    underlineBuilder.append(character);
                }
            }
            underline = underlineBuilder.toString();
        }
        return underline;
    }

    /**
     * 转换下划线命名名称成驼峰命名名称,不校验是否符合下划线命名法
     * <p>
     * eg: underline_name -> underlineName
     *
     * @param underlineName 下划线命名名称
     * @return 驼峰命名名称
     */
    public static String fromUnderlineToCamel(String underlineName) {
        String camelName = "";
        if (StringUtils.isNotBlank(underlineName)) {
            StringBuilder camelNameBuilder = new StringBuilder();
            int cycleRange = underlineName.length();
            int index = 0;
            do {
                char character = underlineName.charAt(index);
                if (UNDERLINE_CHAR == character) {
                    if (index + 1 == cycleRange) {
                        break;
                    }
                    char nextChar = underlineName.charAt(++index);
                    camelNameBuilder.append(Character.toUpperCase(nextChar));
                } else {
                    camelNameBuilder.append(character);
                }
                ++index;
            } while (index < cycleRange);
            camelName = camelNameBuilder.toString();
        }
        return camelName;
    }
}
