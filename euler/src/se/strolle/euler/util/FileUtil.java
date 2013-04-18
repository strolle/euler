package se.strolle.euler.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public final class FileUtil {
	public static final File getFile(final String relativePath) {
		URL url = ClassLoader.class.getResource(relativePath);
		try {
			return new File(url.toURI());
		} catch (URISyntaxException e) {
			return new File(url.getPath());
		}
	}
}
