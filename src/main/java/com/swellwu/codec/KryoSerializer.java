package com.swellwu.codec;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-18
 */
public class KryoSerializer {

    private static Kryo kryo = new Kryo();

    static {
        kryo.setReferences(true);
        kryo.setRegistrationRequired(false);
        kryo.setMaxDepth(20);
    }

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream out = null;
        Output output = null;
        try {
            out = new ByteArrayOutputStream();
            output = new Output(out, 1024);
            kryo.writeClassAndObject(output, obj);
            return output.toBytes();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (null != output) {
                output.close();
            }
        }
    }

    public static Object deserialize(byte[] bytes) {
        Input input = null;
        try {
            input = new Input(bytes, 0, 1024);
            return kryo.readClassAndObject(input);
        } finally {
            if (null != input) {
                input.close();
            }
        }
    }

}
