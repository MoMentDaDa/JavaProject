package JDBC_Apart.Object;

import lombok.Getter;

/**
 * @Title: getTotalPage
 * @Description: ��ҳ�����װ
 * @return
 * @return: Integer
 */
@Getter
public class PageResult {
	private Integer firstPage=1;// ��������ݣ�SQL��ѯ
	private Integer totalCount;// �����������SQL��ѯ

	private Integer currentPage;// Ĭ�ϵ�ǰҳΪ1�����򱨿�ָ���쳣���û���������
	private Integer pageSize;// Ĭ��������СΪ3�������ָ���쳣��ÿҳ�������û���������

	private Integer prevPage;// ��ҳ���������
	private Integer nextPage;// ��ҳ�������
	private Integer totalPage;// ĩҳ����ҳ���������

	private Integer pageIndexSize = 2;// ǰ�������
	private Integer beginIndex;// ��ʼ������λ��
	private Integer endIndex;// ����������λ��

//���췽�������ڳ�ʼ����ҳ������
	public PageResult(Integer currentPage_User, Integer pageSize_User,  Integer totalCount) {
		// ������ҳ��������
		
		this.totalCount = totalCount;
		this.currentPage = currentPage_User;
		this.pageSize = pageSize_User;
		this.totalPage = totalCount % pageSize_User == 0 ? totalCount / pageSize_User : totalCount / pageSize_User + 1;
		//����û���ǰҳ�������ҳ��,����һҳȫ���ŵ���,�����ӵ�һҳ��ʼ
		if (totalPage <currentPage_User) {
			this.currentPage = 1;
		
		}
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;

		// ���㵱ǰҳǰ����ʾ�Ŀ�ʼ�ͽ�������
		if (currentPage <= pageSize) {//�����ǰҳС��ҳ����
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
