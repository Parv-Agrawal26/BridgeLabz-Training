class EarthVolumeCalculation {

    public static void main(String[] args) {

        double radiusInKilometers = 6378;

        double pi = 3.141592653589793;

        double kilometerToMile = 1.6;

        double volumeInCubicKilometers = (4.0 / 3.0) * pi * radiusInKilometers * radiusInKilometers
                * radiusInKilometers;

        double radiusInMiles = radiusInKilometers / kilometerToMile;

        double volumeInCubicMiles = (4.0 / 3.0) * pi * radiusInMiles * radiusInMiles * radiusInMiles;

        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeInCubicKilometers +
                        " and cubic miles is " + volumeInCubicMiles);
    }
}
