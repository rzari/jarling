package org.jarling.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class StreamUtils {
    private StreamUtils() {}

    // Based on https://stackoverflow.com/a/35446009
    public static ByteArrayOutputStream toByteArrayOutputStream(InputStream stream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result;
    }

    public static String toString(InputStream stream) throws IOException {
        return toByteArrayOutputStream(stream)
            .toString(StandardCharsets.UTF_8.name());
    }

    public static byte[] toByteArray(InputStream stream) throws IOException {
        return toByteArrayOutputStream(stream).toByteArray();
    }
}
