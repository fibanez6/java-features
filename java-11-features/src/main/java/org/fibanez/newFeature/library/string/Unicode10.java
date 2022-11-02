package org.fibanez.newFeature.library.string;

/**
 * Java 10 uses the Unicode 8 standard for localization. The Unicode standard evolves continuously, so it was about time
 * that Java 11 follow the latest version, Unicode 10. The upgrade from Unicode 8 to 10 includes 16,018 new characters
 * and 10 new scripts. A script is a collection of letters and other written signs used to represent textual information.
 * For example, Unicode 10 adds Masaram Gondi, a South-Central Dravidian language.
 *
 * One of the long-awaited additions to Unicode 10 is the “Colbert emoji”, a face with a neutral mouth and single eyebrow
 * raised made popular by comedian Stephen Colbert. The following example makes use of the Colbert emoji:
 *
 * @see "https://emojipedia.org/unicode-10.0/"
 */
public class Unicode10 {

    public static void main(String[] args) {
        String unicodeCharacter = "\uD83E\uDD28";
        System.out.println(unicodeCharacter);

        System.exit(0);
    }
}
