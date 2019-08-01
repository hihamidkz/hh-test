package com.example.myservice.model.impl;

import com.example.myservice.model.Region;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Region in entity cache.
 *
 * @author hamid
 * @see Region
 * @generated
 */
public class RegionCacheModel implements CacheModel<Region>, Externalizable {
    public long id;
    public String name;
    public long parentId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Region toEntityModel() {
        RegionImpl regionImpl = new RegionImpl();

        regionImpl.setId(id);

        if (name == null) {
            regionImpl.setName(StringPool.BLANK);
        } else {
            regionImpl.setName(name);
        }

        regionImpl.setParentId(parentId);

        regionImpl.resetOriginalValues();

        return regionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        name = objectInput.readUTF();
        parentId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeLong(parentId);
    }
}
