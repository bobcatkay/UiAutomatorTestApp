package com.github.uiautomatortestapp.bean;

import java.util.List;

/**
 * Created by xulin on 2017/5/22 0022.
 */

public class Books {

    public List<BooksBean> books;

    public static class BooksBean {
        /**
         * describe : 一本经久不衰的C++畅销经典教程；首本支持C++11新标准的程序设计图书。
         * title : C++ Primer Plus
         */

        public String describe;
        public String title;
    }
}
