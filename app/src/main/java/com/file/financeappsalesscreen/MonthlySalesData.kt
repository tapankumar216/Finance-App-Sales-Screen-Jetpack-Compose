package com.file.financeappsalesscreen

data class MonthlySalesData(
    val month: String,
    val salesInThousand: Int
)

val year2022Sales = mutableListOf(
    MonthlySalesData(month = "Jan", salesInThousand = 13),
    MonthlySalesData(month = "Feb", salesInThousand = 24),
    MonthlySalesData(month = "Mar", salesInThousand = 16),
    MonthlySalesData(month = "Apr", salesInThousand = 32),
    MonthlySalesData(month = "May", salesInThousand = 26),
    MonthlySalesData(month = "Jun", salesInThousand = 19),
    MonthlySalesData(month = "Jul", salesInThousand = 12),
    MonthlySalesData(month = "Aug", salesInThousand = 18),
    MonthlySalesData(month = "Sep", salesInThousand = 11),
    MonthlySalesData(month = "Oct", salesInThousand = 21),
    MonthlySalesData(month = "Nov", salesInThousand = 23),
    MonthlySalesData(month = "Dec", salesInThousand = 19)
)

val largestSalesValue = year2022Sales.maxOf {
    it.salesInThousand
}