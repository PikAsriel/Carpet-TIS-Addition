/*
 * This file is part of the Carpet TIS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  Fallen_Breath and contributors
 *
 * Carpet TIS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet TIS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet TIS Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package carpettisaddition.mixins.carpet.shape;

import carpet.script.utils.ShapeDispatcher;
import carpet.script.value.Value;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

//#if MC >= 11904
//$$ import net.minecraft.registry.DynamicRegistryManager;
//#endif

@Mixin(ShapeDispatcher.ExpiringShape.class)
public interface ExpiringShapeInvoker
{
	@Invoker(
			//#if MC < 11904
			remap = false
			//#endif
	)
	void callInit(
			Map<String, Value> options
			//#if MC >= 11904
			//$$ , DynamicRegistryManager regs
			//#endif
	);
}
