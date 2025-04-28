package pers.qksuki.test.dao;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 dao
 *
 * @author qksuki
 * @date 2025-04-27 04:54:56
 */
@Data
public class UserDAO {
	private static Map<String, String> map = new HashMap<>();

	static {
		map.put("10001", "顶针");
		map.put("10002", "丁针");
		map.put("10003", "丁真");
	}

	public String queryById(String id) {
		return map.get(id);
	}
}

