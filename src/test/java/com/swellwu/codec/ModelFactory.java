package com.swellwu.codec;

import com.swellwu.model.Classes;
import com.swellwu.model.Student;
import com.swellwu.model.Teacher;

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
        classes.setStudentList(Arrays.asList(new Student[]{lily, bob}));

        Teacher teacher = Teacher.getInstance();
        classes.setTeacher(teacher);

        classes.setRoomId("1001");
        return classes;
    }

}
