package dev.naturecodevoid.skinhider;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import static dev.naturecodevoid.skinhider.SkinHider.MOD_ID;

@Config(name = MOD_ID)
public class SkinHiderConfig implements ConfigData {
    public boolean enabled = true;
}
