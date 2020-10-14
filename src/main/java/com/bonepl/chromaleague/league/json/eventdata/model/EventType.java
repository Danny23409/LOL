package com.bonepl.chromaleague.league.json.eventdata.model;

import com.bonepl.chromaleague.league.json.playerlist.PlayerListThread;

public enum EventType {
    UNSUPPORTED,
    ALLY_BARON_KILL,
    ALLY_HERALD_KILL,
    ALLY_CLOUD_DRAGON_KILL,
    ALLY_ELDER_DRAGON_KILL,
    ALLY_INFERNAL_DRAGON_KILL,
    ALLY_MOUNTAIN_DRAGON_KILL,
    ALLY_OCEAN_DRAGON_KILL,
    ENEMY_BARON_KILL,
    ENEMY_HERALD_KILL,
    ENEMY_CLOUD_DRAGON_KILL,
    ENEMY_ELDER_DRAGON_KILL,
    ENEMY_INFERNAL_DRAGON_KILL,
    ENEMY_MOUNTAIN_DRAGON_KILL,
    ENEMY_OCEAN_DRAGON_KILL;

    public static EventType fromEvent(Event event) {
        if (event != null) {
            if ("DragonKill".equals(event.getEventName())) {
                switch (event.getDragonType()) {
                    case "Air":
                        return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                                ALLY_CLOUD_DRAGON_KILL : ENEMY_CLOUD_DRAGON_KILL;
                    case "Fire":
                        return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                                ALLY_INFERNAL_DRAGON_KILL : ENEMY_INFERNAL_DRAGON_KILL;
                    case "Water":
                        return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                                ALLY_OCEAN_DRAGON_KILL : ENEMY_OCEAN_DRAGON_KILL;
                    case "Earth":
                        return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                                ALLY_MOUNTAIN_DRAGON_KILL : ENEMY_MOUNTAIN_DRAGON_KILL;
                    case "Elder":
                        return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                                ALLY_ELDER_DRAGON_KILL : ENEMY_ELDER_DRAGON_KILL;
                }
            }

            if ("BaronKill".equals(event.getEventName())) {
                return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                        ALLY_BARON_KILL : ENEMY_BARON_KILL;
            }

            if ("HeraldKill".equals(event.getEventName())) {
                return PlayerListThread.getPlayerList().isAlly(event.getKillerName()) ?
                        ALLY_HERALD_KILL : ENEMY_HERALD_KILL;
            }
        }
        return UNSUPPORTED;
    }
}
