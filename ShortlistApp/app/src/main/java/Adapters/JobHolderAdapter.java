package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.shortlistapp.JobHolderDetails;
import com.example.user.shortlistapp.R;

import java.util.ArrayList;
import java.util.List;

import Classes.JobHolder;
import Data.JobHolderContract;
import Data.JobHolderDBHelper;

/**
 * Created by FDUSER on 11/2/2017.
 */

public class JobHolderAdapter extends RecyclerView.Adapter<JobHolderAdapter.JobHolderViewHolder> {
    List<JobHolderWrapper> list = new ArrayList<>();
    Context ctx;

    public JobHolderAdapter(List<JobHolderWrapper> list ,Context ctx)
    {
        this.ctx = ctx;
        this.list = list;
    }


    @Override
    public JobHolderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_job_holder,parent,false);
        JobHolderViewHolder holder = new JobHolderViewHolder(view,ctx, (ArrayList<JobHolderWrapper>) list);

        return holder ;
    }

    @Override
    public void onBindViewHolder(JobHolderViewHolder holder, int position) {
        JobHolderWrapper jobHolderWrapper = list.get(position);
//        holder.textViewhead.setText(jobHolderWrapper.getJobHolderTitle());
//        holder.textViewdeadline.setText(jobHolderWrapper.getDeadline());
        holder.textViewhead.setText(jobHolderWrapper.jobHolderTitle);
        holder.textViewdeadline.setText(jobHolderWrapper.deadlineDate);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class JobHolderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textViewhead ;
        TextView textViewdeadline;
        ArrayList<JobHolderWrapper> listOfJobHolder = new ArrayList<JobHolderWrapper>();
        Context ctx ;
        public JobHolderViewHolder(View view,Context ctx,ArrayList<JobHolderWrapper> listOfJobHolder)
        {

            super(view);
            this.ctx = ctx;
            this.listOfJobHolder = listOfJobHolder;
            view.setOnClickListener(this);
            textViewhead = (TextView)view.findViewById(R.id.header);
            textViewdeadline = (TextView)view.findViewById(R.id.deadline);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            JobHolderWrapper jobHolder = this.listOfJobHolder.get(position);
            Intent intent = new Intent(this.ctx,JobHolderDetails.class);
//            intent.putExtra(JobHolderContract.JobholderEntry.COLUMN_TITLE,jobHolder.getJobHolderTitle());
//            intent.putExtra(JobHolderContract.JobholderEntry.COLUMN_DEADLINE,jobHolder.getDeadline());
            intent.putExtra(JobHolderContract.JobholderEntry.COLUMN_TITLE,jobHolder.jobHolderTitle);
            intent.putExtra(JobHolderContract.JobholderEntry.COLUMN_DEADLINE,jobHolder.deadlineDate);

            this.ctx.startActivity(intent);
        }
    }
}
