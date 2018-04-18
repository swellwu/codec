package com.swellwu.codec;

import com.swellwu.model.Classes;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-18
 */
public class ProtostuffSerializerTest {

    @Test
    public void test(){
        Classes oneClasses = ModelFactory.getOneClasses();
        byte[] bytes = ProtostuffSerializer.serialize(oneClasses);
        System.out.println("protostuff serialize size:" + bytes.length);
        Classes deserialize = ProtostuffSerializer.deserialize(bytes, Classes.class);
        Assert.assertTrue(oneClasses.equals(deserialize));
    }

}
