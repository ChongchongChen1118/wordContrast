package com.word.luoji.server;

public class CreatServer1 implements Factory{
    @Override
    public ServerAbstract creatServer() {
        return new Server1();
    }
}
