package com.seacroak.plushables.registry;

import com.seacroak.plushables.block.*;
import com.seacroak.plushables.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;

public final class MainRegistry {
  /* Item Settings */
  static final FabricItemSettings defaultItemSettings = new FabricItemSettings().maxCount(64);
  static final FabricItemSettings plushableItemSettings = new FabricItemSettings().maxCount(8).equipmentSlot(stack -> EquipmentSlot.HEAD);

  /* Standard Blocks */
  public static final BuilderBlock BUILDER_BLOCK = registerBlock("builder_block", new BuilderBlock(),
      defaultItemSettings);
  public static final BasketBlock BASKET_BLOCK = registerBlock("basket_block", new BasketBlock(),
      defaultItemSettings);

  /* Standard Items */
  public static final Item HEART_OF_GOLD = registerItem("heart_of_gold");
  public static final Item POWERED_HEART = registerItem("powered_heart");

  /* Complex Plushables */
  public static final CluckyBlock CLUCKY_BLOCK = registerPlushable("clucky_plushable", new CluckyBlock(),
      plushableItemSettings);
  public static final RupertBlock RUPERT_BLOCK = registerPlushable("rupert_plushable", new RupertBlock(),
      plushableItemSettings);
  public static final DragonBlock DRAGON_BLOCK = registerPlushable("dragon_plushable", new DragonBlock(),
      plushableItemSettings);
  public static final OrangutanBlock ORANGUTAN_BLOCK = registerPlushable("orangutan_plushable", new OrangutanBlock(),
      plushableItemSettings);

  /* Simple Plushables */
  public static final PenguinBlock PENGUIN_PLUSHABLE = registerPlushable("penguin_plushable", new PenguinBlock(),
      plushableItemSettings);
  public static final FroglinBlock FROGLIN_PLUSHABLE = registerPlushable("froglin_plushable", new FroglinBlock(),
      plushableItemSettings);
  public static final FoxBlock FOX_PLUSHABLE = registerPlushable("fox_plushable", new FoxBlock(),
      plushableItemSettings);
  public static final PigBlock PIG_PLUSHABLE = registerPlushable("pig_plushable", new PigBlock(),
      plushableItemSettings);
  public static final TrufflesBlock TRUFFLES_PLUSHABLE = registerPlushable("truffles_plushable", new TrufflesBlock(),
      plushableItemSettings);
  public static final DjungelskogBlock DJUNGELSKOG_PLUSHABLE = registerPlushable("djungelskog_plushable", new DjungelskogBlock(),
      plushableItemSettings);
  public static final RattiamBlock RATTIAM_PLUSHABLE = registerPlushable("rattiam_plushable", new RattiamBlock(),
      plushableItemSettings);
  public static final TriceratopsBlock TRICERATOPS_PLUSHABLE = registerPlushable("triceratops_plushable", new TriceratopsBlock(),
      plushableItemSettings);
  public static final UnicornBlock UNICORN_PLUSHABLE = registerPlushable("unicorn_plushable", new UnicornBlock(),
      plushableItemSettings);
  public static final WhelplingBlock WHELPLING_PLUSHABLE = registerPlushable("whelpling_plushable", new WhelplingBlock(),
      plushableItemSettings);
  public static final RaptorBlock RAPTOR_PLUSHABLE = registerPlushable("raptor_plushable", new RaptorBlock(),
      plushableItemSettings);
  public static final WizardBlock WIZARD_PLUSHABLE = registerPlushable("wizard_plushable", new WizardBlock(),
      plushableItemSettings);
  public static final BeauxBlock BEAUX_PLUSHABLE = registerPlushable("beaux_plushable", new BeauxBlock(),
      plushableItemSettings);
  public static final GoblinBlock GOBLIN_PLUSHABLE = registerPlushable("goblin_plushable", new GoblinBlock(),
      plushableItemSettings);
  public static final BigTaterBlock BIG_TATER_PLUSHABLE = registerPlushable("big_tater_plushable", new BigTaterBlock(),
      plushableItemSettings);
  public static final BigIrritaterBlock BIG_IRRITATER_PLUSHABLE = registerPlushable("big_irritater_plushable", new BigIrritaterBlock(),
      plushableItemSettings);
  public static final OtterBlock OTTER_PLUSHABLE = registerPlushable("otter_plushable", new OtterBlock(),
      plushableItemSettings);
  public static final ShrumpBlock SHRUMP_PLUSHABLE = registerPlushable("shrump_plushable", new ShrumpBlock(),
      plushableItemSettings);
  public static final OctoplushBlock OCTOPLUSH_PLUSHABLE = registerPlushable("octoplush_plushable", new OctoplushBlock(),
      plushableItemSettings);
  public static final SnailBlock SNAIL_PLUSHABLE = registerPlushable("snail_plushable", new SnailBlock(),
      plushableItemSettings);
  public static final WhaleBlock WHALE_PLUSHABLE = registerPlushable("whale_plushable", new WhaleBlock(),
      plushableItemSettings);
  public static final GoldfishBlock GOLDFISH_PLUSHABLE = registerPlushable("goldfish_plushable", new GoldfishBlock(),
      plushableItemSettings);
  public static final TraterBlock TRATER_PLUSHABLE = registerPlushable("trater_plushable", new TraterBlock(),
      plushableItemSettings);

  /* Caps */
  public static final Item FROGLIN_CAP = registerCap("cap_froglin", new FroglinCap());
  public static final Item FOX_CAP = registerCap("cap_fox", new FoxCap());
  public static final Item UNICORN_CAP = registerCap("cap_unicorn", new UnicornCap());
  public static final Item MUSHROOM_CAP = registerCap("cap_mushroom", new MushroomCap());
  public static final Item BEAUX_CAP = registerCap("cap_beaux", new BeauxCap());
  public static final Item TRUFFLES_CAP = registerCap("cap_truffles", new TrufflesCap());


  public static void init() {
  }

  private static <B extends Block> B registerBlock(String name, B block, FabricItemSettings itemSettings) {
    return RegistryHelper.registerBlock(name, block, itemSettings);
  }

  private static <B extends Block> B registerPlushable(String name, B block, FabricItemSettings itemSettings) {
    return RegistryHelper.registerPlushableBlock(name, block, itemSettings);
  }

  private static Item registerItem(String name) {
    return RegistryHelper.registerItem(name, new Item(defaultItemSettings));
  }

  private static Item registerCap(String name, CapArmorItem capType) {
    return RegistryHelper.registerItem(name, capType);
  }

}
