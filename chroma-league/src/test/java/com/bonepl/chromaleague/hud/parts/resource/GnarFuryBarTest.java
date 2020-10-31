package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.GameStateMocks;
import com.bonepl.chromaleague.hud.animations.AnimationTester;
import com.bonepl.chromaleague.rest.activeplayer.ChampionStats;
import com.bonepl.chromaleague.state.RunningState;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

class GnarFuryBarTest {
    public static int currentResource;
    public static double currentRange = 400;

    @Test
    void testGnarFuryBar() {
        RunningState.setRunningGame(true);
        currentResource = 0;
        final GnarFuryBar gnarFuryBar = new GnarFuryBar();

        new AnimationTester()
                .withAfterIterationAction(integer -> {
                    if (integer < 120) {
                        if (currentResource < 100) {
                            currentResource++;
                        }
                        currentRange = 400;
                    } else if (integer > 150) {
                        if (currentResource > 0) {
                            currentResource -= 2;
                        }
                        currentRange = 170;
                    }
                    mockResourceAndRange(currentResource, 100, currentRange);
                })
                .testAnimation(gnarFuryBar, 220);
    }

    private static void mockResourceAndRange(double resource, double maxResource, double range) {
        final ChampionStats mockedChampionStats = GameStateMocks.getMockedChampionStats();
        when(mockedChampionStats.getResourceValue()).thenReturn(resource);
        when(mockedChampionStats.getResourceMax()).thenReturn(maxResource);
        when(mockedChampionStats.getAttackRange()).thenReturn(range);
    }
}