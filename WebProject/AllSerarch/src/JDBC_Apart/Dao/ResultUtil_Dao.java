package JDBC_Apart.Dao;

import java.sql.ResultSet;

//���������淶�ӿ�
public interface ResultUtil_Dao<T> {
//��ͳ��ʽ��������
	T handle(ResultSet rs) throws Exception;
}
