package JDBC_Apart.Impl;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: PageIndex
 * @Description: 开始和结束页码工具类
 * @author: 汪哒哒
 * @return
 * @date: 2019年7月6日 下午3:47:29
 */
@Setter
@Getter
public class PageIndex {
	 int pageCount = 0; // 页码数量
	 int showCount = 0; // 显示数量
		 int index = 0; // 索引
		  int pageSize = 2;
		  int begin ; // 开始位置
		  int end ; // 结束位置

	/*public PageIndex(int pageCount, int showCount, int index) {
		super();
		this.pageCount = pageCount;
		this.showCount = showCount;
		this.index = index > pageCount ? pageCount : index;
		System.out.println("index:" + this.index);

		// 进行计算
		int number = showCount / 2;
		int last = number % 2;
		if (last != 0) {
			this.begin = this.index - number;
			this.end = this.index + number;
		} else {
			this.begin = this.index - number - 1;
			this.end = this.index + number;
		}
		// 计算启示和结束的值 不允许负数和超出

		// 如果begin为负数 就取绝对值给end
		if (begin < 0) {
			end += Math.abs(begin);
			begin = end - showCount;
		}
		// 如果end大于总页数 就等于总页数
		if (end > pageCount) {
			end = pageCount;
		}

		// 页码从1开始
		begin += 1;

		// 保留第一页和最后一页
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
				//System.out.println("前面开始："+begin+"结束："+end+"当前页："+currentPage);
			}
	public static PageIndex getPageIndex(Integer totalPage, Integer currentPage) {
		
	}*/

}
