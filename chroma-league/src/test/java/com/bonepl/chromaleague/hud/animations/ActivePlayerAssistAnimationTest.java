package com.bonepl.chromaleague.hud.animations;

import org.junit.jupiter.api.Test;

class ActivePlayerAssistAnimationTest {

    @Test
    void testActivePLayerAssistAnimation() {
        new AnimationTester().testAnimation(new ActivePlayerAssistAnimation());
    }
}