package com.alienpants.leafpicrevived2.data.filter;

import com.alienpants.leafpicrevived2.data.Media;

/**
 * Created by dnld on 4/10/17.
 */

public interface IMediaFilter {
    boolean accept(Media media);
}
