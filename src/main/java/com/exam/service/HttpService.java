package com.exam.service;

import org.jsoup.Jsoup;

public class HttpService {

    public String fetchContent(String url) throws Exception {
        return Jsoup.connect(url)
                .timeout(10000)
                .get()
                .text();
    }
}
