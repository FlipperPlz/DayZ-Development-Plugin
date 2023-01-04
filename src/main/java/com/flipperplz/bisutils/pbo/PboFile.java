package com.flipperplz.bisutils.pbo;

import com.flipperplz.bisutils.core.BisBinarizable;
import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.entries.PboDataEntry;
import com.flipperplz.bisutils.pbo.entries.PboEntry;
import com.flipperplz.bisutils.pbo.entries.PboVersionEntry;

import java.util.ArrayList;
import java.util.List;

public class PboFile extends BisBinarizable {
    private List<PboEntry> entries = new ArrayList<>();

    public PboFile(BisBinaryReader reader) throws Exception {
        super(reader);
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws Exception {

    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws Exception {

    }

    public List<PboDataEntry> getDataEntries() {
        var entries = new ArrayList<PboDataEntry>();
        for (var entry : entries) {
            if (entry instanceof PboDataEntry) entries.add(entry);
        }

        return entries;
    }

    public List<PboEntry> getEntries() {
        return entries;
    }

    public PboVersionEntry getVersionEntry() {
        for (var entry : entries) {
            if (entry instanceof PboVersionEntry)
                return (PboVersionEntry) entry;
        }

        return null;
    }

}
