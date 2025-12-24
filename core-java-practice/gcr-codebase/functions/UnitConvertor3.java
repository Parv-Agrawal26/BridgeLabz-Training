class UnitConvertor3 {
    static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }
}
