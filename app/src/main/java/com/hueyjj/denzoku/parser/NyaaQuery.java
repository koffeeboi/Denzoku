package com.hueyjj.denzoku.parser;

import android.text.TextUtils;

public class NyaaQuery {

    private final String url = "https://nyaa.si/?";
    private String query;
    private Sort sort;
    private String page;
    private String pageNum;

    public NyaaQuery(String query,
                     Sort sort,
                     String page,
                     String pageNum) {
        this.query = query;
        this.sort = sort;
        this.page = page;
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        String[] params = new String[] {
                "q=" + this.query,
                "s=" + this.sort.toString(),
                "page=" + this.page,
                "p=" + this.pageNum,
        };
        String param = TextUtils.join("&", params);
        return url + param;
    }

    public enum Sort {
        SEEDERS("seeders"),
        LEECHERS("leechers"),
        SIZE("size"),
        DOWNLOADS("downloads"),
        DATE("date");

        private final String sort;

        Sort(String sort) {
            this.sort = sort;
        }

        @Override
        public String toString() {
            return this.sort;
        }
    }
}
