package org.rockyang.blockchain.web.vo.res;

import org.rockyang.blockchain.account.Account;

/**
 * account VO
 * @author yangjian
 * @since 18-7-14
 */
public class AccountVo extends Account {

	private static final long serialVersionUID = -7047655279173436347L;

	@Override
	public String toString() {
		return "AccountVo{" +
				"address='" + address + '\'' +
				", priKey='" + priKey + '\'' +
				'}';
	}
}
