package com.example.myservice.model.impl;

import com.example.myservice.model.Vacancy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Vacancy in entity cache.
 *
 * @author hamid
 * @see Vacancy
 * @generated
 */
public class VacancyCacheModel implements CacheModel<Vacancy>, Externalizable {
    public long id;
    public String name;
    public String publishedAt;
    public String employer;
    public String salary;
    public String address;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", publishedAt=");
        sb.append(publishedAt);
        sb.append(", employer=");
        sb.append(employer);
        sb.append(", salary=");
        sb.append(salary);
        sb.append(", address=");
        sb.append(address);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Vacancy toEntityModel() {
        VacancyImpl vacancyImpl = new VacancyImpl();

        vacancyImpl.setId(id);

        if (name == null) {
            vacancyImpl.setName(StringPool.BLANK);
        } else {
            vacancyImpl.setName(name);
        }

        if (publishedAt == null) {
            vacancyImpl.setPublishedAt(StringPool.BLANK);
        } else {
            vacancyImpl.setPublishedAt(publishedAt);
        }

        if (employer == null) {
            vacancyImpl.setEmployer(StringPool.BLANK);
        } else {
            vacancyImpl.setEmployer(employer);
        }

        if (salary == null) {
            vacancyImpl.setSalary(StringPool.BLANK);
        } else {
            vacancyImpl.setSalary(salary);
        }

        if (address == null) {
            vacancyImpl.setAddress(StringPool.BLANK);
        } else {
            vacancyImpl.setAddress(address);
        }

        vacancyImpl.resetOriginalValues();

        return vacancyImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        name = objectInput.readUTF();
        publishedAt = objectInput.readUTF();
        employer = objectInput.readUTF();
        salary = objectInput.readUTF();
        address = objectInput.readUTF();
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

        if (publishedAt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(publishedAt);
        }

        if (employer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(employer);
        }

        if (salary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(salary);
        }

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }
    }
}
