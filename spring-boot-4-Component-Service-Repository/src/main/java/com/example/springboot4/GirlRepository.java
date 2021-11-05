package com.example.springboot4;

public interface GirlRepository {
    /**
     * Tìm kiếm một cô gái trong database theo tên
     * @param name
     * @return
     */
    Girl getGirlByName(String name);
}
