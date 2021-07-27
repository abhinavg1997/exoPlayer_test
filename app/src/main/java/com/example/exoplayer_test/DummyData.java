package com.example.exoplayer_test;

import java.util.ArrayList;

public class DummyData {

    private static ArrayList<NewsModel> list;

    public static ArrayList<NewsModel> getList(){
            if(list == null) {
                populateData();
            }
            return list;
    }

    private static void populateData() {
        list = new ArrayList<>();
        NewsModel news1= new NewsModel("1","https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm",
                "Header 1","Body1");
        list.add(news1);
        NewsModel news2= new NewsModel("2","https://cdn.videvo.net/videvo_files/video/premium/video0122/small_watermarked/100a%20Factory_preview.webm",
                "Header 2","Body2");
        list.add(news2);
        NewsModel news3= new NewsModel("3","https://html5demos.com/assets/dizzy.mp4",
                "Header 3","Body3");
        list.add(news3);
        NewsModel news4= new NewsModel("4","https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm",
                "Header 4","Body4");
        list.add(news4);
        NewsModel news5= new NewsModel("5","https://html5demos.com/assets/dizzy.mp4",
                "Header 5","Body5");
        list.add(news5);
    }
}
