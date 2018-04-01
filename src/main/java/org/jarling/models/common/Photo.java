package org.jarling.models.common;

import javax.xml.bind.DatatypeConverter;

/**
 *
 * Model class representing a Photo.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Photo {
    private String base64EncodedPhoto = "";

    public Photo(String encodedPhoto) {
        assert base64EncodedPhoto != null;
        this.base64EncodedPhoto = encodedPhoto;
    }

    public String getEncodedPhoto() {
        return base64EncodedPhoto;
    }

    public byte[] getPhoto(){
        return DatatypeConverter.parseBase64Binary(this.base64EncodedPhoto);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "base64EncodedPhoto='" + base64EncodedPhoto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        return base64EncodedPhoto != null ? base64EncodedPhoto.equals(photo.base64EncodedPhoto) : photo.base64EncodedPhoto == null;
    }

    @Override
    public int hashCode() {
        return base64EncodedPhoto != null ? base64EncodedPhoto.hashCode() : 0;
    }
}
