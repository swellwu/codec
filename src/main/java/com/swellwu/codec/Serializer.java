package com.swellwu.codec;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-17
 */
public interface Serializer {

    byte[] serialize(Object object);

    Object deserialize(byte[] bytes);
}
