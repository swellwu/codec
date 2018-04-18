package com.swellwu.codec;

import com.swellwu.model.Classes;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-18
 */
public class HessianSerializerTest {

    @Test
    public void fastJsonSerializerTest() throws IOException {
        Classes oneClasses = ModelFactory.getOneClasses();
        byte[] bytes = HessianSerializer.serialize(oneClasses);
        System.out.println("hessian serialize size:" + bytes.length);
        Classes deserialize = (Classes) HessianSerializer.deserialize(bytes);
        Assert.assertTrue(oneClasses.equals(deserialize));
    }

}