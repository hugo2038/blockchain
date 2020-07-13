package com.jlt.blockchain.web.vo.res;

import com.jlt.blockchain.account.Account;

/**
 * account VO
 * 
 */
public class AccountVo extends Account {

	private static final long serialVersionUID = 2890977750572746537L;

	@Override
	public String toString() {
		return "AccountVo{" +
				"address='" + address + '\'' +
				", priKey='" + priKey + '\'' +
				'}';
	}
}
