package JDBC_Apart.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import JDBC_Apart.Impl.PageIndex;
import lombok.Getter;

/**
 * @Title: getTotalPage
 * @Description: ��ҳ�����װ
 * @return
 * @return: Integer
 */
@Getter
public class PageResult {
	//private List listData;// ��������ݣ�SQL��ѯ
	private Integer totalCount;// �����������SQL��ѯ

	private Integer currentPage;// Ĭ�ϵ�ǰҳΪ1�����򱨿�ָ���쳣���û���������
	private Integer pageSize;// Ĭ��������СΪ3�������ָ���쳣��ÿҳ�������û���������

	private Integer prevPage;// ��ҳ���������
	private Integer nextPage;// ��ҳ�������
	private Integer totalPage;// ĩҳ����ҳ���������

	private Integer pageIndexSize = 2;// ǰ�������
	private Integer beginIndex;// ��ʼ������λ��
	private Integer endIndex;// ����������λ��

	/*
	 * public static PageResult empty(Integer pageSize) { return new PageResult(1,
	 * pageSize, Collections.EMPTY_LIST, 0);//
	 * ʹ��Collections������newһ�������飬��Ϊ1.7��ǰ�Ļ��Դ�10��Ԫ�� }
	 */

//���췽�������ڳ�ʼ����ҳ������
	public PageResult(Integer currentPage_User, Integer pageSize_User,  Integer totalCount) {
		// ������ҳ��������
		//this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage_User;
		this.pageSize = pageSize_User;
		this.totalPage = totalCount % pageSize_User == 0 ? totalCount / pageSize_User : totalCount / pageSize_User + 1;
		// ����û���ǰҳ�������ҳ��,�����ӵ�һҳ��ʼ
		if (totalPage <currentPage_User) {
			this.currentPage = 1;
		}
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;

		// ���㵱ǰҳǰ����ʾ�Ŀ�ʼ�ͽ�������
		if (currentPage <= pageSize) {
			beginIndex = 1;
		} else {
			beginIndex = currentPage - pageSize;
		}
		if (currentPage + pageSize >= totalPage) {
			endIndex = totalPage;
		} else {
			endIndex = currentPage + pageSize;
		}

	}

	@Override
	public String toString() {
		return "PageResult [totalCount=" + totalCount + ", currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", totalPage=" + totalPage + ", pageIndexSize="
				+ pageIndexSize + ", beginIndex=" + beginIndex + ", endIndex=" + endIndex + "]";
	}


}
