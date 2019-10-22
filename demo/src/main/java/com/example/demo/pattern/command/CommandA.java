package com.example.demo.pattern.command;

public class CommandA implements Command {

	@Override
	public void execute(CommandReceiver receiver) {
		receiver.dosomethingA();
	}

}
