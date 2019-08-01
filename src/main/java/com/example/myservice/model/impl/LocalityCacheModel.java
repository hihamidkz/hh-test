package com.example.myservice.model.impl;

import com.example.myservice.model.Locality;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Locality in entity cache.
 *
 * @author hamid
 * @see Locality
 * @generated
 */
public class LocalityCacheModel implements CacheModel<Locality>, Externalizable {
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
    public Locality toEntityModel() {
        LocalityImpl localityImpl = new LocalityImpl();

        localityImpl.setId(id);

        if (name == null) {
            localityImpl.setName(StringPool.BLANK);
        } else {
            localityImpl.setName(name);
        }

        localityImpl.setParentId(parentId);

        localityImpl.resetOriginalValues();

        return localityImpl;
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
