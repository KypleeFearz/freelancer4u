package ch.zhaw.freelancer4u.model.voucher;

import java.util.List;

import ch.zhaw.freelancer4u.model.Job;

public class PercentageVoucher implements Voucher {

    private int discount;

    public PercentageVoucher(int discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount(List<Job> products) {
        if (products.size() == 0) {
            return 0.0;
        }
        double sum = products.stream().mapToDouble(num -> Double.parseDouble(num.getEarnings())).sum();
        double disc = sum / 100 * discount;  
        return disc;
    }
    
}
