package com.song.alipay.util;


import com.song.alipay.common.ErrorConstantEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回值工具
 * 
 * @author fuxian
 * 
 */
public class ReturnMapUtil {

	public static Map<String, Object> getOKResult() {
		return getOKResult(null);
	}

	/**
	 * 获取成功map
	 * 
	 */
	public static Map<String, Object> getOKResult(Map<String, Object> returnMap) {
		return setReturnHeader(returnMap, ErrorConstantEnum.OK);
	}

	/**
	 * 获取失败map
     */
	public static Map<String, Object> getErrorResult( ErrorConstantEnum errorConstants ) {
		return setReturnHeader( null, errorConstants );
	}



	/**
	 * 自定义错误，返回的编号统一是6000，方便后台使用
	 */
	public static Map<String, Object> getErrorResult( String errorMsg ) {
		String [] error = new String[] {"6000", errorMsg};
		return setReturnHeader( error );
	}

	public static Map<String, Object> getErrorResult(
			Map<String, Object> returnMap, ErrorConstantEnum errorConstants) {
		return setReturnHeader(returnMap, errorConstants);
	}



	private static Map<String, Object> setReturnHeader(
			Map<String, Object> bodyMap, ErrorConstantEnum errorConstants) {
		Map<String, Object> map = new HashMap<>();

		Map<String, Object> headMap = new HashMap<>();
		headMap.put("code", errorConstants.getCode());
		headMap.put("msg", errorConstants.getMsg());

		if (bodyMap == null) {
			bodyMap = new HashMap<String, Object>();
		}

		map.put("responseHead", headMap);
		map.put("responseBody", bodyMap);

		return map;
	}

	private static Map<String, Object> setReturnHeader(String[] error) {
		Map<String, Object> map = new HashMap<>();

		Map<String, Object> headMap = new HashMap<>();
		headMap.put("code", error[0]);
		headMap.put("msg", error[1]);

		Map<String, Object> bodyMap = new HashMap<String, Object>();

		map.put("responseHead", headMap);
		map.put("responseBody", bodyMap);

		return map;
	}
}
