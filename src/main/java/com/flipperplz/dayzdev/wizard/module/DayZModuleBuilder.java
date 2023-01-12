package com.flipperplz.dayzdev.wizard.module;

import com.flipperplz.dayzdev.sdk.DayZSdkType;
import com.flipperplz.dayzdev.wizard.module.steps.DayZWizardSetupSDK_Step1;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DayZModuleBuilder extends ModuleBuilder {
    private static final Logger LOG = Logger.getInstance(DayZModuleBuilder.class);
    private final List<Runnable> mySdkChangedListeners = ContainerUtil.createLockFreeCopyOnWriteList();
    private static final String DAYZ_GROUP_NAME = "DayZ";
    private final String myBuilderId, myPresentableName, myDescription;
    private Sdk mySdk;

    public DayZModuleBuilder() {
        this("DayZModule", "DayZ Module Builder", "DayZ modules are used for developing <b>DayZ</b> client or server addons.");
    }

    protected DayZModuleBuilder(final String builderId,
                                 final String presentableName,
                                 final String description) {
        myBuilderId = builderId;
        myPresentableName = presentableName;
        myDescription = description;
    }

    @Override
    public void setupRootModel(@NotNull final ModifiableRootModel rootModel) throws ConfigurationException {
        if (myJdk != null) rootModel.setSdk(myJdk);
        else rootModel.inheritSdk();

        doAddContentEntry(rootModel);
        LOG.debug(String.format("DayZ project SDK set as: %s", myJdk));
    }

    public Sdk getSdk() {
        return mySdk;
    }

    public void setSdk(final Sdk sdk) {
        if (mySdk != sdk) {
            mySdk = sdk;
            for (Runnable runnable : mySdkChangedListeners) {
                runnable.run();
            }
        }
    }

    @Override
    public @Nullable Project createProject(String name, String path) {
        LOG.debug(String.format("Creating DayZ project '%s' in '%s'", name, path));
        return super.createProject(name, path);
    }

    @Override
    public List<Module> commit(@NotNull Project project) {
        return super.commit(project);
    }


    @Override
    public @Nullable ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new DayZWizardSetupSDK_Step1();
    }

    @Override
    public ModuleType<?> getModuleType() {
        return DayZModuleType.getInstance();
    }

    @Override
    public boolean isSuitableSdkType(SdkTypeId sdkType) {
        return sdkType == DayZSdkType.getInstance();
    }

    @Override
    public @Nullable @NonNls String getBuilderId() {
        return myBuilderId;
    }

    @Override
    public @NlsContexts.DetailedDescription String getDescription() {
        return myDescription;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getPresentableName() {
        return myPresentableName;
    }

    @Override
    public String getGroupName() {
        return DAYZ_GROUP_NAME;
    }

    @Override
    public String getParentGroup() {
        return DAYZ_GROUP_NAME;
    }

}
