package app.com.lawyerly.lawyers.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.com.lawyerly.R;
import app.com.lawyerly.databinding.ViewLawyerFeaturedItemBinding;
import app.com.lawyerly.model.LawyerList;
import app.com.lawyerly.util.ImageHelper;

public class FeaturedListAdapter extends RecyclerView.Adapter<FeaturedListAdapter.LawyerListViewHolder> {
    private ArrayList<LawyerList> mLawyerListData;
    private Context mContext;
    private OnLawyerClickListener mListener;
    private Bitmap profileImageBitmap;


    public FeaturedListAdapter(ArrayList<LawyerList> lawyerListData,Context context) {
        this.mLawyerListData = lawyerListData;
        this.mContext=context;
        profileImageBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.lawyerly);
        profileImageBitmap = ImageHelper
                .getRoundCornerBitmap(profileImageBitmap, (int) mContext.getResources().getDimension(R.dimen.dimen_7));

    }

    public void setListener(OnLawyerClickListener listener) {
        mListener = listener;
    }

    @Override
    public LawyerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_lawyer_featured_item, parent, false);
        return new LawyerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LawyerListViewHolder holder, int position) {
        final ViewLawyerFeaturedItemBinding binding = holder.mBinding;
        final LawyerList lawyerData = mLawyerListData.get(position);
        binding.tvLRating.setText(String.valueOf(lawyerData.getLawyersRating()));
        binding.tvPrice.setText(mContext.getString(R.string.label_currency)+String.valueOf(lawyerData.getLawyerPrice()));
        binding.ivProfilePic.setImageBitmap(profileImageBitmap);

        }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (mLawyerListData == null ? 0  : mLawyerListData.size());
    }

    private LawyerList getItem(int position) {
        return mLawyerListData.get(position);
    }

    public class LawyerListViewHolder extends RecyclerView.ViewHolder {
        private ViewLawyerFeaturedItemBinding mBinding;

        public LawyerListViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            //set click listener on parent view
            mBinding.rlParentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LawyerList itemClicked = getItem(getAdapterPosition());
                    mListener.onLawyerItemClicked(itemClicked);
                }
            });
                    }

    }

    public interface OnLawyerClickListener {
        void onLawyerItemClicked(LawyerList lawyer);

    }

}

