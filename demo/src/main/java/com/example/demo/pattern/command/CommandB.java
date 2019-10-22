package com.example.demo.pattern.command;

public class CommandB implements Command {

	@Override
	public void execute(CommandReceiver receiver) {
		receiver.dosomethingB();
	}

}
