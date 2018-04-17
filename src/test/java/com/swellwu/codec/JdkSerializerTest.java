package com.swellwu.codec;

import com.swellwu.model.Classes;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-17
 */
public class JdkSerializerTest {

    Serializer jdkSerializer = new JdkSerializer();

    Classes classes = ModelFactory.getOneClasses();

    @Test
    public void serializeTest() {
        byte[] bytes = jdkSerializer.serialize(classes);
        Assert.assertTrue(bytes != null);
        Classes obj = (Classes) jdkSerializer.deserialize(bytes);
        Assert.assertTrue(obj != null);
        Assert.assertTrue(classes.equals(obj));
        //单例模式反序列化后为相同对象
        Assert.assertTrue(classes.getTeacher() == obj.getTeacher());
    }

}
