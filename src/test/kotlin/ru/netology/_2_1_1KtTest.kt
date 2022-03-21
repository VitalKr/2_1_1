package ru.netology

import commission
import enterUser
import org.junit.Assert.assertEquals
import org.junit.Test
import sumMonthOut

class _2_1_1KtTest {

    @Test
    fun commission_1_less_75000() {
        //arrange
        val type: Int = 1
        val sumMonth: Int = 10_000_00
        val amount: Int = 74999_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_1_more_75000() {
        //arrange
        val type: Int = 1
        val sumMonth: Int = 10_000_00
        val amount: Int = 75000_00
        val expectedTransfer = 470_00
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_2_less_35_00() {
        //arrange
        val type: Int = 2
        val sumMonth: Int = 10_000_00
        val amount: Int = 34_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_2_procent_less_35_00() {
        //arrange
        val type: Int = 2
        val sumMonth: Int = 10_000_00
        val amount: Int = 36_00
        val expectedTransfer = 35_00
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_2_more_150000_00() {
        //arrange
        val type: Int = 2
        val sumMonth: Int = 10_000_00
        val amount: Int = 150000_00
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_2_less_150000_00() {
        //arrange
        val type: Int = 2
        val sumMonth: Int = 10_000_00
        val amount: Int = 14999_99
        val expectedTransfer = 11249
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_3_more_15000() {
        //arrange
        val type: Int = 3
        val sumMonth: Int = 10_000_00
        val amount: Int = 15000_01
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_3_less_15000() {
        //arrange
        val type: Int = 3
        val sumMonth: Int = 10_000_00
        val amount: Int = 14999_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }
    @Test
    fun commission_3_sumMonth_more_400000() {
        //arrange
        val type: Int = 3
        val sumMonth: Int = 41_000_00
        val amount: Int = 14999_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }
    @Test
    fun commission_3_sumMonth_less_400000() {
        //arrange
        val type: Int = 3
        val sumMonth: Int = 39_999_99
        val amount: Int = 14999_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun commission_4() {
        //arrange
        val type: Int = 4
        val sumMonth: Int = 10_000_00
        val amount: Int = 14999_99
        val expectedTransfer = 0
        // act
        val transfer = commission(
            type,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedTransfer, transfer.toInt())
    }

    @Test
    fun sumMonth_more_150000_00() {
        //arrange
        val type: Int = 1
        val sumMonth: Int = 10_000_00
        val amount: Int = 150_000_01
        val expectedTransfer = "Превышен Ваш лимит 150000 рублей в сутки или 600000 рублей в месяц"
        // act
        val transfer = sumMonthOut(
            amount,
            sumMonth,
            type
        )
        // assert
        assertEquals(expectedTransfer, transfer)
    }

    @Test
    fun sumMonth_less_150000_00() {
        //arrange
        val type: Int = 1
        val sumMonth: Int = 10_000_00
        val amount: Int = 149_999_99
        val expectedTransfer = "В лимиты уложились"
        // act
        val transfer = sumMonthOut(
            amount,
            sumMonth,
            type
        )
        // assert
        assertEquals(expectedTransfer, transfer)
    }
    @Test
    fun sumMonth_more_600000_00() {
        //arrange
        val type: Int = 1
        val sumMonth: Int = 600_000_01
        val amount: Int = 149_999_99
        val expectedTransfer = "Превышен Ваш лимит 150000 рублей в сутки или 600000 рублей в месяц"
        // act
        val transfer = sumMonthOut(
            amount,
            sumMonth,
            type
        )
        // assert
        assertEquals(expectedTransfer, transfer)
    }

    @Test
    fun enter() {
        //arrange
        val rub: String = "10000"
        val kop: String = "99"
        val type: Int = 1
        val typeRead: String = "1"
        val sumMonthRead: String = "15000"
        val sumMonth: Int = 10_000_00
        val amount: Int = 149_999_99
        val expectedEnter = Triple(1000099, 1500000, 1)
        // act
        val enter = enterUser(
            rub,
            kop,
            type,
            typeRead,
            sumMonthRead,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedEnter, enter)
    }

    @Test
    fun enter_error() {
        //arrange
        val rub: String = "Hello"
        val kop: String = "World"
        val type: Int = 1
        val typeRead: String = "in"
        val sumMonthRead: String = "Summer"
        val sumMonth: Int = 10_000_00
        val amount: Int = 149_999_99
        val expectedEnter = Triple(14999999, 1000000, 1)
        // act
        val enter = enterUser(
            rub,
            kop,
            type,
            typeRead,
            sumMonthRead,
            sumMonth,
            amount
        )
        // assert
        assertEquals(expectedEnter, enter)
    }
}