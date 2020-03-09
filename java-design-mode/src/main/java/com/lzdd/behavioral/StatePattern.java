package com.lzdd.behavioral;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 11:22 上午
 * 状态模式
 * 定义：对于有状态的对象，将状态的负责逻辑提取到状态对象中，允许内部状态发生改变时改变其行为。
 * 关键点：Context环境类，调用状态方法
 * 理解记忆：具体的状态转换逻辑在状态类中进行
 **/
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.handler();
        context.handler();
        context.handler();
        context.handler();
    }

}

interface IState {
    void handle(Context context);
}

/**
 * 环境类，提供给客户端感兴趣的接口
 */
class Context{
    private IState state;

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void handler(){
        if (this.state == null){
            this.state = new State1();
        }
        this.state.handle(this);
    }
}


class State1 implements IState{

    @Override
    public void handle(Context context) {
        System.out.println("state1 处理逻辑,切换到状态2");
        context.setState(new State2());
    }
}

class State2 implements IState{

    @Override
    public void handle(Context context) {
        System.out.println("state2 处理逻辑，切换到状态1");
        context.setState(new State1());
    }
}