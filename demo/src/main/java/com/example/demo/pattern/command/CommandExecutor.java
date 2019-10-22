package com.example.demo.pattern.command;

/**
 * 命令执行者
 * @author pc
 *
 */
public class CommandExecutor {
	
	public void execute(Command command) {
		command.execute(new CommandReceiverImpl());
	}

}
