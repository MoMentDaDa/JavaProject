package com.wang.Impl;

import com.wang.Domain.PageResult;
import com.wang.Params.QueryParams;

public interface IEmployee {
	PageResult limtQuery(QueryParams qo);
}
