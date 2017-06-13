package dragode.utils;

import org.junit.Assert;
import org.junit.Test;

import static dragode.utils.ClassUtils.getFieldClass;
import static dragode.utils.ClassUtils.hasField;

/**
 * <p></p>
 *
 * @author Dragon(300116)
 * @version 1.0
 * @date 2017/6/13 0013
 */
public class ClassUtilsTest {

    @Test
    public void hasFieldTest() throws Exception {
        Assert.assertTrue(hasField(TestClass.class, "name"));
    }

    @Test
    public void hasNotFieldTest() throws Exception {
        Assert.assertFalse(hasField(TestClass.class, "falseName"));
    }

    @Test
    public void getFieldClassTest() throws Exception {
        Class clazz = getFieldClass(TestClass.class, "name");
        Assert.assertTrue(clazz == String.class);
    }

    @Test(expected = RuntimeException.class)
    public void getFieldClassTestFail() throws Exception {
        getFieldClass(TestClass.class, "falseName");
    }

    class TestClass {
        private String name;
    }
}