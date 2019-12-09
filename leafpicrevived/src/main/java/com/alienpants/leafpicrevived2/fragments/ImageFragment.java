package com.alienpants.leafpicrevived2.fragments;

import android.net.Uri;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import com.alienpants.leafpicrevived2.R;
import com.alienpants.leafpicrevived2.data.Media;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * A Media Fragment for showing an Image (static)
 */
public class ImageFragment extends BaseMediaFragment {

    DrawableCrossFadeFactory mFadeFactory;

//    @BindView(R.id.subsampling_view) SubsamplingScaleImageView imageView;
    @BindView(R.id.plain_view) ImageView plainImageView;

    @NonNull
    public static ImageFragment newInstance(@NonNull Media media) {
        return BaseMediaFragment.newInstance(new ImageFragment(), media);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photo, container, false);
        ButterKnife.bind(this, rootView);
        mFadeFactory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Uri mediaUri = media.getUri();

//        imageView.setOrientation(BitmapUtils.getOrientation(mMediaUri, getContext()));
//        imageView.setImage(ImageSource.uri(mediaUri));
//        imageView.setImage(mImageSource);
//        setTapListener(imageView);

        Glide.with(view)
                .load(mediaUri)
                .transition(withCrossFade(mFadeFactory))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(plainImageView);
        setTapListener(plainImageView);


    }

    @Override
    public void onDestroyView() {
//        imageView.recycle();
        super.onDestroyView();
    }

    /**
     * Rotate the currently displaying media image.
     *
     * @param rotationInDegrees The rotation in degrees
     */
    public void rotatePicture(int rotationInDegrees) {
//        if (rotationInDegrees == -90 && imageView.getOrientation() == 0) imageView.setOrientation(SubsamplingScaleImageView.ORIENTATION_270);
//        else imageView.setOrientation(Math.abs(imageView.getOrientation() + rotationInDegrees) % 360);
    }
}
