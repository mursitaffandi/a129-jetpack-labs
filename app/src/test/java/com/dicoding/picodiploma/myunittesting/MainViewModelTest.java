package com.dicoding.picodiploma.myunittesting;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MainViewModelTest {

    // mainViewModel sebagai variable global
    private MainViewModel mainViewModel;

    // @Rule digunakan untuk mengatur rule yang akan terjadi pada kasus pengujian
    @Rule
    // thrown digunakan sebagai variable dari Expected Exception
    public ExpectedException thrown = ExpectedException.none();

    // @Before digunakan untuk memberikan aksi untuk persiapan sebelum melakukan pengujian
    @Before
    // Metode init(), berfungsi untuk memperbarui kelas mainViewModel
    public void init() {
        mainViewModel = new MainViewModel();
    }

    // @Test digunakan untuk melakukan pengujian pada metode yang Anda rancang
    @Test
    public void calculate() {

        // Pada pengujian ini, berisi inputan yang benar dengan pengujian
        String width = "1";
        String length = "2";
        String height = "3";
        mainViewModel.calculate(width, length, height);

        // antara hasil dengan expected sesuai
        assertEquals(6, mainViewModel.result);

    }

    @Test
    //
    public void doubleInputCalculateTest() throws NumberFormatException {
        String width = "1";
        String length = "2.4";
        String height = "3";
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"2.4\"");
        mainViewModel.calculate(width, length, height);
    }

    @Test
    public void characterInputCalculateTest() throws NumberFormatException {
        String width = "1";
        String length = "A";
        String height = "3";
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"A\"");
        mainViewModel.calculate(width, length, height);
    }

    @Test
    public void emptyInputCalculateTest() throws NumberFormatException {
        String width = "1";
        String length = "";
        String height = "3";
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"\"");
        mainViewModel.calculate(width, length, height);
    }

}
