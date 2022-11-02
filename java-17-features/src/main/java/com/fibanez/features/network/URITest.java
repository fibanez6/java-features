package com.fibanez.features.network;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Java represents URIs and URLs as objects. It provides the following four classes that you can use to work with URIs
 * and URLs as objects in a Java program:
 * <p>
 * - java.net.URI
 * - java.net.URL
 * - java.net.URLEncoder
 * - java.net.URLDecoder
 * <p>
 * An object of the URI class represents a URI. An object of the URL class represents a URL. URLEncoder and URLDecoder
 * are utility classes that help encode and decode URI strings. I cover other Java classes in the next sections that are
 * used to retrieve the resource identified by a URL.
 * <p>
 * The URI class has many constructors, which let you create a URI object from combinations of parts (scheme, authority,
 * path, query, and fragment) of a URI. All constructors throw a checked exception, URISyntaxException, if strings, which
 * you use to construct a URI object, may not be in conformity with the URI specification.
 */
public class URITest {

    public static void main(String[] args) {
        String baseURIStr = "http://www.jdojo.com/javaintro.html?id=25&rate=5.5%25#foo";
        String relativeURIStr = "../sports/welcome.html";

        try {
            URI baseURI = new URI(baseURIStr);
            URI relativeURI = new URI(relativeURIStr);
            // Resolve the relative URI with respect to
            // the base URI
            URI resolvedURI = baseURI.resolve(relativeURI);
            printURIDetails(baseURI);
            printURIDetails(relativeURI);
            printURIDetails(resolvedURI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void printURIDetails(URI uri) {
        System.out.println("URI:" + uri);
        System.out.println("Normalized:"
                + uri.normalize());
        String parts = "[Scheme=" + uri.getScheme()
                + ", Authority=" + uri.getAuthority()
                + ", Path=" + uri.getPath()
                + ", Query:" + uri.getQuery()
                + ", Fragment:" + uri.getFragment()
                + "]";
        System.out.println(parts);
        System.out.println();
    }
}