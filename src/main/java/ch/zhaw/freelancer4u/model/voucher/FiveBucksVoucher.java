package ch.zhaw.freelancer4u.model.voucher;

import java.util.List;

import ch.zhaw.freelancer4u.model.Job;

public class FiveBucksVoucher implements Voucher{

    @Override
    public double getDiscount(List<Job> products) {
        double sum = products.stream().mapToDouble(num -> Double.parseDouble(num.getEarnings())).sum();
        if (sum >= 10.0) {
            return 5.0;
        }
        return 0.0;
    }
    
}
