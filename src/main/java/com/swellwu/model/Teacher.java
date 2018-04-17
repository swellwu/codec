package com.swellwu.model;

import java.io.*;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-17
 */
public class Teacher implements Serializable {

    private String course;

    private String name;

    private String id;

    private Integer age;

    private static class InstanceHolder {
        private static final Teacher instatnce = new Teacher("math", "job", "008", 30);
    }

    public static Teacher getInstance() {
        return InstanceHolder.instatnce;
    }

    private Teacher(String course, String name, String id, Integer age) {
        this.course = course;
        this.name = name;
        this.id = id;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (id != null ? !id.equals(teacher.id) : teacher.id != null) return false;
        return age != null ? age.equals(teacher.age) : teacher.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
