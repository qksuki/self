package pers.qksuki.test.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.qksuki.test.dao.UserDAO;

/**
 * 用户服务
 *
 * @author qksuki
 * @date 2025-04-24 06:28:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
	private UserDAO userDAO;

	public void queryUserName(String userID) {
		System.out.println(userDAO.queryById(userID));
	}
}

