package com.flipperplz.dayzdev.wizard.module;

import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DayZModuleType extends ModuleType<DayZModuleBuilder> {
    @NotNull
    public static final String ID = "dayz.moduleType";

    protected DayZModuleType() {
        super("dayz");
    }

    public static DayZModuleType getInstance() {
        return (DayZModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @Override
    public @NotNull DayZModuleBuilder createModuleBuilder() {
        return new DayZModuleBuilder();
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "DayZ Server/Client Addon Module";
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Sentence) String getDescription() {
        return "Module for developing addons for the game DayZ.";
    }

    //TODO: ICONS
    @Override
    public @NotNull Icon getNodeIcon(boolean isOpened) {

        return null;
    }
}
