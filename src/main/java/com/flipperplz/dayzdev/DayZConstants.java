package com.flipperplz.dayzdev;

import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.WindowsRegistryUtil;
import com.intellij.util.io.URLUtil;
import com.intellij.util.system.CpuArch;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class DayZConstants {
    public static final String PBO_PROTOCOL = "pbo";
    public static final String PBO_PROTOCOL_PREFIX = PBO_PROTOCOL + URLUtil.SCHEME_SEPARATOR;
    public static final char DAYZ_DIRECTORY_SEPARATOR = '\\';
    public static final String DAYZ_SDK_NAME = "DayZ SDK";


    public static final String PBO_DESCRIPTION = "A packed archive file format used by the DayZ game to store game data and mod files.";


    public static final String EXT_PBO = PBO_PROTOCOL;
    public static final String EXT_CPP = "cpp";
    public static final String EXT_BIN = "bin";

    private static final String STEAM_REGISTRY = "SOFTWARE\\Valve\\Steam";
    private static final String STEAM_REGISTRY64 = "SOFTWARE\\Wow6432Node\\Valve\\Steam";

    private static String defaultDayZPath = null;

    public static String getDefaultDayZPath() {
        if(defaultDayZPath != null) return defaultDayZPath;
        if(!SystemInfo.isWindows) return null;
        if(Advapi32Util.registryKeyExists(WinReg.HKEY_LOCAL_MACHINE, STEAM_REGISTRY)) {
            var installPath = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, STEAM_REGISTRY + "\\InstallPath");
            installPath += "\\steamapps\\common\\DayZ\\";
            defaultDayZPath = installPath;
            return installPath;
        }

        if(Advapi32Util.registryKeyExists(WinReg.HKEY_LOCAL_MACHINE, STEAM_REGISTRY64)) {
            var installPath = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, STEAM_REGISTRY64 + "\\InstallPath");
            installPath += "\\steamapps\\common\\DayZ\\";
            defaultDayZPath = installPath;
            return installPath;
        }

        return null;
    }


}
