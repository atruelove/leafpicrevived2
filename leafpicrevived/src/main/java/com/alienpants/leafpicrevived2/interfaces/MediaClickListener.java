package com.alienpants.leafpicrevived2.interfaces;

import com.alienpants.leafpicrevived2.data.Album;
import com.alienpants.leafpicrevived2.data.Media;

import java.util.ArrayList;

public interface MediaClickListener {

    void onMediaClick(Album album, ArrayList<Media> media, int position);
}
