package com.example.demo.pattern.command;

public class CommandReceiverImpl  implements CommandReceiver{

	@Override
	public void dosomethingA() {
		System.out.println("命令接受人执行命令A");
	}

	@Override
	public void dosomethingB() {
		System.out.println("命令接受人执行命令B");
	}

}
