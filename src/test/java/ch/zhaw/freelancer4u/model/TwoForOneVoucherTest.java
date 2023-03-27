package ch.zhaw.freelancer4u.model.voucher;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobType;

public class TwoForOneVoucherTest {

    @Test
    public void test1() {
        Job j1 = new Job();
        j1.setEarnings("42.0");
        j1.setJobType(JobType.IMPLEMENT);
        Job j2 = new Job();
        j2.setEarnings("77.0");
        j2.setJobType(JobType.REVIEW);
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        TwoForOneVoucher voucher = new TwoForOneVoucher(JobType.IMPLEMENT);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }

    @Test
    public void test2() {
        Job j1 = new Job();
        j1.setEarnings("33.0");
        j1.setJobType(JobType.TEST);
        Job j2 = new Job();
        j2.setEarnings("77.0");
        j2.setJobType(JobType.TEST);
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        TwoForOneVoucher voucher = new TwoForOneVoucher(JobType.TEST);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }

    @Test
    public void test3() {
        Job j1 = new Job();
        j1.setEarnings("33.0");
        j1.setJobType(JobType.REVIEW);
        Job j2 = new Job();
        j2.setEarnings("77.0");
        j2.setJobType(JobType.REVIEW);
        Job j3 = new Job();
        j3.setEarnings("99.0");
        j3.setJobType(JobType.REVIEW);
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        list.add(j3);
        TwoForOneVoucher voucher = new TwoForOneVoucher(JobType.REVIEW);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }

    @Test
    public void test4() {
        Job j1 = new Job();
        j1.setEarnings("33.0");
        j1.setJobType(JobType.REVIEW);
        Job j2 = new Job();
        j2.setEarnings("77.0");
        j2.setJobType(JobType.REVIEW);
        Job j3 = new Job();
        j3.setEarnings("99.0");
        j3.setJobType(JobType.TEST);
        List<Job> list = new ArrayList<>();
        list.add(j1);
        list.add(j2);
        list.add(j3);
        TwoForOneVoucher voucher = new TwoForOneVoucher(JobType.REVIEW);
        double disc = voucher.getDiscount(list);
        System.out.println(disc);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,77", "3,115.5", "4, 154"})
    public void test5(ArgumentsAccessor accessor) {
        int jobCount = accessor.getInteger(0);
        int discount = accessor.getInteger(1); 
    }
}
