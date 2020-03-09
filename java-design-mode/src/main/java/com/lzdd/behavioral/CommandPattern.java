package com.lzdd.behavioral;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 2:50 下午
 * 命令模式
 * 定义：将请求封装成一个对象，使发出请求的责任和执行请求的责任分开。
 * 关键点：invoker是调用者，通过命令调用接受者 receiver
 * 理解记忆：invoker调用command的方法，command聚合多个命令执行者，执行命令
 **/
public class CommandPattern {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new Command1());
        invoker.cell();
    }
}

interface ICommand{
    void execute();
}

class Invoker{
    private ICommand command;

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void cell(){
        command.execute();
    }
}

class Command1 implements ICommand{
    private Receiver receiver = new Receiver();
    @Override
    public void execute() {
        System.out.println("Command1 命令已接受");
        receiver.doAction();
    }
}

class Receiver{
    public void doAction(){
        System.out.println("Receiver 正在处理命令");
    }
}