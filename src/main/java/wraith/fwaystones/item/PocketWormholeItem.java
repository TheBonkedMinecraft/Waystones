package wraith.fwaystones.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import wraith.fwaystones.FabricWaystones;
import wraith.fwaystones.screen.PocketWormholeScreenHandler;

public class PocketWormholeItem extends Item {

    private static final Text TITLE = Text.translatable("container." + FabricWaystones.MOD_ID + ".pocket_wormhole");

    public PocketWormholeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.openHandledScreen(createScreenHandlerFactory());
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory() {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> new PocketWormholeScreenHandler(i, playerInventory), TITLE);
    }

}
