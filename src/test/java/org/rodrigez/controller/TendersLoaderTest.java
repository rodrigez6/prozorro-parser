package org.rodrigez.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rodrigez.TendersLoader;
import org.rodrigez.model.domain.Tender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TendersLoaderTest {

    @Autowired
    private TendersLoader tendersLoader;

    @Test
    public void loadTender() {
        Tender tender = tendersLoader.loadTender("https://public.api.openprocurement.org/api/2.4/tenders/530a2bd777154e6ebd0225af226b10f6");
        Assert.assertEquals(tender.getTenderId(), "UA-2016-02-03-000079-b");
        assertNull(tender.getAuctionUrl());
        Assert.assertEquals(tender.getValueAmount(), 9356.52, 0.001);
        Assert.assertEquals(tender.getBids(), new HashSet<>());
    }

}