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
 * @Description: 分页结果封装
 * @return
 * @return: Integer
 */
@Getter
public class PageResult {
	//private List listData;// 结果集数据，SQL查询
	private Integer totalCount;// 结果总条数，SQL查询

	private Integer currentPage;// 默认当前页为1，否则报空指针异常，用户传入设置
	private Integer pageSize;// 默认条数大小为3，否则空指针异常，每页条数，用户传入设置

	private Integer prevPage;// 上页，计算出来
	private Integer nextPage;// 下页计算出来
	private Integer totalPage;// 末页，总页数计算出来

	private Integer pageIndexSize = 2;// 前后各两个
	private Integer beginIndex;// 开始索引的位置
	private Integer endIndex;// 结束索引的位置

	/*
	 * public static PageResult empty(Integer pageSize) { return new PageResult(1,
	 * pageSize, Collections.EMPTY_LIST, 0);//
	 * 使用Collections工具类new一个空数组，因为1.7以前的会自带10个元素 }
	 */

//构造方法，用于初始化翻页等数据
	public PageResult(Integer currentPage_User, Integer pageSize_User,  Integer totalCount) {
		// 计算总页数、条数
		//this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage_User;
		this.pageSize = pageSize_User;
		this.totalPage = totalCount % pageSize_User == 0 ? totalCount / pageSize_User : totalCount / pageSize_User + 1;
		// 如果用户当前页码大于总页码,让它从第一页开始
		if (totalPage <currentPage_User) {
			this.currentPage = 1;
		}
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;

		// 计算当前页前后显示的开始和结束索引
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
