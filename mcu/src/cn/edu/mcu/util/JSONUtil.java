package cn.edu.mcu.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JSONUtil {

	public static JSONObject toJSON(int status, Object o) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("status", status);
		resultMap.put("data", o);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		return JSONObject.fromObject(resultMap, jsonConfig);
	}
}
