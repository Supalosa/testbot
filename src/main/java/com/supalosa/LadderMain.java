package com.supalosa;

import com.supalosa.testbot.bot.TestBot;

public class LadderMain {

    public static void main(String[] args) {
        TestBot testBot = new TestBot();
        LauncherUtils.startLadder(args, 20, testBot);
    }
}