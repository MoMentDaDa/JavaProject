package Day05.test;

import java.util.List;
import org.junit.Test;
import Day05.DaoMain.Student;
import Day05.Impl.ImplementslAchieveDemo;
import Day05.Impl.StudentDaoInterface;

public class StudentDaoInterfaceTest {
	StudentDaoInterface dao = new ImplementslAchieveDemo();

	@Test
	public void testSava() {
		Student stu = new Student();
		stu.setName("Œ‰√ƒƒÔ");
		stu.setId(6);
		dao.sava(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(6);
	}

	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setEmail("ghfkh5431@qq.com");
		stu.setAge(13);
		dao.update(6, stu);
	}

	@Test
	public void testGet() {
		dao.get(5).toString();
		System.out.println();
	}

	@Test
	public void testListAll() {
		List<Student> list = dao.listAll();
		System.out.println(list);
	}

}
