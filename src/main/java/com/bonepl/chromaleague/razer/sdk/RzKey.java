package com.bonepl.chromaleague.razer.sdk;

import com.bonepl.chromaleague.razer.effects.keyboard.OneKeyPartialEffect;

public enum RzKey {

    RZKEY_ESC(0x0001),
    RZKEY_F1(0x0003),
    RZKEY_F2(0x0004),
    RZKEY_F3(0x0005),
    RZKEY_F4(0x0006),
    RZKEY_F5(0x0007),
    RZKEY_F6(0x0008),
    RZKEY_F7(0x0009),
    RZKEY_F8(0x000A),
    RZKEY_F9(0x000B),
    RZKEY_F10(0x000C),
    RZKEY_F11(0x000D),
    RZKEY_F12(0x000E),
    RZKEY_1(0x0102),
    RZKEY_2(0x0103),
    RZKEY_3(0x0104),
    RZKEY_4(0x0105),
    RZKEY_5(0x0106),
    RZKEY_6(0x0107),
    RZKEY_7(0x0108),
    RZKEY_8(0x0109),
    RZKEY_9(0x010A),
    RZKEY_0(0x010B),
    RZKEY_A(0x0302),
    RZKEY_B(0x0407),
    RZKEY_C(0x0405),
    RZKEY_D(0x0304),
    RZKEY_E(0x0204),
    RZKEY_F(0x0305),
    RZKEY_G(0x0306),
    RZKEY_H(0x0307),
    RZKEY_I(0x0209),
    RZKEY_J(0x0308),
    RZKEY_K(0x0309),
    RZKEY_L(0x030A),
    RZKEY_M(0x0409),
    RZKEY_N(0x0408),
    RZKEY_O(0x020A),
    RZKEY_P(0x020B),
    RZKEY_Q(0x0202),
    RZKEY_R(0x0205),
    RZKEY_S(0x0303),
    RZKEY_T(0x0206),
    RZKEY_U(0x0208),
    RZKEY_V(0x0406),
    RZKEY_W(0x0203),
    RZKEY_X(0x0404),
    RZKEY_Y(0x0207),
    RZKEY_Z(0x0403),
    RZKEY_NUMLOCK(0x0112),
    RZKEY_NUMPAD0(0x0513),
    RZKEY_NUMPAD1(0x0412),
    RZKEY_NUMPAD2(0x0413),
    RZKEY_NUMPAD3(0x0414),
    RZKEY_NUMPAD4(0x0312),
    RZKEY_NUMPAD5(0x0313),
    RZKEY_NUMPAD6(0x0314),
    RZKEY_NUMPAD7(0x0212),
    RZKEY_NUMPAD8(0x0213),
    RZKEY_NUMPAD9(0x0214),
    RZKEY_NUMPAD_DIVIDE(0x0113),
    RZKEY_NUMPAD_MULTIPLY(0x0114),
    RZKEY_NUMPAD_SUBTRACT(0x0115),
    RZKEY_NUMPAD_ADD(0x0215),
    RZKEY_NUMPAD_ENTER(0x0415),
    RZKEY_NUMPAD_DECIMAL(0x0514),
    RZKEY_PRINTSCREEN(0x000F),
    RZKEY_SCROLL(0x0010),
    RZKEY_PAUSE(0x0011),
    RZKEY_INSERT(0x010F),
    RZKEY_HOME(0x0110),
    RZKEY_PAGEUP(0x0111),
    RZKEY_DELETE(0x020f),
    RZKEY_END(0x0210),
    RZKEY_PAGEDOWN(0x0211),
    RZKEY_UP(0x0410),
    RZKEY_LEFT(0x050F),
    RZKEY_DOWN(0x0510),
    RZKEY_RIGHT(0x0511),
    RZKEY_TAB(0x0201),
    RZKEY_CAPSLOCK(0x0301),
    RZKEY_BACKSPACE(0x010E),
    RZKEY_ENTER(0x030E),
    RZKEY_LCTRL(0x0501),
    RZKEY_LWIN(0x0502),
    RZKEY_LALT(0x0503),
    RZKEY_SPACE(0x0507),
    RZKEY_RALT(0x050B),
    RZKEY_FN(0x050C),
    RZKEY_RMENU(0x050D),
    RZKEY_RCTRL(0x050E),
    RZKEY_LSHIFT(0x0401),
    RZKEY_RSHIFT(0x040E),
    RZKEY_MACRO1(0x0100),
    RZKEY_MACRO2(0x0200),
    RZKEY_MACRO3(0x0300),
    RZKEY_MACRO4(0x0400),
    RZKEY_MACRO5(0x0500),
    RZKEY_OEM_1(0x0101), // ~ `
    RZKEY_OEM_2(0x010C), // - _
    RZKEY_OEM_3(0x010D), // = +
    RZKEY_OEM_4(0x020C), // [ {
    RZKEY_OEM_5(0x020D), // ] }
    RZKEY_OEM_6(0x020E), // \ |
    RZKEY_OEM_7(0x030B), // ; :
    RZKEY_OEM_8(0x030C), // ' "
    RZKEY_OEM_9(0x040A), // , <
    RZKEY_OEM_10(0x040B), // . >
    RZKEY_OEM_11(0x040C), // / ?
    RZKEY_EUR_1(0x030D),
    RZKEY_EUR_2(0x0402),
    RZKEY_JPN_1(0x0015),
    RZKEY_JPN_2(0x040D),
    RZKEY_JPN_3(0x0504),
    RZKEY_JPN_4(0x0509),
    RZKEY_JPN_5(0x050A),
    RZKEY_KOR_1(0x0015),
    RZKEY_KOR_2(0x030D),
    RZKEY_KOR_3(0x0402),
    RZKEY_KOR_4(0x040D),
    RZKEY_KOR_5(0x0504),
    RZKEY_KOR_6(0x0509),
    RZKEY_KOR_7(0x050A);

    private final int rzSDKKey;

    RzKey(int rzSDKKey) {
        this.rzSDKKey = rzSDKKey;
    }

    public int getRzSDKKey() {
        return rzSDKKey;
    }

    public int getCustomPosition() {
        return (getRzSDKKey() & 0xFF) + (getRzSDKKey() >> 8) * OneKeyPartialEffect.COLUMN_COUNT;
    }
}
