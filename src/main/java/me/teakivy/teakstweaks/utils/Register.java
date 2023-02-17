package me.teakivy.teakstweaks.utils;

import me.teakivy.teakstweaks.Main;
import me.teakivy.teakstweaks.commands.*;
import me.teakivy.teakstweaks.packs.BasePack;
import me.teakivy.teakstweaks.packs.experimental.chunkloaders.Loader;
import me.teakivy.teakstweaks.packs.experimental.confetticreepers.ConfettiCreeper;
import me.teakivy.teakstweaks.packs.experimental.elevators.Elevator;
import me.teakivy.teakstweaks.packs.experimental.xpmanagement.XPManagement;
import me.teakivy.teakstweaks.packs.hermitcraft.tag.Tag;
import me.teakivy.teakstweaks.packs.hermitcraft.thundershrine.Shrine;
import me.teakivy.teakstweaks.packs.hermitcraft.treasuregems.Gems;
import me.teakivy.teakstweaks.packs.hermitcraft.wanderingtrades.Trades;
import me.teakivy.teakstweaks.packs.items.armoredelytra.ArmoredElytras;
import me.teakivy.teakstweaks.packs.items.playerheaddrops.HeadDrop;
import me.teakivy.teakstweaks.packs.items.rotationwrench.Wrench;
import me.teakivy.teakstweaks.packs.mobs.anticreepergrief.AntiCreeper;
import me.teakivy.teakstweaks.packs.mobs.antiendermangrief.AntiEnderman;
import me.teakivy.teakstweaks.packs.mobs.antighastgrief.AntiGhast;
import me.teakivy.teakstweaks.packs.mobs.batmembranes.BatMembranes;
import me.teakivy.teakstweaks.packs.mobs.countmobdeaths.CountDeaths;
import me.teakivy.teakstweaks.packs.mobs.doubleshulkershells.DoubleShulkers;
import me.teakivy.teakstweaks.packs.mobs.dragondrops.DragonDrops;
import me.teakivy.teakstweaks.packs.mobs.largerphantoms.Phantoms;
import me.teakivy.teakstweaks.packs.mobs.moremobheads.MobHeads;
import me.teakivy.teakstweaks.packs.mobs.silencemobs.Silencer;
import me.teakivy.teakstweaks.packs.mobs.villagerdeathmessages.VillagerDeath;
import me.teakivy.teakstweaks.packs.survival.afkdisplay.AFK;
import me.teakivy.teakstweaks.packs.survival.cauldronconcrete.ConcreteConverter;
import me.teakivy.teakstweaks.packs.survival.classicfishingloot.Fishing;
import me.teakivy.teakstweaks.packs.survival.coordshud.HUD;
import me.teakivy.teakstweaks.packs.survival.customnetherportals.NetherPortal;
import me.teakivy.teakstweaks.packs.survival.durabilityping.DuraPing;
import me.teakivy.teakstweaks.packs.survival.fastleafdecay.Decay;
import me.teakivy.teakstweaks.packs.survival.graves.GraveEvents;
import me.teakivy.teakstweaks.packs.survival.multiplayersleep.MultiSleep;
import me.teakivy.teakstweaks.packs.survival.pillagertools.PillagerSpawning;
import me.teakivy.teakstweaks.packs.survival.trackrawstatistics.RawStats;
import me.teakivy.teakstweaks.packs.survival.trackstatistics.StatTracker;
import me.teakivy.teakstweaks.packs.survival.unlockallrecipes.UnlockRecipes;
import me.teakivy.teakstweaks.packs.survival.workstationhighlights.Highlighter;
import me.teakivy.teakstweaks.packs.teakstweaks.betterfoliage.BetterFoliage;
import me.teakivy.teakstweaks.packs.teakstweaks.chatcolors.ChatColors;
import me.teakivy.teakstweaks.packs.teakstweaks.editsigns.EditSigns;
import me.teakivy.teakstweaks.packs.teakstweaks.fixeditemframes.FixedItemFrames;
import me.teakivy.teakstweaks.packs.teakstweaks.instantdeepslate.InstantDeepslate;
import me.teakivy.teakstweaks.packs.teakstweaks.invisibleitemframes.InvisibleItemFrames;
import me.teakivy.teakstweaks.packs.teakstweaks.keepsmall.KeepSmall;
import me.teakivy.teakstweaks.packs.teakstweaks.lecternreset.LecternReset;
import me.teakivy.teakstweaks.packs.teakstweaks.sleepyspidereggs.SleepySpiderEggs;
import me.teakivy.teakstweaks.packs.teakstweaks.slimecream.SlimeCream;
import me.teakivy.teakstweaks.packs.teakstweaks.stairchairs.StairChairs;
import me.teakivy.teakstweaks.packs.teakstweaks.sudoku.Sudoku;
import me.teakivy.teakstweaks.packs.teakstweaks.unstickypistons.UnstickyPistons;
import me.teakivy.teakstweaks.packs.teleportation.back.Back;
import me.teakivy.teakstweaks.packs.utilities.customvillagershops.CustomVillager;
import me.teakivy.teakstweaks.packs.utilities.itemaverages.ItemTracker;
import me.teakivy.teakstweaks.packs.utilities.spawningspheres.Sphere;
import me.teakivy.teakstweaks.packs.utilities.spectatorconduitpower.ConduitPower;
import me.teakivy.teakstweaks.packs.utilities.spectatornightvision.NightVision;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Register {

    private final Map<String, BasePack> packs;

    public Register() {
        packs = Stream.of(new AntiCreeper(),
            new AntiEnderman(),
            new AntiGhast(),
            new DoubleShulkers(),
            new DragonDrops(),
            new Phantoms(),
            new MobHeads(),
            new DuraPing(),
            new ConcreteConverter(),
            new CountDeaths(),
            new MultiSleep(),
            new HeadDrop(),
            new Silencer(),
            new ConduitPower(),
            new NightVision(),
            new Tag(),
            new UnlockRecipes(),
            new VillagerDeath(),
            new Trades(),
            new XPManagement(),
            new ConfettiCreeper(),
            new Back(),
            new AFK(),
            new Shrine(),
            new Highlighter(),
            new Loader(),
            new Decay(),
            new PillagerSpawning(),
            new Elevator(),
            new Wrench(),
            new Gems(),
            new ArmoredElytras(),
            new Fishing(),
            new NetherPortal(),
            new ItemTracker(),
            new StatTracker(),
            new RawStats(),
            new GraveEvents(),
            new HUD(),
            new CustomVillager(),
            new Sphere(),
            new KeepSmall(),
            new ChatColors(),
            new EditSigns(),
            new LecternReset(),
            new Sudoku(),
            new StairChairs(),
            new UnstickyPistons(),
            new SlimeCream(),
            new InvisibleItemFrames(),
            new BetterFoliage(),
            new FixedItemFrames(),
            new InstantDeepslate(),
            new BatMembranes(),
            new SleepySpiderEggs()
        ).collect(Collectors.toMap(BasePack::getPath, x -> x));

    }

    public void registerAll() {
        Main main = Main.getInstance();
        unregisterAll();
        for (String pack : main.getConfig().getConfigurationSection("packs").getKeys(false)) {
            if (main.getConfig().getBoolean("packs." + pack + ".enabled")) {
                registerPack(pack);
            }
        }
    }

    public void unregisterAll() {
        Main main = Main.getInstance();
        main.clearPacks();
        for (String pack : main.getConfig().getConfigurationSection("packs").getKeys(false)) {
            if (!main.getConfig().getBoolean("packs." + pack + ".enabled")) {
                unregisterPack(pack);
            }
        }
    }

    public void unregisterPack(String pack) {
        BasePack pk = packs.get(pack);
        if (pk != null) pk.unregister();
    }

    public void registerPack(String pack) {
        BasePack pk = packs.get(pack);
        if (pk != null) pk.init();
    }

    public static void registerCommands() {
        AbstractCommand[] cmds = {
            new TeaksTweaksCommand(),
            new PortalCommand(),
            new CoordsHudCommand(),
            new NightVisionCommand(),
            new ConduitPowerCommand(),
            new KillBoatsCommand(),
            new TestCommand(),
            new RealTimeClockCommand(),
            new SpawnCommand(),
            new TPACommand(),
            new HomeCommand(),
            new DurabilityPingCommand(),
            new TagGameCommand(),
            new BackCommand(),
            new AFKCommand(),
            new ShrineCommand(),
            new WorkstationHighlightCommand(),
            new SetHomeCommand(),
            new ItemAveragesCommand(),
            new GraveCommand(),
            new SpawningSpheresCommand(),
            new GemCommand(),
            new SudokuCommand(),
            new PackListCommand()
        };

        for (AbstractCommand cmd : cmds) {
            cmd.register();
        }
    }

}