package com.flipperplz.bisutils.pbo.entries;

import com.flipperplz.bisutils.core.io.BisBinaryReader;
import com.flipperplz.bisutils.core.io.BisBinaryWriter;
import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.enums.PboEntryMagic;
import com.flipperplz.bisutils.pbo.utils.PboProperty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PboVersionEntry extends PboEntry {
    private List<PboProperty> metadata = new ArrayList<>();

    public PboVersionEntry(BisBinaryReader reader, PboFile entryParent) throws IOException {
        super(reader, entryParent, PboEntryMagic.Version);
    }

    @Override
    public void readBinary(BisBinaryReader reader) throws IOException {
        super.readBinary(reader);
        if(!this.entryName.equals("") ||
                this.reserved1 != 0 ||
                this.reserved2 != 0 ||
                this.reserved3 != 0 ||
                this.reserved4 != 0) throw new IOException("This entry is not a version entry.");

        String propertyName;
        while(!(propertyName = reader.readAsciiZ()).equals("")) {
            String propertyValue = reader.readAsciiZ();
            addPboMetadata(new PboProperty(propertyName, propertyValue));
        }
    }

    @Override
    public void writeBinary(BisBinaryWriter writer) throws IOException {
        super.writeBinary(writer);

        for (var property : metadata) {
            writer.writeAsciiZ(property.getPropertyName());
            writer.writeAsciiZ(property.getPropertyValue());
        }

        writer.writeAsciiZ("");
    }

    public void addPboMetadata(PboProperty property) {
        this.metadata.add(property);
        entryParent.deSynchronize();

    }

    public List<PboProperty> getPboMetadata() {
        return metadata;
    }

    @Override
    public int CalculateMetaLength() {
        var calculated = super.CalculateMetaLength();
        for (var prop : metadata) {
            calculated += prop.getPropertyName().getBytes(StandardCharsets.UTF_8).length + 1;
            calculated += prop.getPropertyValue().getBytes(StandardCharsets.UTF_8).length + 1;
        }

        return calculated;
    }

    public void setPboMetadata(List<PboProperty> pboMetadata) {
        metadata = pboMetadata;
        entryParent.deSynchronize();
    }


}
