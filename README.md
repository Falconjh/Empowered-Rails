## Fabric Block Under Fast Minecarts
Based on/forked from FasterMinecarts, with inspiration from the HS Rails plugin from ergor, who credits  varesa's Minecart Speedplus.  

This Mod aims to be vanilla client/fabric server friendly; so server side only. A different fork (FasterMinecarts 2 by fiddleyowl) is modded client/server, unlike the original, by adding additional blocks to the game. 

This mod aims to balance the speed of vanilla minecarts compared to the other means of transportation available.

If you like the thought of building long railways connecting your world together, but feel that you are hampering yourself because the fastest horse can reach almost double the speed a vanilla minecart can while requiring close to no resources at the same time, then hopefully this mod can remedy that.

This mod changes the speed of minecarts up to 30 b/s based on the block underneath the powered rail as defined in the config file. 

30 m/s is the limit imposed in the game, higher values then that just increase momentum per the chat pages of similar mods.

Derailment is an option; set the config to have slow down blocks accordingly. 

Config is json with "minecraft:< Block id >" : Max Speed. 

Commands:
/empoweredrails set <block> <speed> - set or change the max speed of a block type.
/empoweredrails reload - reloads the config file, overwrites any changes set. ToDo: verify this is true if a block is added by set rather than just replaced.
/empoweredrails save - saves the current settings of blocks/speeds to the config file. 

---

This mod requires **Fabric**.

As with other mods in the series, this is GPL 3 licensed.
