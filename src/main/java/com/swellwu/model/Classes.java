package com.swellwu.model;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description:</p>
 *
 * @author heng
 * @date 2018-04-17
 */
public class Classes implements Serializable{

    String roomId;

    Teacher teacher;

    List<Student> studentList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classes classes = (Classes) o;

        if (roomId != null ? !roomId.equals(classes.roomId) : classes.roomId != null) return false;
        if (teacher != null ? !teacher.equals(classes.teacher) : classes.teacher != null) return false;
        return studentList != null ? studentList.equals(classes.studentList) : classes.studentList == null;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (studentList != null ? studentList.hashCode() : 0);
        return result;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
