package JDBC_Apart.Impl;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: PageIndex
 * @Description: ��ʼ�ͽ���ҳ�빤����
 * @author: ������
 * @return
 * @date: 2019��7��6�� ����3:47:29
 */
@Setter
@Getter
public class PageIndex {
	 int pageCount = 0; // ҳ������
	 int showCount = 0; // ��ʾ����
		 int index = 0; // ����
		  int pageSize = 2;
		  int begin ; // ��ʼλ��
		  int end ; // ����λ��

	/*public PageIndex(int pageCount, int showCount, int index) {
		super();
		this.pageCount = pageCount;
		this.showCount = showCount;
		this.index = index > pageCount ? pageCount : index;
		System.out.println("index:" + this.index);

		// ���м���
		int number = showCount / 2;
		int last = number % 2;
		if (last != 0) {
			this.begin = this.index - number;
			this.end = this.index + number;
		} else {
			this.begin = this.index - number - 1;
			this.end = this.index + number;
		}
		// ������ʾ�ͽ�����ֵ ���������ͳ���

		// ���beginΪ���� ��ȡ����ֵ��end
		if (begin < 0) {
			end += Math.abs(begin);
			begin = end - showCount;
		}
		// ���end������ҳ�� �͵�����ҳ��
		if (end > pageCount) {
			end = pageCount;
		}

		// ҳ���1��ʼ
		begin += 1;

		// ������һҳ�����һҳ
		begin += 1;
		end = end + 1 < pageCount ? end + 1 : pageCount - 1;
	}

	public PageIndex() {
		super();
	}

	@Override
	public String toString() {
		return "PageIndex [pageCount=" + pageCount + ", showCount=" + showCount + ", begin=" + begin + ", end=" + end
				+ ", index=" + index + "]";
	}

			public PageIndex(Integer totalPage, Integer currentPage) {
				if (currentPage <= pageSize) {
					begin=1;
				} else {
					begin = currentPage - pageSize;
				}
				if (currentPage + pageSize >= totalPage) {
					end = totalPage;

				} else {
					end = currentPage + pageSize;
				}
				//System.out.println("ǰ�濪ʼ��"+begin+"������"+end+"��ǰҳ��"+currentPage);
			}
	public static PageIndex getPageIndex(Integer totalPage, Integer currentPage) {
		
	}*/

}
