package dragode.utils.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.GUIDGenerator;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 如果主键显式设定了值，则用设定的值，不自动生成ID
 * <p>
 * 因为primitive type无法设置成bull值，所以对primitive type无效
 *
 * @author Dragode
 */
//TODO 写TestCase
public class SimpleUuidGenerator extends GUIDGenerator {

    private String idField;
    private IdentifierGenerator identifierGenerator;

    public SimpleUuidGenerator(String idField, IdentifierGenerator identifierGenerator) {
        this.idField = idField;
        this.identifierGenerator = identifierGenerator;
    }

    @Override
    public Serializable generate(SessionImplementor session, Object entity) throws HibernateException {
        if (entity != null) {
            try {
                Field declaredField = entity.getClass().getDeclaredField(idField);
                Object value = declaredField.get(entity);//TODO 是否是这样获取属性？如果entity是null，会怎么样？
                if (value != null
                        && value instanceof Serializable) {
                    return (Serializable) value;
                }
            } catch (NoSuchFieldException e) {
                //不存在idField对应的属性，则用GUIDGenerator生成
            } catch (IllegalAccessException e) {
                return super.generate(session, entity);
                //不存在idField对应的属性，则用GUIDGenerator生成
            }
        }

        return identifierGenerator.generate(session, entity);
    }
}
