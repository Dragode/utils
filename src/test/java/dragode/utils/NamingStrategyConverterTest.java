package dragode.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import static dragode.utils.NamingStrategyConverter.fromCamelToUnderline;
import static dragode.utils.NamingStrategyConverter.fromUnderlineToCamel;

/**
 * TestCase
 *
 * @author Dragon
 * @version 1.0
 * @date 2017/6/13 0013
 */
public class NamingStrategyConverterTest {
    @Test
    public void fromCamelToUnderlineTest() {
        String camel = "camelName";
        String underline = fromCamelToUnderline(camel);
        Assert.assertTrue(StringUtils.equals(underline, "camel_name"));
    }

    @Test
    public void fromCamelToUnderlineTestAllLowerCase() {
        String camel = "camel";
        String underline = fromCamelToUnderline(camel);
        Assert.assertTrue(StringUtils.equals(underline, "camel"));
    }

    @Test
    public void fromUnderlineToCamelTest() {
        String camel = "underline_name";
        String underline = fromUnderlineToCamel(camel);
        Assert.assertTrue(StringUtils.equals(underline, "underlineName"));
    }

    @Test
    public void fromUnderlineToCamelUnderlineAtEndTest() {
        String camel = "underline_";
        String underline = fromUnderlineToCamel(camel);
        Assert.assertTrue(StringUtils.equals(underline, "underline"));
    }

    @Test
    public void fromUnderlineToCamelUnderlineAtStartTest() {
        String camel = "_underline";
        String underline = fromUnderlineToCamel(camel);
        Assert.assertTrue(StringUtils.equals(underline, "Underline"));
    }

}