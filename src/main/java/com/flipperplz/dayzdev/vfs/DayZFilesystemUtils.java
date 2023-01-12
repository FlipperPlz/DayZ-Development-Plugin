package com.flipperplz.dayzdev.vfs;

import com.flipperplz.dayzdev.DayZConstants;

public class DayZFilesystemUtils {
    public static String normalizePboPrefix(String path) {
        StringBuilder sb = new StringBuilder();
        char prev = 0;
        for (int i = 0, end = path.length(); i < end; i++) {
            char c = path.charAt(i);
            if (c == '/') c = DayZConstants.DAYZ_DIRECTORY_SEPARATOR;
            if(c == DayZConstants.DAYZ_DIRECTORY_SEPARATOR) {
                if(prev == DayZConstants.DAYZ_DIRECTORY_SEPARATOR) continue;
                sb.append(DayZConstants.DAYZ_DIRECTORY_SEPARATOR);
                prev = DayZConstants.DAYZ_DIRECTORY_SEPARATOR;
                continue;
            }
            c = Character.toLowerCase(c);
            sb.append(c);
            prev = c;
        }

        if (sb.length() > 0 && sb.charAt(1) == DayZConstants.DAYZ_DIRECTORY_SEPARATOR) sb.deleteCharAt(1);

        if(sb.length() > 0 && sb.charAt(sb.length() - 1) != DayZConstants.DAYZ_DIRECTORY_SEPARATOR) sb.append(DayZConstants.DAYZ_DIRECTORY_SEPARATOR);
        return sb.toString();
    }

    public static String normalizePboPath(String path) {
        if (path == null || path.isEmpty()) return path;

        char[] result = new char[path.length()];
        boolean lastWasSeparator = false, isFirst = true; // Initialize flag to track if the last character was a separator
        int charsWritten = 0; // counter to keep track of the number of characters written to the result array

        for (int i = 0; i < path.length(); i++) { // Iterate through each character in the path
            char c = path.charAt(i);
            if (c == '/' || c == DayZConstants.DAYZ_DIRECTORY_SEPARATOR) {
                if(isFirst) continue;
                if (lastWasSeparator) continue; // Skip if the last character was a seperator.
                result[charsWritten++] = DayZConstants.DAYZ_DIRECTORY_SEPARATOR;
                lastWasSeparator = true;
                continue;
            }

            isFirst = false;
            lastWasSeparator = false;
            result[charsWritten++] = Character.toLowerCase(c);
        }

        if (charsWritten > 0 && result[charsWritten - 1] == '\\') charsWritten--;

        return new String(result, 0, charsWritten);
    }

    public static String removePboPrefix(String normalizedPrefix, String fullPath) {
        if(normalizePboPath(fullPath).startsWith(normalizedPrefix)) return fullPath.substring(normalizedPrefix.length());
        return fullPath;
    }

    public static String buildPboPath(String normalizedPrefix, String normalizedInternalPath) {
        if(normalizedInternalPath.charAt(0) != DayZConstants.DAYZ_DIRECTORY_SEPARATOR)
            normalizedInternalPath = DayZConstants.DAYZ_DIRECTORY_SEPARATOR + normalizedInternalPath;
        if(normalizedPrefix.charAt(normalizedPrefix.length() - 1) != DayZConstants.DAYZ_DIRECTORY_SEPARATOR)
            normalizedPrefix = normalizedPrefix + DayZConstants.DAYZ_DIRECTORY_SEPARATOR;
        return normalizedPrefix + normalizedInternalPath;

    }
}
