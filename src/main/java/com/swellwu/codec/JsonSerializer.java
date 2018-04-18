package com.swellwu.codec;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-18
 */
public class JsonSerializer {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 使用fastjson实现序列化和反序列化
     *
     * @param object
     * @return
     */
    public static byte[] FastJsonSerialize(Object object) {
        byte[] bytes = JSON.toJSONBytes(object);
        return bytes;
    }

    /**
     * fastjosn反序列化时，class必须要有默认构造函数，否则报错
     *
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T FastJsonDeserialize(byte[] bytes, Class clazz) {
        return (T) JSON.parseObject(bytes, clazz);
    }

    public static byte[] JacksonSerialize(Object object) throws JsonProcessingException {
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T JacksonDeserialize(byte[] bytes, final Class clazz) throws IOException {
        TypeReference<T> typeReference = new TypeReference<T>() {
            @Override
            public Type getType() {
                return clazz;
            }
        };
        return (T) mapper.readValue(bytes, typeReference);
    }
}
