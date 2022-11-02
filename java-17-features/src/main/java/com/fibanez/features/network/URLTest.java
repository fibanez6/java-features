package com.fibanez.features.network;

import java.net.URL;

/**
 * An instance of the java.net.URL class represents a URL in a Java program. Although every URL is also a URI, Java does
 * not inherit the URL class from the URI class. Java uses the term protocol to refer to the scheme part in the URI
 * specification. You can create a URL object by providing a string that has all URL’s parts concatenated or by providing
 * the parts separately. If strings that you supply to create a URL object are not valid, the constructors of the URL
 * class will throw a MalformedURLException checked exception.
 */
public class URLTest {

    public static void main(String[] args) {
        String baseURLStr = "http://www.ietf.org/rfc/rfc3986.txt";
        String relativeURLStr = "rfc2732.txt";
        try {
            URL baseURL = new URL(baseURLStr);
            URL resolvedRelativeURL = new URL(baseURL, relativeURLStr);
            System.out.println("Base URL: " + baseURL);
            System.out.println("Relative URL String: " + relativeURLStr);
            System.out.println("Resolved Relative URL: " + resolvedRelativeURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
