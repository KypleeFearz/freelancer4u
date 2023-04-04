package ch.zhaw.freelancer4u.model.voucher;

import java.util.List;

import ch.zhaw.freelancer4u.model.Job;

public class PercentageVoucher implements Voucher {

    private int discount = 0;

    public PercentageVoucher(int discount) {
        if (discount <= 0) {
            throw new RuntimeException("Error: Discount value ust be greater zero.");
        } else if (discount > 50) {
            throw new RuntimeException("Error: Discount value must be less or equal 50.");
        }
        this.discount = discount;
    }

    @Override
    public double getDiscount(List<Job> products) {
        double sum = products.stream().mapToDouble(num -> Double.parseDouble(num.getEarnings())).sum();
        double disc = sum / 100 * discount;  
        return disc;
    }
    
}
