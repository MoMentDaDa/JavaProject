package JDBC_Apart.Dao;

import java.sql.ResultSet;

//���������淶�ӿ�
public interface ResultUtil<T> {
//��ͳ��ʽ��������
	T handle(ResultSet rs) throws Exception;
}
