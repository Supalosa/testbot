package com.supalosa;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.protocol.game.*;
import com.supalosa.testbot.bot.TestBot;

public class Main {

    public static void main(String[] args) {
        PlayerSettings opponent = S2Coordinator.createComputer(Race.PROTOSS, Difficulty.EASY, AiBuild.MACRO);
        LauncherUtils.startSC2(
                args,
                new TestBot(),
                BattlenetMap.of("Cloud Kingdom LE"),
                2,
                false,
                opponent);
    }
}