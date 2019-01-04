package com.zk.springcache;

/**
 * @Author Zhangk
 * @Date 14:34 2018/11/12
 * @Description
 */
public interface BookRep {
    Book getByIsbn(String isbn);
}
