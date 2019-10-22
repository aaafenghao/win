package com.example.demo.pattern.command;

public interface Command {
	
	/**
	 * 执行命令，参数是命令接受人
	 * @param receiver
	 */
	 void execute(CommandReceiver receiver);

}
