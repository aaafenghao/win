package com.example.demo.pattern.command;

public class CommandDemo {
	
	/**
	 * 将命令接受者，封装到命令执行者内部
	 * 将命令传入命令执行者内部
	 * 然后调用命令执行者execute方法，实际调用的是具体命令的execute
	 * 具体命令内部需要命令接受者作为参数，该参数由命令执行者提供
	 * 最后调用的是命令接受的执行的方法
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutor();
		CommandA a = new CommandA();
		executor.execute(a);
		CommandB b = new CommandB();
		executor.execute(b);
	}

}
