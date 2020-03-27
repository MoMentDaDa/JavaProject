package Day03.Test;

import java.util.List;

import org.junit.Test;

import Day03.Impl2.Implement;
import Day03.Impl2.StudentMethod;
import Day03.daomain.Student;
import DoaPractice.daomain.Students;

public class StudentMethodTest {
	StudentMethod dao = new Implement();

	@Test
	public void testSava() {
		Students stu = new Students();
		stu.setId(8);
		stu.setName("ÎäÃÄÄï");
		stu.setAge(88);
		stu.setEmail("adgga@qq.com");
		dao.sava(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(8);
	}

	@Test
	public void testUpdate() {
		Students stu = new Students();
		stu.setName("ÎäÃÄÄï");
		stu.setAge(2);
		dao.update(8, stu);
	}

	@Test
	public void testGet() {
		System.out.println(dao.get(2).toString());
	}

	@Test
	public void testListAll() {
		List<Student> student = dao.ListAll();
		for (Student s : student) {
			System.out.println(s.toString());
		}
	}
}
