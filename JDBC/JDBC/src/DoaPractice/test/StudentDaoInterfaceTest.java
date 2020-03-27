package DoaPractice.test;

import java.util.List;

import org.junit.Test;

import DoaPractice.Impl.ImplementslAchieveDemo;
import DoaPractice.Impl.StudentDaoInterface;
import DoaPractice.daomain.Students;

public class StudentDaoInterfaceTest {
	private StudentDaoInterface dao = new ImplementslAchieveDemo();

	@Test
	public void testSava() {
		Students stu = new Students();
		stu.setId(5);
		stu.setName("凌平志");
		stu.setAge(17);
		stu.setEmail("adgga@qq.com");
		dao.sava(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(12);
	}

	@Test
	public void testUpdate() {
		Students stu = new Students();
		stu.setName("东方不败");
		stu.setAge(20);
		dao.update(12, stu);
	}

	@Test
	public void testGet() {
		Students stu = dao.get(2);
		System.out.println(stu.toString());

	}

	@Test
	public void testListAll() {
		List<Students> student = dao.listAll();
		for (Students students : student) {
			System.out.println(students.toString());
		}

	}

}
