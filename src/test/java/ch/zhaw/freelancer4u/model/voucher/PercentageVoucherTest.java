package ch.zhaw.freelancer4u.model.voucher;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.zhaw.freelancer4u.model.Job;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 20, 49, 50})
    public void testFifty(int value) {
        Job j1 = new Job();
        j1.setEarnings("50.0");
        List<Job> list = new ArrayList<>();
        list.add(j1);
        PercentageVoucher voucher = new PercentageVoucher(value);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }

    @Test
    public void testTwo() {
        Job j1 = new Job();
        j1.setEarnings("42.0");
        Job j2 = new Job();
        j2.setEarnings("77.0");
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        PercentageVoucher voucher = new PercentageVoucher(42);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }
}
