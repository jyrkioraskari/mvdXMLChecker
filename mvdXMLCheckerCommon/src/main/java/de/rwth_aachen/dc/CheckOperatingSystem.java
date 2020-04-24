package de.rwth_aachen.dc;

public class CheckOperatingSystem {

    public static void main(String[] args) {

	String OS = System.getProperty("os.name").toLowerCase();
        System.out.println(OS); // windows 10

        if (OS.contains("win")) {
            System.out.println("We are on Windows"); // We are on Windows
        } else if (OS.contains("mac")) {
            System.out.println("We are on Mac");
        } else if (OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
            System.out.println("We are on Unix or Linux");
        } else if (OS.contains("sunos")) {
            System.out.println("We are on Solaris");
        } else {
            System.out.println("Our OS is not support yet");
        }
        System.out.println(System.getProperty("sun.arch.data.model"));
    }

}
