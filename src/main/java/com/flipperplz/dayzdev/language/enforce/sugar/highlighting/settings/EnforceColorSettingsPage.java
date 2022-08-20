package com.flipperplz.dayzdev.language.enforce.sugar.highlighting.settings;

import com.flipperplz.dayzdev.language.enforce.sugar.highlighting.EnforceSyntaxHighlighter;
import com.flipperplz.dayzdev.language.rap.sugar.highlighting.RapSyntaxHighlighter;
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

public class EnforceColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keywords", EnforceSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comments//Block", EnforceSyntaxHighlighter.BLOCK_COMMENT),
            new AttributesDescriptor("Comments//Line", EnforceSyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Values//Strings", EnforceSyntaxHighlighter.STRING),
            new AttributesDescriptor("Values//Floats", EnforceSyntaxHighlighter.FLOAT),
            new AttributesDescriptor("Values//Integers", EnforceSyntaxHighlighter.INT),
            new AttributesDescriptor("Separators//Braces", EnforceSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Separators//Brackets", EnforceSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Separators//Parenthesis", EnforceSyntaxHighlighter.PARENTHESIS),
            new AttributesDescriptor("Separators//Commas", EnforceSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Separators//Semicolons", EnforceSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Operators", EnforceSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("Misc//Identifiers", EnforceSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Misc//ClassReferences", EnforceSyntaxHighlighter.CLASS_REFERENCE),
            new AttributesDescriptor("Misc//Classnames", EnforceSyntaxHighlighter.CLASSNAME),
            new AttributesDescriptor("Misc//Functions//Calls", EnforceSyntaxHighlighter.FUNCTION_CALL),
            new AttributesDescriptor("Misc//Functions//Parameters", EnforceSyntaxHighlighter.FUNCTION_PARAMETER),
            new AttributesDescriptor("BadValue", RapSyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new EnforceSyntaxHighlighter();
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
                "modded class MVC {\n" +
                "\toverride void RegisterConversionTemplates(out TypeConversionHashMap type_conversions) {\n" +
                "\t\tsuper.RegisterConversionTemplates(type_conversions);\n" +
                "\t\ttype_conversions.Insert(EditorBrushData, TypeConversionBrush);\n" +
                "\t\ttype_conversions.Insert(EditorBrushObject, TypeConversionBrushObject);\n" +
                "\t\ttype_conversions.Insert(DropdownListPrefabItemBase, DropdownListPrefabItemConverter);\n" +
                "\t\ttype_conversions.Insert(EditorFile, TypeConversionEditorFile);\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class TypeConversionBrush extends TypeConversionTemplate<EditorBrushData> {\t\n" +
                "\toverride void SetString(string value) {\n" +
                "\t\tm_Value.Name = value;\n" +
                "\t}\n" +
                "\t\n" +
                "\toverride string GetString() {\n" +
                "\t\treturn m_Value.Name;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class TypeConversionBrushObject: TypeConversionTemplate<EditorBrushObject> {\n" +
                "\toverride void SetString(string value) {\n" +
                "\t\tm_Value.Name = value;\n" +
                "\t}\n" +
                "\t\n" +
                "\toverride string GetString() {\n" +
                "\t\treturn m_Value.Name;\n" +
                "\t}\n" +
                "\t\n" +
                "\toverride Widget GetWidget() {\n" +
                "\t\treturn GetGame().GetWorkspace().CreateWidgets(\"DayZEditor/gui/Layouts/options/EditorDialogOptionEditBrush.layout\");\n" +
                "\t}\n" +
                "}\n";
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
        return "DayZ: Enforce Script ";
    }
}
