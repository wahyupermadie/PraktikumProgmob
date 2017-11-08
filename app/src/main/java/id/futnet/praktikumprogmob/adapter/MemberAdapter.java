package id.futnet.praktikumprogmob.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import id.futnet.praktikumprogmob.R;
import id.futnet.praktikumprogmob.model.MemberResult;

/**
 * Created by Wahyu Permadi on 11/7/2017.
 */

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MemberResult> memberResult;
    private Context context;
    public MemberAdapter(List<MemberResult> memberResult, Context context) {
        this.memberResult = memberResult;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_layout,parent,false);
        return new Member(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Member)holder).TV_name.setText(memberResult.get(position).getNama());
        ((Member)holder).TV_email.setText(memberResult.get(position).getEmail());
        ((Member)holder).TV_tinggi.setText(memberResult.get(position).getTinggi());
        Glide.with(context).load(" "+memberResult.get(position).getPicture()).into(((Member)holder).IV_member);
    }

    @Override
    public int getItemCount() {
        return memberResult.size();
    }

    private class Member extends RecyclerView.ViewHolder {
        TextView TV_name;
        TextView TV_email;
        TextView TV_tinggi;
        CircleImageView IV_member;
        public Member(View view) {
            super(view);
            TV_name = view.findViewById(R.id.TV_name);
            TV_email = view.findViewById(R.id.TV_email);
            IV_member = view.findViewById(R.id.IV_member);
            TV_tinggi = view.findViewById(R.id.TV_tinggi);
        }
    }
}
