package ch.zhaw.freelancer4u.model.voucher;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.zhaw.freelancer4u.model.Job;

public class FiveBucksVoucherTest {

    @Test
    void testEmpty() {
        List<Job> list = new ArrayList<>();
        FiveBucksVoucher voucher = new FiveBucksVoucher();
        double discount = voucher.getDiscount(list);
        System.out.println(discount);
    }

    @Test
    void testTen() {
        Job j1 = new Job();
        Job j2 = new Job();
        j1.setEarnings("1");
        j2.setEarnings("3");
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        FiveBucksVoucher voucher = new FiveBucksVoucher();
        double discount = voucher.getDiscount(list);
        System.out.println(discount);
    }


}
