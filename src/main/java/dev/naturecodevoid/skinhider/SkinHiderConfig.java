package dev.naturecodevoid.skinhider;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import static dev.naturecodevoid.skinhider.SkinHider.MOD_ID;

@Config(name = MOD_ID)
public class SkinHiderConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean hideSkins = true;
    @ConfigEntry.Gui.Tooltip(count = 5)
    public boolean hideCapes = false;
}
