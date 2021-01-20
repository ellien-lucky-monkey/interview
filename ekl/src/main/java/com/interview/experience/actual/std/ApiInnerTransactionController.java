package com.interview.experience.actual.std;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/transaction")
public class ApiInnerTransactionController {

    @Resource
    private InnerTransactionService innerTransactionService;

    @GetMapping("/inner")
    public void queryStocksByProductIdsAndStationId() {
        innerTransactionService.innerTransactionMethod();
    }
}
