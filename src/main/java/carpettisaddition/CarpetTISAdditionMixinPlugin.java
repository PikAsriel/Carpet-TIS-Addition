package carpettisaddition;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class CarpetTISAdditionMixinPlugin implements IMixinConfigPlugin
{
	private final Logger LOGGER = LogManager.getLogger();
	private static final String LITHIUM_MOD_ID = "lithium";
	public static final String SERVER_TICK_SCHEDULER_MIXIN_DEFAULT = ".ServerTickSchedulerMixin";
	public static final String SERVER_TICK_SCHEDULER_MIXIN_LITHIUM = ".LithiumServerTickSchedulerMixin";

	@Override
	public void onLoad(String mixinPackage)
	{

	}

	@Override
	public String getRefMapperConfig()
	{
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName)
	{
		// it's quite a naive implementation now, but since there are not that many demands it's fine i think
		// might refactor it if more judgement are needed to be done
		boolean isLithiumLoaded = FabricLoader.getInstance().isModLoaded(LITHIUM_MOD_ID);
		if (mixinClassName.endsWith(SERVER_TICK_SCHEDULER_MIXIN_DEFAULT))
		{
			return !isLithiumLoaded;
		}
		if (mixinClassName.endsWith(SERVER_TICK_SCHEDULER_MIXIN_LITHIUM))
		{
			return isLithiumLoaded;
		}
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets)
	{

	}

	@Override
	public List<String> getMixins()
	{
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo)
	{

	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo)
	{

	}
}
