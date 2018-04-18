package com.swellwu.codec;

import com.swellwu.model.Classes;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>Description:</p>
 * <p>
 * 没有默认构造函数无法反序列化
 *
 * @author heng
 * @date 2018-04-18
 */
public class JsonSerializerTest {


    @Test
    public void fastJsonSerializerTest() {
        Classes oneClasses = ModelFactory.getOneClasses();
        byte[] bytes = JsonSerializer.FastJsonSerialize(oneClasses);
        System.out.println("fast json serialize size:" + bytes.length);
        Classes deserialize = JsonSerializer.FastJsonDeserialize(bytes, Classes.class);
        Assert.assertTrue(oneClasses.equals(deserialize));
    }

    @Test
    public void jacksonSerializerTest() throws Exception {
        Classes oneClasses = ModelFactory.getOneClasses();
        byte[] bytes = JsonSerializer.JacksonSerialize(oneClasses);
        System.out.println("jackson json serialize size:" + bytes.length);
        Classes deserialize = JsonSerializer.JacksonDeserialize(bytes, Classes.class);
        Assert.assertTrue(oneClasses.equals(deserialize));
    }

}