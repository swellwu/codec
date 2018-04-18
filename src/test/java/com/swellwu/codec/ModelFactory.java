package com.swellwu.codec;

import com.swellwu.model.Classes;
import com.swellwu.model.Student;
import com.swellwu.model.Teacher;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-17
 */
public class ModelFactory {

    public static Classes getOneClasses() {
        Classes classes = new Classes();

        Student lily = new Student("lily", "001", 18);
        Student bob = new Student("bob", "002", 19);
        ArrayList<Student> list = new ArrayList<>();
        list.add(lily);
        list.add(bob);
        classes.setStudentList(list);

        Teacher teacher = Teacher.getInstance();
        classes.setTeacher(teacher);

        classes.setRoomId("1001");
        return classes;
    }

}
