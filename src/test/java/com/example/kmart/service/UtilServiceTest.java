package com.example.kmart.service;

import com.example.kmart.constants.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UtilServiceTest {

    @InjectMocks
    UtilService utilService;

    @Mock
    DateFormat dateFormatter = new SimpleDateFormat(Constants.YYYY_MM_DD);

    @Mock
    DateFormat requestDateFormatter = new SimpleDateFormat(Constants.MMM_DD_YYYY);


    @Test
    public void formatDateTest() {
        String requestDate = "2019-05-01";
        when(dateFormatter.format(any(Date.class), any(StringBuffer.class),
                any(FieldPosition.class)))
                .thenReturn(new StringBuffer(requestDate));
        String date = utilService.formatDate(new Date());
        Assert.assertEquals(date, requestDate);
    }

}
