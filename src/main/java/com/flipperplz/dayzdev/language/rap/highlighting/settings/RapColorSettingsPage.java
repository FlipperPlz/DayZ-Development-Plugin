package com.flipperplz.dayzdev.language.rap.highlighting.settings;

import com.flipperplz.dayzdev.language.rap.highlighting.RapSyntaxHighlighter;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class RapColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keywords", RapSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comments", RapSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Values//Strings", RapSyntaxHighlighter.STRING),
            new AttributesDescriptor("Values//Numbers", RapSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Values//Identifiers", RapSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Separators//Braces", RapSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Separators//Brackets", RapSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Separators//Commas", RapSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Separators//Semicolons", RapSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Separators//Colons", RapSyntaxHighlighter.COLON),
            new AttributesDescriptor("Operators", RapSyntaxHighlighter.OPERATORS),
            new AttributesDescriptor("Bad Value", RapSyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return null; //TODO: ICON
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new RapSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "/*/\n" +
                "/**/\n" +
                "/*\n" +
                " * According to all known laws of aviation, there is no way a bee\n" +
                " * should be able to fly. Its wings are too small to get its fat\n" +
                " * little body off the ground. The bee, of course, flies anyway\n" +
                " * because bees don't care what humans think is impossible...\n" +
                "*/\n\n" +
                "class CfgPatches {\n" +
                "\tclass ExternalClass;\n" +
                "\tclass TestMod : ExternalClass {\n" +
                "\t\tnames[] = {\n" +
                "\t\t\t{\"Ryann\", 1},\n" +
                "\t\t\t{\"Elijah\", 2},\n" +
                "\t\t\t{\"Flipper\", 3}\n" +
                "\t\t};\n" +
                "\t\tnames[] += {{\"Name\", \"id\"}};\n" +
                "\t\tpi = 3.14159265359;\n" +
                "\t\tdelete ExternalClass;\n" +
                "\t\tmagicNumber = 1.267e8;\n" +
                "\t\tquotes = \" \\\" Woahh :O \\\" \"; //As if anyone uses string escapes in DayZ.\n" +
                "\t\tcrazyArray[] = {1, 1.2, \"three\", {\"four\", 5, 6.78e9}, -10, \"ArrayOver\"};\n" +
                "\t\tiHateSemicolons = \"What are they even good for anyways??\"\n" +
                "\t};\n" +
                "};\n" ;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "DayZ Config (rvmat | cpp)";
    }
}
