package com.jlt.blockchain.net.base;

import java.io.Serializable;

public class Node extends org.tio.core.Node implements Serializable {

	private static final long serialVersionUID = 6891818252530974231L;

	public Node(String ip, int port) {
		super(ip, port);
	}

	public Node() {
		super(null, 0);
	}
}
