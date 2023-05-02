package ch.zhaw.freelancer4u.model.voucher;

import java.util.List;

import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobType;

public class TwoForOneVoucher implements Voucher{

    private JobType jobType;

    public TwoForOneVoucher(JobType jobType) {
        this.jobType = jobType;
    }

    @Override
    public double getDiscount(List<Job> products) {
        int count = 0;

        if (products.size() > 1) {
            for (Job j: products) {
                if (j.getJobType() == jobType) {
                    count++;
                } 
            }
            double sum = 0;
            if (count > 1) {
                for (Job jo: products) {
                    if (jo.getJobType() == jobType) {
                        sum+= (jo.getEarnings());
                    }
                }
            }
            return sum*0.5;
        }
        return 0.0;
    }
    
}
