package com.insert;

import com.insert.controller.InsertController;
import com.insert.entity.InsertEntity;
import com.insert.service.InsertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class InsertControllerTest {

    @Mock
    private InsertService insertService;
    @InjectMocks
    private InsertController insertController;

    private static double median(List<Long> list) {
        int size = list.size();
        long mid1 = list.get((size / 2) - 1);
        long mid2 = list.get(size / 2);
        if (size % 2 == 1) {
            return list.get(size / 2);
        }
        return (mid1 + mid2) / 2.0;
    }

    @Test
    void testResponse() {
        List<InsertEntity> list = new ArrayList<>();
        insertService.removeAllRecords();
        for (int i = 1; i <= 100000; i++) { //
            list.add(new InsertEntity("some text"));
        }
        insertService.saveAll(list);
        var sum = 0L;
        List<Long> listRequests = new ArrayList<>();
        for (int k = 1; k <= 10; k++)
            for (int i = 1; i <= 100000; i++) {
                long start = System.currentTimeMillis();
                insertController.getValue(i);
                long time = (System.currentTimeMillis() - start);
                listRequests.add(time);
            }

        for (Long time : listRequests) {
            sum += time;
        }
        double median = median(listRequests);
        System.out.println("Median: " + median);
        System.out.println("Total Time: " + sum);
    }
}
