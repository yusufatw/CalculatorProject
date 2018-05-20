package id.cathode.tempconverter;

public class Conventer {
    public enum Unit {
        Celsius,
        Delisle,
        Fahrenheit,
        Kelvin,
        Newton,
        Rankine,
        Reamur,
        Romer;

        public static Unit fromString(String text) throws IllegalAccessException {
            if (text != null){
                for (Unit unit : Unit.values()){
                    if (text.equalsIgnoreCase(unit.toString())){
                        return unit;
                    }
                }
            }
                throw new IllegalAccessException("Cannot find a value for " + text);
        }
    }

    private final double convertValue;

    public Conventer(Unit from, Unit to){
        double result =0, input = 0;

        switch (from){
            case Celsius:
                if (to == Unit.Delisle){
                    result = (100 - input) * 1.5;
                } else if (to == Unit.Fahrenheit){
                    result = input * 1.8 + 32;
                } else if (to == Unit.Kelvin){
                    result = input + 273.15;
                } else if (to == Unit.Newton){
                    result = input * 33 / 100;
                } else if (to == Unit.Rankine){
                    result = 1.8 * (input + 491.67);
                } else if (to == Unit.Reamur){
                    result = input * 0.8;
                } else if (to == Unit.Romer){
                    result = input * 21 / 40 + 7.5;
                }
                break;

            case Delisle:
                if (to == Unit.Celsius){
                    result = 100 - input * 2 / 3;
                } else if (to == Unit.Fahrenheit){
                    result = 212 - input * 1.2;
                } else if (to == Unit.Kelvin){
                    result = 373.15 - input * 2 /3;
                } else if (to == Unit.Newton){
                    result = 33 - input * 0.22;
                } else if (to == Unit.Rankine){
                    result = 671.67 - input * 1.2;
                } else if (to == Unit.Reamur){
                    result = 80 - input * 8 / 15;
                } else if (to == Unit.Romer){
                    result = 60 - input * 0.35;
                }
                break;

            case Fahrenheit:
                if (to == Unit.Celsius){
                    result = (input - 32) / 1.8;
                } else if (to == Unit.Delisle){
                    result = (212 - input) * 5 / 6;
                } else if (to == Unit.Kelvin){
                    result = (input + 459.67) / 1.8;
                } else if (to == Unit.Newton){
                    result = (input - 32) * 11 / 60;
                } else if (to == Unit.Rankine){
                    result = input + 459.67;
                } else if (to == Unit.Reamur){
                    result = (input - 32) / 0.44;
                } else if (to == Unit.Romer){
                    result = (input - 32) * 7 / 24 + 7.5;
                }
                break;

            case Kelvin:
                if (to == Unit.Celsius){
                    result = input - 273.15;
                } else if (to == Unit.Delisle){
                    result = (373.15 - input) * 1.5;
                } else if (to == Unit.Fahrenheit){
                    result = input * 1.8 - 459.67;
                } else if (to == Unit.Newton){
                    result = (input - 273.15) * 33 / 100;
                } else if (to == Unit.Rankine){
                    result = input * 1.8;
                } else if (to == Unit.Reamur){
                    result = (input - 273.15) * 0.8;
                } else if (to == Unit.Romer){
                    result = (input - 273.15) * 21 / 40 + 7.5;
                }
                break;

            case Newton:
                if (to == Unit.Celsius){
                    result = input * 100 / 33;
                } else if (to == Unit.Delisle){
                    result = (33 - input) * 50 / 11;
                } else if (to == Unit.Fahrenheit){
                    result = input * 60 /11 +32;
                } else if (to == Unit.Kelvin){
                    result = input * 100 / 33 + 273.15;
                } else if (to == Unit.Rankine){
                    result = input * 60 / 11 + 491.67;
                } else if (to == Unit.Reamur){
                    result = input * 80 / 33;
                } else if (to == Unit.Romer){
                    result = input * 35 / 22 + 7.5;
                }
                break;

            case Rankine:
                if (to == Unit.Celsius){
                    result = input / 1.8 + 273.15;
                } else if (to == Unit.Delisle){
                    result = (671.67 - input) * 5 / 6;
                } else if (to == Unit.Fahrenheit){
                    result = input - 459.67;
                } else if (to == Unit.Kelvin){
                    result = input / 1.8;
                } else if (to == Unit.Newton){
                    result = (input - 491.67) * 11 / 60;
                } else if (to == Unit.Reamur){
                    result = (input / 1.8 + 273.15) * 0.8;
                } else if (to == Unit.Romer){
                    result = (input - 491.67) * 7 / 24 + 7.5;
                }
                break;

            case Reamur:
                if (to == Unit.Celsius){
                    result = input / 0.8;
                } else if (to == Unit.Delisle){
                    result = (80 - input) * 1.875;
                } else if (to == Unit.Fahrenheit){
                    result = input * 2.25 + 32;
                } else if (to == Unit.Kelvin){
                    result = input / 0.8 + 273.15;
                } else if (to == Unit.Newton){
                    result = input * 33 / 80;
                } else if (to == Unit.Rankine){
                    result = input * 2.25 + 491.67;
                } else if (to == Unit.Romer){
                    result = input * 21 /32 +75;
                }
                break;

            case Romer:
                if (to == Unit.Celsius){
                    result = (input - 7.5) * 40 / 21;
                } else if (to == Unit.Delisle){
                    result = (60 - input) * 20 / 7;
                } else if (to == Unit.Fahrenheit){
                    result = (input - 7.5) * 24 / 7 + 32;
                } else if (to == Unit.Kelvin){
                    result = (input - 7.5) * 40 / 21 + 273.15;
                } else if (to == Unit.Newton){
                    result = (input - 7.5) * 22 / 35;
                } else if (to == Unit.Rankine){
                    result = (input - 7.5) * 24 / 7 + 491.67;
                } else if (to == Unit.Reamur){
                    result = (input - 7.5) * 32 / 21;
                }
                break;
        }

        convertValue = result;
    }

    public double convert(double input) {
        return input = convertValue;
    }
}
