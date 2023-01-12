package com.flipperplz.dayzdev.sdk;

import com.flipperplz.dayzdev.DayZConstants;
import com.intellij.openapi.externalSystem.model.project.ProjectSdkData;
import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.util.SystemInfo;
import org.codehaus.plexus.util.cli.shell.CmdShell;
import org.jdom.Element;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayZSdkType extends SdkType {

    public DayZSdkType() {
        super(DayZConstants.DAYZ_SDK_NAME);
    }

    public static @NotNull DayZSdkType getInstance() {
        return SdkType.findInstance(DayZSdkType.class);
    }

    @Override
    public @Nullable String suggestHomePath() {
        if (SystemInfo.isWindows) {
            return DayZConstants.getDefaultDayZPath();
        }
        return null;
    }

    @Override
    public boolean isValidSdkHome(@NotNull String path) {
        if(SystemInfo.isWindows) {
            var dayzExePath = Path.of(path,  "DayZ_x64.exe");
            if(Files.exists(dayzExePath)) {
                if(!Files.isExecutable(dayzExePath)) return false;
            }
        }
        return Files.isDirectory(Path.of(path, "dta")) && Files.isDirectory(Path.of(path, "bliss"));
    }

    @Override
    public @NotNull String suggestSdkName(@Nullable String currentSdkName, @NotNull String sdkHome) {
        String executableName = SystemInfo.isWindows ? "dmd.exe" : "dmd";
        String guessedVersion = getVersionString(sdkHome);
        if(guessedVersion == null) {
            return DayZConstants.DAYZ_SDK_NAME;
        }
        else {
            return DayZConstants.DAYZ_SDK_NAME + " v" + guessedVersion;
        }
    }

    @Override
    public @Nullable String getVersionString(String sdkHome) {
        try {
            var dayZ = new File(sdkHome, "DayZ_x64.exe");
            if(dayZ.exists()) {
                String command = "powershell.exe  $PSVersionTable.PSVersion (Get-Command \"" + dayZ.getAbsolutePath() + "\").FileVersionInfo.ProductVersion";
                Process powerShellProcess = Runtime.getRuntime().exec(command);
                powerShellProcess.getOutputStream().close();
                StringBuilder builder = new StringBuilder();
                BufferedReader stdout = new BufferedReader(new InputStreamReader(
                        powerShellProcess.getInputStream()));
                String line;
                while (( line = stdout.readLine()) != null) {
                    builder.append(line);
                }
                stdout.close();
                return builder.toString();
            }
        } catch (IOException e) {
            return super.getVersionString(sdkHome);
        }
        return super.getVersionString(sdkHome);
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getPresentableName() {
        return DayZConstants.DAYZ_SDK_NAME;
    }

    @Override
    public @Nullable AdditionalDataConfigurable createAdditionalDataConfigurable(@NotNull SdkModel sdkModel, @NotNull SdkModificator sdkModificator) {
        return null;
    }

    @Override
    public void saveAdditionalData(@NotNull SdkAdditionalData additionalData, @NotNull Element additional) {

    }
}
