package com.supalosa;

import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.Race;

public class LauncherUtils {
    public static void startLadder(String[] pArgs, int stepSize, S2Agent pBot) {
        S2Coordinator vS2Coordinator = S2Coordinator.setup()
                .setTimeoutMS(300000)
                .setRawAffectsSelection(true)
                .setShowCloaked(true)
                .setShowBurrowed(true)
                .setRealtime(false)
                .setStepSize(stepSize)
                .loadLadderSettings(pArgs)
                .setParticipants(S2Coordinator.createParticipant(Race.TERRAN, pBot))
                .connectToLadder()
                .joinGame();
        executeCoordinator(vS2Coordinator);
    }

    public static void startSC2(String[] pArgs, S2Agent pBot, BattlenetMap pMap, int stepSize, boolean pRealtime, PlayerSettings pAI) {
        PlayerSettings[] participants = new PlayerSettings[2];
        participants[0] = S2Coordinator.createParticipant(Race.TERRAN, pBot, "testbot");
        participants[1] = pAI;
        S2Coordinator vS2Coordinator = S2Coordinator.setup().setRealtime(pRealtime).setRawAffectsSelection(false)
                .loadSettings(pArgs)
                .setShowCloaked(true)
                .setShowBurrowed(true)
                .setStepSize(stepSize)
                .setParticipants(participants)
                .launchStarcraft()
                .startGame(pMap);
        executeCoordinator(vS2Coordinator);
    }

    private static void executeCoordinator(S2Coordinator pS2Coordinator) {
        while (pS2Coordinator.update()) {
        }
        pS2Coordinator.quit();
    }
}
