package Day05.Impl;

import java.sql.ResultSet;

//���������淶�ӿ�
public interface ResultUtil<T> {
//��ͳ��ʽ��������
	T handle(ResultSet rs) throws Exception;
}
