package com.deeep.mblobber.client.classes;

import com.deeep.mblobber.Interfaces.ActionResolver;

/**
 * Created by scanevaro on 06/01/2015.
 */
public class ActionResolverHtml implements ActionResolver {
    boolean signedInStateGPGS = false;

    @Override
    public boolean getSignedInGPGS() {
        return signedInStateGPGS;
    }

    @Override
    public void loginGPGS() {
        signedInStateGPGS = true;
    }

    @Override
    public void submitScoreGPGS(int score) {

    }

    @Override
    public void unlockAchievementGPGS(String achievementId) {

    }

    @Override
    public void getLeaderboardGPGS() {

    }

    @Override
    public void getAchievementsGPGS() {

    }
}
