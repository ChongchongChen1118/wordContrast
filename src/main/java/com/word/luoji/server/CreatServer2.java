package com.word.luoji.server;

public class CreatServer2 implements Factory{
    @Override
    public ServerAbstract creatServer() {
        return new Server2();
    }
}
