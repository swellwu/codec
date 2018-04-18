# 常见序列化方式
## jdk 
### Serializer
主要四个方法,`writeReplace`、`writeObject`、`readObject`、`readResolve`方法即可。
```java

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("teacher writeReplace");
        return this;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("teacher writeObject");
        out.writeObject(course);
        out.writeObject(name);
        out.writeObject(id);
        out.writeObject(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("teacher readObject");
        course = (String) in.readObject();
        name = (String) in.readObject();
        id = (String) in.readObject();
        age = (Integer) in.readObject();
    }
    
    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }
```
当进行序列化的时候: 
首先JVM会先调用writeReplace方法,在这个阶段,我们可以进行张冠李戴,将需要进行序列化的对象换成我们指定的对象. 
跟着JVM将调用writeObject方法,来将对象中的属性一个个进行序列化,我们可以在这个方法中控制住哪些属性需要序列化. 

当反序列化的时候: 
JVM会调用readObject方法,将我们刚刚在writeObject方法序列化好的属性,反序列化回来. 
然后在readResolve方法中,我们也可以指定JVM返回我们特定的对象(不是刚刚序列化回来的对象). 

注意到在writeReplace和readResolve,我们可以严格控制singleton的对象,在同一个JVM中完完全全只有唯一的对象,控制不让singleton对象产生副本. 
### Externalizable 
Externalizable 接口实现了Serializer接口，并定义了两个接口：writeExternal、readExternal。
Externalizable和Serializer区别：
1. Externalizable接口优先，如果实现了Externalizable接口，则序列化和反序列化会调用writeExternal、readExternal。
2. Externalizable反序列化时，不要要有无参构造函数，Serializer则不需要。

## json
fast json/jackson 序列化，反序列化时注意类必须要有默认构造函数，否则会抛异常。

## protostuff
序列化后字节非常小，无需默认构造函数
