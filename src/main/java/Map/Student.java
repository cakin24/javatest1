package Map;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: Student
 * @description: 学生类
 * @date: 2020/4/19
 * @author: cakin
 */
public class Student {

	public String id;
	
	public String name;
	
	public Set<Course> courses;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
}
