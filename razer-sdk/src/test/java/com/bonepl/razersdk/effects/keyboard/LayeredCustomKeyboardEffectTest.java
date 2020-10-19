package com.bonepl.razersdk.effects.keyboard;

import com.bonepl.razersdk.RazerSDKClient;
import com.bonepl.razersdk.effects.Color;
import com.bonepl.razersdk.effects.animation.AnimatedFrame;
import com.bonepl.razersdk.effects.animation.Frame;
import com.bonepl.razersdk.effects.animation.LayeredFrame;
import com.bonepl.razersdk.sdk.RzKey;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LayeredCustomKeyboardEffectTest {
    @Test
    void testLayeredKeyboardEffect() throws InterruptedException {
        try (RazerSDKClient razerSDKClient = new RazerSDKClient()) {
            final AnimatedFrame firstAnimatedFrame = createFramesFromEnum(7, 18, Color.GREEN);
            final AnimatedFrame secondAnimatedFrame = createFramesFromEnum(0, 11, Color.BLUE);
            for (int i = 0; i <= 100; i += 5) {
                LayeredFrame layeredFrame = new LayeredFrame();
                layeredFrame.addFrame(new Frame(new Color(30, 30, 0)));
                layeredFrame.addFrame(firstAnimatedFrame);
                layeredFrame.addFrame(secondAnimatedFrame);
                if (i % 10 == 0) {
                    layeredFrame.addFrame(new Frame(RzKey.RZKEY_SPACE, Color.RED));
                }
                razerSDKClient.createKeyboardEffect(layeredFrame);
                Thread.sleep(100);
            }
        }
    }

    private AnimatedFrame createFramesFromEnum(int from, int to, Color color) {
        final List<RzKey> keys = Arrays.stream(RzKey.values())
                .skip(from).limit(to)
                .collect(Collectors.toList());
        final AnimatedFrame animatedFrame = new AnimatedFrame();
        for (int i = 0; i < to; i++) {
            animatedFrame.addAnimationFrame(2, new Frame(keys.subList(0, i), color));
        }
        return animatedFrame;
    }
}