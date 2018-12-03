package com.cp.chisana.utils;

import org.springframework.util.StringUtils;

import com.cp.chisana.exception.ServiceException;

import java.util.Random;

/**
 * Created by Chandra.Sarathe on 12/2/2018.
 */
public class Utilities {

    /**
     * converts all the url passed into small case url
     * if protocol is not provided we will add http:// by default
     *
     * @param appDomainURL
     * @return
     */
    public static String stripDomainFromURL(String appDomainURL) {
        try {
            if(StringUtils.isEmpty(appDomainURL)){
                return appDomainURL;
            }
            appDomainURL = appDomainURL.toLowerCase();
            String[] protocols = {"http://", "https://"};
            String url = "";
            String protocol = "";
            String domain = "";
            for (String p : protocols) {
                if (appDomainURL.contains(p)) {
                    protocol = p;
                    String[] s = appDomainURL.split(protocol);
                    domain = s[1].substring(0, (s[1].indexOf("/")));
                } else {
                    //protocol wouldn't have existed in URL, so append "http" by default
                    protocol = "http://";
                    domain = appDomainURL.substring(0, appDomainURL.indexOf("/"));
                }

                url = protocol + domain;
            }
            return url;
        } catch (Exception ex) {
            throw new ServiceException("Error while striping domain from full url {"+ appDomainURL + "}", ex);
        }
    }

    public static String getApiKey() {
        char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };
        int length = 16;
        char[] c = new char[length];
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            c[i]=ch[random.nextInt(ch.length)];
        }
        return new String(c);
    }

    public static void main(String ar[]) {
        //String s = stripDomainFromURL("in.example.com/a/a/b");
        String s = getApiKey();
        System.out.println(s);
    }
}
