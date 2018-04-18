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
public class KryoSerializerTest {


    /**
     * 特别注意，如果有Arrays.asList 的list 会导致反序列化失败
     * 在kryo中 接口  抽象类是无法反 序列化的
     *
     * Arrays.asList()得到ArrayList
     * 这个ArrayList不是java.util包下的，而是java.util.Arrays.ArrayList，
     * 显然它是Arrays类自己定义的一个内部类！这个内部类没有实现add()、remove()方法，
     * 而是直接使用它的父类AbstractList的相应方法。
     *
     * @throws IOException
     */
    @Test
    public void fastJsonSerializerTest() throws IOException {
        Classes oneClasses = ModelFactory.getOneClasses();
        byte[] bytes = KryoSerializer.serialize(oneClasses);
        System.out.println("kryo serialize size:" + bytes.length);
        Classes deserialize = (Classes) KryoSerializer.deserialize(bytes);
        Assert.assertTrue(oneClasses.equals(deserialize));
    }
}