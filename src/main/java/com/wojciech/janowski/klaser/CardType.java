package com.wojciech.janowski.klaser;

public enum CardType {
    Normal, Effect, Ritual, Fusion, Synchro,
    Xyz, Toon, Spirit, Union, Gemini,
    Tuner, Flip, Pendulum, Link;

    public static final CardType[] ALL = {
            Normal, Effect, Ritual, Fusion, Synchro,
            Xyz, Toon, Spirit, Union, Gemini,
            Tuner, Flip, Pendulum, Link
    };
}